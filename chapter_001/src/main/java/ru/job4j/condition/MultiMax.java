package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int thrid) {
        int resultOne = (first > second) ? first : second;
        int resultTwo = (resultOne > thrid) ? resultOne : thrid;
        return resultTwo;
    }
}
