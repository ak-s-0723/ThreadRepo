package org.example.threaddemo_june6.ExecutorsAndCallables;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FibonacciCalculatorFixedPoolMainClient {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> futureAns = executorService.submit(new FibonacciCalculatorUsingFixedPool(3));
        System.out.println(futureAns.get());

        //Now you will see, it is using 3 thread pools, why ?
        //Where are we creating this thread pools ?
        //Also for each recursive pool, I am creating new Thread Pool
        //What can be better solution here ? - To use CacheThreadPool
    }
}
