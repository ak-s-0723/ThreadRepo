package org.example.threaddemo_june6.ExecutorsAndCallables;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FibonacciCalculatorUsingFixedPool implements Callable<Integer> {
    int n;

    public FibonacciCalculatorUsingFixedPool(int n) {
        this.n = n;
    }

//    public int fibo(int n) {
//        if(n<=1) return n;
//        return fibo(n-1) + fibo(n-2);
//    }

    @Override
    public Integer call() throws Exception {
        //Let's print thread name
        System.out.println("number "+n+" through thread "+Thread.currentThread().getName());

        if(n<=1) return n;

        //Since there are 2 recursion calls, we need a thread pool of size 2
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        //we will use submit function because it returns value, execute function doesn't
        //Since there are 2 recursion calls , we will use make 2 calls, one with n-1 and
        //other with n-2
        //show them example how we have written in ExecutorNumberPrinterMainClient
        //This will start a thread which will start executing a task
//        executorService.submit(new FibonacciCalculatorUsingFixedPool(n-1));
//        executorService.submit(new FibonacciCalculatorUsingFixedPool(n-2));


//        return executorService.submit(new FibonacciCalculatorUsingFixedPool(n-1)) +
//        executorService.submit(new FibonacciCalculatorUsingFixedPool(n-2));
          //This will be error , but why ?
          //Explain logic that both threads have been assigned some tasks and both of them will
          //take some time which might be different to do it.
          //Plus it's not like that I have given the work and now I can go sleep
          //Nooo, because I need to combine the answer and then return
          //We need to wait here, otherwise current thread will go on next line ,
          // and next to next line and finish.


//        int ans1 = executorService.submit(new FibonacciCalculatorUsingFixedPool(n-1));
         //It cannot return an integer because it doesn't have an integer right away
         //Relate it with Blood sample collection example, Do they give report then and there
         //No, they give you receipt that report will be ready , show this receipt in future
         //and get your report
         //Similarly here also, when we will assign this task to a thread, it will give us
         //Future object which says, that when task will be done, it will return us an answer

        Future<Integer> futureAns1 = executorService.submit(new FibonacciCalculatorUsingFixedPool(n-1));
        Future<Integer> futureAns2 = executorService.submit(new FibonacciCalculatorUsingFixedPool(n-2));
        //Now since they have got futures, they will proceed further on next line and not wait

        //because now we don't have anything else to do, lets wait here till we get ans1 and ans2
        //before we exit
        int ans1 = futureAns1.get();
        int ans2 = futureAns2.get();
        return ans1+ans2;

        //Now someone has to start the process also, so let's go to main
    }


}
