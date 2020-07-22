package ru.job4j.design.spr;

import java.util.Comparator;

public class EmployerSalaryComparator implements Comparator<Employer> {
    @Override
    public int compare(Employer o1, Employer o2) {
        return Double.compare(o2.getSalary(), o1.getSalary());
    }
}
