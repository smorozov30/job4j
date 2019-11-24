package ru.job4j.comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        int count = Math.min(o1.length(), o2.length());
        for (int index = 0; index < count; index++) {
            result = Character.compare(o1.charAt(index), o2.charAt(index));
            if (result != 0) {
                break;
            }
        }
        if (result == 0) {
            result = Integer.compare(o1.length(), o2.length());
        }
        return result;
    }
}
