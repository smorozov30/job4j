package ru.job4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class Search {

	/**
	 * Метод выводит подсказку в консоль если пользователь ввел ключ -h.
	 */
	private void info() {
		System.out.println("Пример ввода: -d c:/project/job4j -n *.java -m -o c:/project/job4j/log.txt");
		System.out.println("-d директория для поиска файлов.");
		System.out.println("-n расширение файлов для поиска.");
		System.out.println("Ключи для -n: -m поиск по маске, -f полное совпадение имени, -r поиск по регуляному выражению.");
		System.out.println("-o директория и название файла для записи выходных данных.");
		System.out.println("-h подсказка по вводу команды.");
	}

	/**
	 * Метод осуществляет поиск файло в заданной папке и подпапках по регулярному выражению.
	 * @param parent - папка начала поиска.
	 * @param regex - регулярное выражение.
	 * @return - коллекцию файлов найденных по регулярному выражению.
	 */
    private List<File> files(String parent, String regex) {
        File start = new File(parent);
        List<File> files = new ArrayList<>();
        Queue<File> data = new LinkedList<>();
        data.offer(start);
        while (!data.isEmpty()) {
            File el = data.poll();
            if (el.isDirectory()) {
                for (File child : el.listFiles()) {
                    data.offer(child);
                }
            } else {
                if (el.getName().matches(regex)) {
                    files.add(el);
                }
            }
        }
        return files;
    }

	/**
	 * Метод возвращает регулярное выражение в зависимости от ключа введеного пользователем, где при
	 * 		-f - для поиска вернется полное название файла введенное пользователем
	 * 		-m - вернется регулярное выражение, образованное на основе маски введенной пользователем.
	 * @param expression - выражение для поиска.
	 * @param mark - ключ для выражения.
	 * @return - регулярное выражение.
	 */
    private String getRegex(String expression, String mark) {
		String regex = null;
		if (mark.matches("-f")) {
			regex = expression;
		} else if (mark.matches("-m")) {
			regex = this.regexForMask(expression);
		}
		return regex;
    }

	/**
	 * Метод получает выражение введенное пользователем по которому будет осуществляться поиск файлов
	 * 		и преобразует его в регулярное выражение.
	 * Выражение - полное название файла, либо маска.
	 * @param expression - выражение введенное пользователем в командной строке  после ключа -n.
	 * @return - регулярное выражение для поиска.
	 */
	private String regexForMask(String expression) {
		StringBuilder regex = new StringBuilder();
		char[] characters = expression.toCharArray();
		for (Character element : characters) {
			if (Character.isLetterOrDigit(element)) {
				regex.append(element);
			}
			if (element == '?') {
				regex.append("\\w");
			}
			if (element == '*') {
				regex.append("\\w+");
			}
			if (element == '.') {
				regex.append("\\.");
			}
		}
		return regex.toString();
	}

	/**
	 * Метод начинает выполнение программы поиска файлов по заданным пользователем параметрам.
	 * regex - Метод получает регулярное выражение по которому будет искать файлы.
	 * files - список файлов найденных по regex в указанной пользователем папке и подпапках.
	 * out - поток заносит все найденные названия файлов в указанный пользователем текстовый файл.
	 * @param args - параметры введенные пользователем в cmd.
	 */
	private void start(String[] args) {
		if (args.length == 1 && args[0].equals("-h")) {
			this.info();
			return;
		}
		Args arguments = new Args(args);
		try {
			String regex = this.getRegex(arguments.expression(), arguments.mark());
			List<File> files = this.files(arguments.directory(), regex);
			PrintWriter out = new PrintWriter(new FileOutputStream(arguments.output()), true);
			for (File file : files) {
				out.println(file.getName());
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Старт программы начинается с метода main.
	 * @param args - параметры введенные пользователем в cmd.
	 */
	public static void main(String[] args) {
		new Search().start(args);
	}	
}
































