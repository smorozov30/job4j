package ru.job4j.comparator;

import java.util.*;

public class SortingDepartments {
    public static List<List<String>> separator(String[] strings) {
        List<List<String>> lists = new ArrayList<>(strings.length);
        for (String s : strings) {
            lists.add(new ArrayList(Arrays.asList(s.split("\\."))));
        }
        return lists;
    }
    public static TreeSet<String> collectAndSorting(List<List<String>> lists, Comparator<String> comparator) {
        TreeSet<String> set = new TreeSet<>(comparator);
        for (List<String> list : lists) {
            StringBuilder department = new StringBuilder();
            for (String string : list) {
                department.append(string);
                set.add(department.toString());
                department.append("\\");
            }
        }
        return set;
    }

    public static void main(String[] args) {
        String[] strings = {"K1.SK1", "K1.SK2", "K1.SK1.SSK1", "K1.SK1.SSK2", "K2", "K2.SK1.SSK1", "K2.SK1.SSK2"};
        TreeSet<String> result = collectAndSorting(separator(strings), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(result);
        TreeSet<String> result2 = collectAndSorting(separator(strings), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int minimal = Math.min(o1.length(), o2.length());
                for (int index = 0; index < minimal; index++) {
                    Character leftChar = o1.charAt(index);
                    Character rightChar = o2.charAt(index);
                    if (rightChar.compareTo(leftChar) != 0) {
                        return rightChar - leftChar;
                    }
                }
                return o1.length() - o2.length();
            }
        });
        System.out.println(result2);
    }
}
