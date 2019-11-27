package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Count {
    public int count(List<Integer> data) {
        List<Integer> onlyEven = data.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        List<Integer> squared = new ArrayList<>();
        onlyEven.forEach(num -> squared.add((int) Math.pow(num, 2)));
        var sum = squared.stream().reduce(0, Integer::sum);
        return sum;
    }
}
