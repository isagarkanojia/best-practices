package com.software.practices.solutions.streams;

import java.util.Arrays;
import java.util.List;

/**
 * @author Sagar Kanojia
 */
public class ParallelStreamAndReduce {

    public static int process(int number) {

        //System.out.println("thread " + number + " " + Thread.currentThread());

        // to mimic, it is an intensive task
        sleep(1000);

        return number = number * 1;

    }

    // reduce doesn not take an initial value, it takes an identity value
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.parallelStream()
                .filter(number -> check(number))
                .forEach(n -> {});
    }

    private static boolean check(Integer number) {

        System.out.println("check " + number + " " + Thread.currentThread());

        sleep(1000);

        return true;
    }


    public static void printIt(int number) {
        System.out.println("print " + number + " " + Thread.currentThread());
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
