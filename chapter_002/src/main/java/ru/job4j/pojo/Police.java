package ru.job4j.pojo;

import java.util.Date;

/**
 * Класс полиция.
 *
 * @author Sergey Morozov(moroz.future@gmail.com)
 * @version 1.0
 */
public class Police {
    public static void main(String[] args) {
        License license = new License();
        license.setOwner("Sergey");
        license.setModel("VW");
        license.setCode("x000xx");
        license.setCreated(new Date());

        System.out.println(license.getOwner() + " has a car - " + license.getModel() + " : " + license.getCode());
    }
}
