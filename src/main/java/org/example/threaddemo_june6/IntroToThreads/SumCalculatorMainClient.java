package org.example.threaddemo_june6.IntroToThreads;

public class SumCalculatorMainClient {

    public static void main(String[] args) {
        SumCalculator sumCalculator = new SumCalculator(10);
        Thread t = new Thread(sumCalculator);
        t.start();   // thread 0
        new SumCalculator(10).calculateSum(); //main thread
        //Both of above can happen in any order
    }
}
