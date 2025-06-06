package org.example.threaddemo_june6.IntroToThreads;

public class MainClient {
    public static void main(String args[]) {
        for(int i=1;i<=10;i++) {
            Thread t = new Thread(new NumberPrinter(i));
            t.start();
        }

    }
}
