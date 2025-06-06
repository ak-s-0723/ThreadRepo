package org.example.threaddemo_june6.ExecutorsAndCallables;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FibonacciUsingCachedThreadPool implements Callable<Integer> {

    int n;
    ExecutorService executorService;

    public FibonacciUsingCachedThreadPool(int n,ExecutorService executorService) {
        this.n  = n;
        this.executorService = executorService;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(n +"from thread "+Thread.currentThread().getName());
        if(n<=1) return n;

//        ExecutorService executorService =
//                Executors.newFixedThreadPool(2);

        Future<Integer> futureAns1 =
                executorService.submit(new FibonacciUsingCachedThreadPool(n-1,executorService));

        Future<Integer> futureAns2 =
                executorService.submit(new FibonacciUsingCachedThreadPool(n-2,executorService));

        int ans1 = futureAns1.get();
        int ans2 = futureAns2.get();
        return ans1+ans2;
    }
}
