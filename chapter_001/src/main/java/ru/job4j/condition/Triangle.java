package ru.job4j.condition;

public class Triangle {
    public static boolean exist(double ab, double ac, double bc) {
        boolean result = false;
        if (((ab + ac) > bc) && ((ab + bc) > ac) && ((bc + ac) > ab)) {
            result = true;
        }
        return result;
    }
}
