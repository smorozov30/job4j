package ru.job4j.design.spr;

import java.util.function.Predicate;

public class HTMLReport extends ReportEngine {

    public HTMLReport(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html>");
        text.append("<head>");
        text.append("<meta>");
        text.append("<title>Пример отчета</title>");
        text.append("</head>");
        text.append("<body>");
        text.append("<table><tr><th>Name</th><th>Hired</th><th>Fired</th><th>Salary</th></tr>");
        for (Employer employer : store.findBy(filter)) {
            text.append("<tr>")
                .append("<td>").append(employer.getName()).append("</td>")
                .append("<td>").append(employer.getHired()).append("</td>")
                .append("<td>").append(employer.getFired()).append("</td>")
                .append("<td>").append(employer.getSalary()).append("</td>")
                .append("</tr>");
        }
        text.append("</table>");
        text.append("</body>");
        text.append("<html>");
        return text.toString();
    }
}
