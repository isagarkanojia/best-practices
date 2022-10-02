package com.software.practices.solutions.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * @author Sagar Kanojia
 */
public class Performance {

    public static int process(int number){

        System.out.println("thread "+number+" "+Thread.currentThread());

        // to mimic, it is an intensive task
        sleep(1000);

        return   number = number*1;

    }


    // Computation VS IO heavy tasks
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(ForkJoinPool.commonPool());

        System.out.println(Runtime.getRuntime().availableProcessors());


//        numbers.stream()
//                .map( number -> process(number))
//                .forEach( number -> {});
    }


    private static boolean sleep(int ms) {
        try {
            Thread.sleep(ms);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }


}
