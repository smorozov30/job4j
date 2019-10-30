package ru.job4j.condition;

public class Max {
    public static int max(int left, int right) {
        int result = (left > right) ? left : right;
        return result;
    }
    public static int max(int left, int right, int top) {
        int result = max(left, max(right, top));
        return result;
    }
    public static int max(int left, int right, int top, int bottom) {
        int result = max(max(left, right), max(top, bottom));
        return result;
    }
}