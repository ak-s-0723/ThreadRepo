package org.example.threaddemo_june6.ExecutorsAndCallables;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FibonacciUsingFixedThreadPoolMainClient {

    public static void main(String args[]) throws ExecutionException, InterruptedException {

        ExecutorService executorService =
                Executors.newFixedThreadPool(1);

        Future<Integer> futureAns =
                executorService.submit(new FibonacciUsingFixedThreadPool(3));
        System.out.println(futureAns.get());
    }

}
