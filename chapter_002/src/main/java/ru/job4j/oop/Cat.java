package ru.job4j.oop;

/**
 * Класс описывающий кошку.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Cat {

    /**
     * Поле класса описывающее имя кошки.
     */
    private String name;

    /**
     * Поле класса описывающее тип еды для кошки.
     */
    private String food;

    /**
     * Метод позволяет дать имя кошке.
     * @param nick - имя, которое нужно дать кошке.
     */
    public void giveNick(String nick) {
        this.name = nick;
    }

    /**
     * Метод позволяет указать еду для кошки.
     * @param meat
     */
    public void eat(String meat) {
        this.food = meat;
    }

    /**
     * Метод выводит информацию о кошке: имя и еду.
     */
    public void show() {
        System.out.println(this.name + " " + this.food);
    }
}
