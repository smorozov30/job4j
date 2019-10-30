package ru.job4j.converter;

public class Converter {

    public static int rubleToEuro(int value) {
        return value / 70;
    }

    public static int rubleToDollar(int value) {
        return value / 60;
    }

    public static int euroToRuble(int value) {
        return value * 70;
    }

    public static int dollarToRuble(int value) {
        return value * 60;
    }

    public static void main(String[] args) {

        int in = 140;
        int expected = 2;
        int out = rubleToEuro(in);
        boolean passed = expected == out;
        System.out.println("140 rubles are 2. Test result : " + passed);

        in = 180;
        expected = 3;
        out = rubleToDollar(in);
        passed = expected == out;
        System.out.println("180 rubles are 3. Test result : " + passed);

        in = 10;
        expected = 700;
        out = euroToRuble(in);
        passed = expected == out;
        System.out.println("10 euro are 700. Test result : " + passed);

        in = 5;
        expected = 300;
        out = dollarToRuble(in);
        passed = expected == out;
        System.out.println("5 dollars are 300. Test result : " + passed);

//        int euro = rubleToEuro(140);
//        System.out.println("140 rubles are " + euro + " euro.");
//        int dollar = rubleToDollar(600);
//        System.out.println("600 rubles are " + dollar + " dollars.");
//
//        int ruble = euroToRuble(10);
//        System.out.println("10 euro are " + ruble + " rubles.");
//        ruble = dollarToRuble(15);
//        System.out.println("15 dollars are " + ruble + " rubles.");
    }
}
