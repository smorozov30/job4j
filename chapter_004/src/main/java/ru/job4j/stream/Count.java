package ru.job4j.stream;

import java.util.List;

public class Count {
    public int count(List<Integer> data) {
        return data.stream().filter(num -> num % 2 == 0).map(num -> (int) Math.pow(num, 2)).reduce(0, Integer::sum);
    }
}
