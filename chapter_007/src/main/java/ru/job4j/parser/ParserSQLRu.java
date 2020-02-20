package ru.job4j.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.quartz.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class ParserSQLRu implements Job {
    private static final Logger LOG = LogManager.getLogger(ParserSQLRu.class.getName());

    /**
     * Переменная предоставляет интерфейс для сохранения вакансий в базу данных.
     */
    private static Saver saver;

    /**
     * Переменная используется во время первого запуска для получения вакансий размещенных
     * после определенного момента времени, а затем для хранения времени последнего запуска приложения.
     */
    private static String borderTime = "31 дек 19, 23:59";

    /**
     * Переменная хранит ссылки на 2-10 страницы с вакансиями.
     */
    private List<String> linksToNextPages;

    /**
     * Переменная используется при перемещении по страницам.
     */
    private int cursor = 0;
    private Document document;

    /**
     * Метод осуществляет подключение к страницам сайта.
     * @param url - путь для подключения.
     */
    public void connectToPage(String url) {
        try {
            this.document = Jsoup.connect(url).get();
            LOG.info("Подключение к странице " + url + " создано.");
            if (this.linksToNextPages == null) {
                this.pageLinks();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод получает ссылки на 2-10 страницы вакансий.
     */
    private void pageLinks() {
        this.linksToNextPages = new ArrayList<>();
        Elements elements = this.document.getElementsByAttributeValue("class", "sort_options");
        Elements links = elements.select("a");
        for (Element link : links) {
            this.linksToNextPages.add(link.attr("href"));
        }
        LOG.info("Получены ссылки на 2-10 страницы с вакансиями.");
    }

    /**
     * Метод подключается к странице вакансии и получает текстовое описание вакансии.
     * @param url - путь к странице с описанием вакансии.
     * @return
     */
    public String getTextVacancy(String url) {
        String text = null;
        try {
            Document tempDoc = Jsoup.connect(url).get();
            Elements tempEls = tempDoc.getElementsByAttributeValue("class", "msgBody");
            text = tempEls.get(1).text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOG.info("Получено описание " + url + " вакансии.");
        return text;
    }

    /**
     * Метод получает все вакансии со страницы.
     * 72-75 строки: условие для проверки даты размещения вакансии.
     *               При первом запуске приложения, будут получены вакансии размещенные после конца 2019 года и
     *               затем изменена временная граница поиска вакансий на текущее время для последующих запусков.
     *               При последующих запусках раз в сутки - поиск вакансий будет осуществляться с текущего времени
     *               до времени последнего запуска.
     * 82-83 строки: условие выбирает вакансии в названии которых упоминается Java, но не JavaScript.
     * 85 строка: условие проверяет содержится ли уже в базе данных вакансия с именем соответствующим текущему.
     * 93-99 строки: при первом запуске данный блок кода, осуществляет переход на последующие страницы сайта с
     *               вакансиями, для поиска вакансий размещенных с начала 2020 года.
     */
    public void getAllVacancy() {
        LOG.info("Начало получения вакансий со страницы.");
        Element table = this.document.select("table").get(2);
        Elements rows = table.select("tr");
        for (int index = 4; index < rows.size(); index++) {
            Element row = rows.get(index);
            Elements cols = row.select("td");
            String dateVacancy = cols.get(5).text();
            if (!new DateSQLRu().checkDate(dateVacancy, borderTime)) {
                borderTime = LocalDateTime.now().minusDays(1).format(new DateSQLRu().getFullFormatter());
                break;
            }
            String nameVacancy = cols.get(1).child(0).text();
            if (nameVacancy.matches(".*[jJ]ava.*")
                    && !nameVacancy.matches(".*[sS]cript.*")) {
                if (!saver.checkDuplicate(nameVacancy)) {
                    String url = cols.get(1).child(0).attr("href");
                    String text = this.getTextVacancy(url);
                    saver.add(new Vacancy(nameVacancy, url, text));
                    LOG.info("Отправка вакансии " + nameVacancy + " в базу данных.");
                }
            }
            if (index == rows.size() - 1) {
                this.connectToPage(this.linksToNextPages.get(this.cursor++));
                table = this.document.select("table").get(2);
                rows = table.select("tr");
                index = 4;
                LOG.info("Переход на следующую страницу для поиска вакансий.");
            }
        }
        LOG.info("Получение вакансий закончено.");
    }

    /**
     * Метод подключается к стартовой странице вакансий и начинет получение вакансий со страницы.
     */
    public void startParsing() {
        this.connectToPage("https://www.sql.ru/forum/job-offers/1");
        this.getAllVacancy();
    }

    /**
     * Метод начинает выполнение приложения по расписанию класса ParserQuartz.
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOG.info("Запуск парсинга по расписанию.");
        this.startParsing();
    }

    /**
     * Выполнение программы начинается с метода main.
     * @param args - аргументы передаваемы пользователем в командной строке,
     *             в данном приложении принимается имя файла конфигурации.
     * @throws SchedulerException
     */
    public static void main(String[] args) throws SchedulerException {
        Config config = new Config();
        config.init(args[0]);
        saver = new DBSaver(config);
        LOG.info("Запуск приложения.");
        new ParserQuartz(config).start();
    }
}
