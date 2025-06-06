package org.example.threaddemo_june6.IntroToThreads;

public class SumCalculator implements Runnable {
    int input;
    public SumCalculator(int input){
        this.input=input;
    }
    public void calculateSum() {
        int sum=0;

        for(int i=1;i<input;i++) {
            sum +=i;
        }

        System.out.println("The sum of first "+input+" Numbers is "+sum+" "+
                "using thread "+Thread.currentThread().getName());
    }

    @Override
    public void run() {
        calculateSum();
    }
}
