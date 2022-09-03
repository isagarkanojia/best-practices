package com.software.practices.solutions.multithreading;

import java.util.concurrent.*;

public class FuturesSimple {

    public static void main(String args[]) throws Exception {
        process();
    }

    public static void process() throws Exception {
        ExecutorService executorService =
                new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<>());

        Future<String> futureOne = executorService.submit(new ServiceOne());
        Future<String> futureTwo = executorService.submit(new ServiceTwo());

        System.out.println(futureOne.get() + " - " + futureTwo.get());
    }

    private static final class ServiceOne implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            return "service one response";
        }
    }

    private static final class ServiceTwo implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.sleep(200);
            return "service two response";
        }
    }

}