package com.hhy.test.java;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author hhy
 * @date 2020/4/2 20:47
 * @version 1.0
 * @Description
 */
public class FutureTest {

    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public Future<Integer> calculate(Integer input) {
        return executor.submit(() -> {
            Thread.sleep(5000);
            return input * input;
        });
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTest test =new FutureTest();
        Future<Integer> fu= test.calculate(2);
        System.out.println(11);
        Integer xx=fu.get();
        System.out.println(xx);


    }

}
