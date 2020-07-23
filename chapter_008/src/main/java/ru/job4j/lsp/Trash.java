package ru.job4j.lsp;

import java.util.GregorianCalendar;

public class Trash extends Storage {

    protected Trash(double percentShelfLifeMin, double percentShelfLifeMax) {
        super(percentShelfLifeMin, percentShelfLifeMax);
    }

    @Override
    protected boolean checkProduct(Food food) {
        return new GregorianCalendar().getTimeInMillis() > food.getExpireDate().getTimeInMillis();
    }
}
