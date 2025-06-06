package org.example.threaddemo_june6.IntroToThreads;

public class NumberPrinter implements Runnable {

    private Integer input;

    public NumberPrinter(Integer input) {
        this.input = input;
    }

    @Override
    public void run() {
        System.out.println("number = "+input+" from thread "+Thread.currentThread().getName());
    }
}
