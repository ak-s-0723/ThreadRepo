package org.example.threaddemo_june6.ExecutorsAndCallables;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FibonacciCalculatorCachedPoolMainClient {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> futureAns = executorService.submit(new FibonacciCalculatorUsingCachedPool(3,executorService));
        System.out.println(futureAns.get());
    }
}
