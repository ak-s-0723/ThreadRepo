package org.example.threaddemo_june6.ExecutorsAndCallables;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class FibonacciCalculatorUsingCachedPool implements Callable<Integer> {
    int n;
    private ExecutorService executorService;

    public FibonacciCalculatorUsingCachedPool(int n, ExecutorService executorService) {
        this.n = n;
        this.executorService = executorService;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(n +" through thread "+Thread.currentThread().getName());

        if(n<=1) return n;

        Future<Integer> futureAns1 = executorService.submit(new FibonacciCalculatorUsingCachedPool(n-1,executorService));
        Future<Integer> futureAns2 = executorService.submit(new FibonacciCalculatorUsingCachedPool(n-2,executorService));

        int ans1 = futureAns1.get();
        int ans2 = futureAns2.get();
        return ans1+ans2;
    }
}
