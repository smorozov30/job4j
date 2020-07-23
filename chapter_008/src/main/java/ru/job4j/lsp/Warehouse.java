package ru.job4j.lsp;

import java.util.GregorianCalendar;

public class Warehouse extends Storage {

    protected Warehouse(double percentShelfLifeMin, double percentShelfLifeMax) {
        super(percentShelfLifeMin, percentShelfLifeMax);
    }

    @Override
    protected boolean checkProduct(Food food) {
        double allDate = food.getExpireDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        double nowDate = new GregorianCalendar().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        double percent = (nowDate * 100.0 / allDate);
        return percent < this.percentShelfLifeMax;
    }
}
