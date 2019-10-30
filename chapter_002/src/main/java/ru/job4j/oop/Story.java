package ru.job4j.oop;

public class Story {
    public static void main(String[] args) {
        Pioneer petya = new Pioneer();
        Girl red = new Girl();
        Wolf grey = new Wolf();
        red.help(petya);
        grey.eat(red);
        petya.kill(grey);
    }
}
