package org.example.threaddemo_june6.IntroToThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorNumberPrinterMainClient  {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=1;i<=50;i++) {
            executorService.execute(new NumberPrinter(i));
        }
    }
}
