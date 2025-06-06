package org.example.threaddemo_june6.IntroToThreads;

public class SumCalculatorMainClient {

    public static void main(String[] args) {
        SumCalculator sumCalculator1 = new SumCalculator(10);
        Thread t = new Thread(sumCalculator1);
        t.start();
    }
}
