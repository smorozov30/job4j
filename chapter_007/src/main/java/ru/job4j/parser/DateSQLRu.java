package ru.job4j.parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.Map;

public class DateSQLRu {
    private Map<Long, String> monthNameMap;

    private void init() {
        this.monthNameMap = new HashMap<>();
        this.monthNameMap.put(1L, "янв");
        this.monthNameMap.put(2L, "фев");
        this.monthNameMap.put(3L, "мар");
        this.monthNameMap.put(4L, "апр");
        this.monthNameMap.put(5L, "май");
        this.monthNameMap.put(6L, "июн");
        this.monthNameMap.put(7L, "июл");
        this.monthNameMap.put(8L, "авг");
        this.monthNameMap.put(9L, "сен");
        this.monthNameMap.put(10L, "окт");
        this.monthNameMap.put(11L, "ноя");
        this.monthNameMap.put(12L, "дек");
    }

    /**
     * Метод проверяет до или после временной границы находится дата размещения вакансии.
     * @param dateVacancy - дата размещения вакансии.
     * @param borderTime - дата для сравнения.
     * @return
     */
    public boolean checkDate(String dateVacancy, String borderTime) {
        this.init();
        return this.getTime(dateVacancy).isAfter(this.getTime(borderTime));
    }

    /**
     * Метод принимает дату в тестовом формате, и преобразует в LocalDateTime для удобства
     * дальнейшего сравнения дат при работе приложения.
     * @param dateTime - дата и время в текстовом формате.
     * @return
     */
    private LocalDateTime getTime(String dateTime) {
        LocalDateTime result;
        if (dateTime.contains("сегодня")) {
            String tempTime = dateTime.split(", ")[1];
            String tempDate = LocalDateTime.now().format(this.getSimpleFormatter());
            result = this.getTime(tempDate + ", " + tempTime);
        } else if (dateTime.contains("вчера")) {
            String tempTime = dateTime.split(", ")[1];
            String tempDate = LocalDateTime.now().minusDays(1).format(this.getSimpleFormatter());
            result = this.getTime(tempDate + ", " + tempTime);
        } else {
            result = LocalDateTime.parse(dateTime, this.getFullFormatter());
        }
        return result;
    }

    /**
     * Метод возвращает форматировщик даты.
     * @return
     */
    public DateTimeFormatter getSimpleFormatter() {
        this.init();
        return new DateTimeFormatterBuilder()
                .appendPattern("d ")
                .appendText(ChronoField.MONTH_OF_YEAR, this.monthNameMap)
                .appendPattern(" yy")
                .toFormatter();
    }

    /**
     * Метод возвращает форматировщик для даты с временем в часах и минутах.
     * @return
     */
    public DateTimeFormatter getFullFormatter() {
        this.init();
        return new DateTimeFormatterBuilder()
                .appendPattern("d ")
                .appendText(ChronoField.MONTH_OF_YEAR, this.monthNameMap)
                .appendPattern(" yy,")
                .appendPattern(" HH:mm")
                .toFormatter();
    }
}
