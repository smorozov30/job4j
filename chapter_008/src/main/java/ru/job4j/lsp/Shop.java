package ru.job4j.lsp;

import java.util.GregorianCalendar;

public class Shop extends Storage {

    protected Shop(double percentShelfLifeMin, double percentShelfLifeMax) {
        super(percentShelfLifeMin, percentShelfLifeMax);
    }

    @Override
    protected boolean checkProduct(Food food) {
        double allDate = food.getExpireDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        double nowDate = new GregorianCalendar().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        double percent = (nowDate * 100.0 / allDate);
        if (percent >= 75) {
            food.setDiscount(50.0);
        }
        return  percent >= this.percentShelfLifeMin && percent <= this.percentShelfLifeMax;
    }
}
