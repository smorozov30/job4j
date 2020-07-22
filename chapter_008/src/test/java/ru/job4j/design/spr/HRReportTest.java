package ru.job4j.design.spr;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class HRReportTest {

    @Test
    public void whenHRGenerate() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer ivan = new Employer("Ivan", now, now, 200);
        Employer sergey = new Employer("Sergey", now, now, 300);
        Employer boris = new Employer("Boris", now, now, 100);
        store.add(ivan);
        store.add(sergey);
        store.add(boris);
        ReportEngine engine = new HRReport(store);
        String expect = "Name; Salary"
                + System.lineSeparator()
                + "Sergey;300.0;" + System.lineSeparator()
                + "Ivan;200.0;" + System.lineSeparator()
                + "Boris;100.0;"
                + System.lineSeparator();
        assertThat(engine.generate(em -> true), is(expect));
    }
}