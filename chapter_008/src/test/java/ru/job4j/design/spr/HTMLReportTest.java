package ru.job4j.design.spr;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class HTMLReportTest {

    @Test
    public void whenHTMLGenerate() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new HTMLReport(store);
        StringBuilder expect = new StringBuilder()
            .append("<html>")
            .append("<head>")
            .append("<meta>")
            .append("<title>Пример отчета</title>")
            .append("</head>")
            .append("<body>")
            .append("<table><tr><th>Name</th><th>Hired</th><th>Fired</th><th>Salary</th></tr>")
            .append("<tr>")
            .append("<td>").append(worker.getName()).append("</td>")
            .append("<td>").append(worker.getHired()).append("</td>")
            .append("<td>").append(worker.getFired()).append("</td>")
            .append("<td>").append(worker.getSalary()).append("</td>")
            .append("</tr>")
            .append("</table>")
            .append("</body>")
            .append("<html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}