package org.example.threaddemo_june6.IntroToThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NumberPrinterExectorMainClient {

    public static void main(String a[]) {
        ExecutorService executorService =
                Executors.newFixedThreadPool(2);

        for(int i=1;i<=1000;i++) {
            executorService.execute(new NumberPrinter(i));
        }
    }
}

//   for(int i=1;i<=10;i++) {
//Thread t = new Thread(new NumberPrinter(i));
//            t.start();
//        }
