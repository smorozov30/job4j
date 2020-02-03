package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Chat {
    private List<String> answers;
    private List<String> writing;
    private Scanner scanner;
    private static final String PAUSE_ON = "стоп";
    private static final String PAUSE_OFF = "продолжить";
    private static final String EXIT = "закончить";

    /**
     * Метод ведет диалог с пользователем.
     * Запрашивается ввод пользователя у метода getInput().
     * Ввод пользователя и ответ чата записывается в файл log.txt.
     * Переменная recording используется для вкл\выкл записи в файл log.txt.
     *  Если ввод "стоп", то запись в файл log.txt останавливается(recording = false),
     *      но пользователь может продолжать вводить строки в консоли.
     *  Если ввод "продолжить", возобнавляется запись в файл log.txt.
     *  Если ввод "закончить", программа завершает работу.
     */
    private void talk() {
        if (this.answers == null) {
            this.fillAnswers();
        }
        if (this.writing == null) {
            this.writing = new ArrayList<>();
        }
        boolean recording = true;
        String userInput = this.getInput();
        while (!userInput.equals(EXIT)) {
            if (userInput.equals(PAUSE_ON)) {
                this.writing.add(userInput);
                recording = false;
            } else if (userInput.equals(PAUSE_OFF)) {
                this.writing.add(userInput);
                recording = true;
            } else if (recording) {
                this.writing.add(userInput);
                String answer = getAnswer();
                System.out.println(answer);
                this.writing.add(answer);
            }
            userInput = this.getInput();
        }
        this.writing.add(userInput);
        this.write();
        this.scanner.close();
    }

    /**
     * Метод записывает строки диалога в файл log.txt.
     */
    private void write() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./log.txt"))) {
            for (String string : this.writing) {
                writer.write(string + System.lineSeparator());
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод возвращает из коллекции ответов рандомный ответ на ввод пользователя.
     * @return - строка-ответ.
     */
    private String getAnswer() {
        return this.answers.get(new Random().nextInt(this.answers.size()));
    }

    /**
     * Метод получает ввод пользователя с консоли и возвращает эту стороку.
     * @return - строка ввод пользователя.
     */
    private String getInput() {
        if (this.scanner == null) {
            this.scanner = new Scanner(System.in);
        }
        return this.scanner.nextLine();
    }

    /**
     * Метод заполняет вариантами ответа коллекцию answers из файла answers.txt,
     * которая используется для ответов на ввод пользователя.
     */
    private void fillAnswers() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./answers.txt"));
            this.answers = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                this.answers.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Chat().talk();
    }
}
