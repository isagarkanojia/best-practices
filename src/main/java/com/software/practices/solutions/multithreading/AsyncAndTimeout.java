package com.software.practices.solutions.multithreading;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author Sagar Kanojia
 */

@Slf4j
public class AsyncAndTimeout {


    public static void main(String[] args) {

        log.info("OUT I am Starting");

        try {

            CompletableFuture<String> future
                    = CompletableFuture.supplyAsync(() -> doSomething());

            String result = future.get(3, TimeUnit.SECONDS);

            log.info("Output :"+result);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


    }

    private static String doSomething() {

        log.info("I am Starting");


        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return process();
        });

        log.info("I am Done");

        try {
            return future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return "YES";
    }

    private static String process() {

        log.info("I am in process");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("done in process");

        return "Process";
    }
}
