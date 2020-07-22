package ru.job4j.design.spr;

import java.util.List;
import java.util.function.Predicate;

public class HRReport extends ReportEngine {

    public HRReport(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary").append(System.lineSeparator());
        List<Employer> employers = store.findBy(filter);
        employers.sort(new EmployerSalaryComparator());
        for (Employer employer : employers) {
            text.append(employer.getName()).append(";")
                    .append(employer.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
