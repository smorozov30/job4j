package ru.job4j.pojo;

import java.util.Date;

/**
 * Класс колледж.
 *
 * @author Sergey Morozov(moroz.future@gmail.com)
 * @version 1.0
 */
public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Sergey");
        student.setSurname("Morozov");
        student.setGroup("IA");
        student.setEntrance(new Date());

        System.out.println(student.getName() + " " + student.getSurname() + " from: " + student.getGroup()
                + ", university entrance: " + student.getEntrance());
    }
}
