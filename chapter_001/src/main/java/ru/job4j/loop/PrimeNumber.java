package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        int count = 1;
        CheckPrimeNumber checkPrimeNumber = new CheckPrimeNumber();
        for (int i = 3; i <= finish; i++) {
            if (checkPrimeNumber.check(i)) {
                count++;
            }
        }
        return count;
    }
}
