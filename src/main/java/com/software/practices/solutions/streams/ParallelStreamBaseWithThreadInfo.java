package com.software.practices.solutions.streams;

import java.util.Arrays;
import java.util.List;

/**
 * @author Sagar Kanojia
 */
public class ParallelStreamBaseWithThreadInfo {

    public static int process(int number){

        System.out.println("thread "+number+" "+Thread.currentThread());

        // to mimic, it is an intensive task
        sleep(1000);

        return   number = number*1;

    }

    // We solve on set of problem
    // only to create other set of problem

    // Java 1 Threads, not good to create thread after threads

    // Java 5 ExecutorServices, pool of threads, pool of problems
    // Pool induced deadlock

    //Workstealing - fork join pool
    //Java 7 FJP //40

    //Common FJP
    //Java 8 uses the same
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                .map( number -> process(number))
                .forEach( number -> {});
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
