package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Chat {
    private List<String> answers;
    private BufferedWriter writer;
    private Scanner scanner;

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
        boolean recording = true;
        try {
            String userInput = this.getInput();
            while (!userInput.equals("закончить")) {
                if (userInput.equals("стоп")) {
                    this.write(userInput);
                    recording = false;
                } else if (userInput.equals("продолжить")) {
                    this.write(userInput);
                    recording = true;
                } else if (recording) {
                    this.write(userInput);
                    String answer = getAnswer();
                    System.out.println(answer);
                    this.write(answer);
                }
                userInput = this.getInput();
            }
            this.write(userInput);
            this.writer.close();
            this.scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод записывает строки диалога в файл log.txt.
     * @param input - строка которую нужно записать.
     */
    private void write(String input) {
        try {
            if (this.writer == null) {
                this.writer = new BufferedWriter(new FileWriter("./log.txt"));
            }
            this.writer.write(input + "\n");
            this.writer.flush();
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
