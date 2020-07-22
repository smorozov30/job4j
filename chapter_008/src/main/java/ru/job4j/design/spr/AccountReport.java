package ru.job4j.design.spr;

import java.util.function.Predicate;

public class AccountReport extends ReportEngine {
    private double dollarRate;

    public AccountReport(Store store, double dollarRate) {
        super(store);
        this.dollarRate = dollarRate;
    }

    @Override
    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employer employer : store.findBy(filter)) {
            text.append(System.lineSeparator());
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary() * this.dollarRate).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
