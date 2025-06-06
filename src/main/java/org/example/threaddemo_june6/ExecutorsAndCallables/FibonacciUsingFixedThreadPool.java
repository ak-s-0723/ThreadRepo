package org.example.threaddemo_june6.ExecutorsAndCallables;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FibonacciUsingFixedThreadPool implements Callable<Integer> {
    private int n;

    public FibonacciUsingFixedThreadPool(int n) {
        this.n = n;
    }

//    public int fib(int n) {
//        if (n <= 1) {
//            return n;}
//        return fib(n - 1) + fib(n - 2);
//    }

    @Override
    public Integer call() throws Exception {
        System.out.println(n +"from thread "+Thread.currentThread().getName());
        if(n<=1) return n;

       ExecutorService executorService =
               Executors.newFixedThreadPool(2);

        Future<Integer> futureAns1 =
                executorService.submit(new FibonacciUsingFixedThreadPool(n-1));

        Future<Integer> futureAns2 =
        executorService.submit(new FibonacciUsingFixedThreadPool(n-2));

        int ans1 = futureAns1.get();
        int ans2 = futureAns2.get();
        return ans1+ans2;
    }
}
