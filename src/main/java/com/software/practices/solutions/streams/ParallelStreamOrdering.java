package com.software.practices.solutions.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author Sagar Kanojia
 */
public class ParallelStreamOrdering {

    public static int process(int number) {

        //System.out.println("thread " + number + " " + Thread.currentThread());

        // to mimic, it is an intensive task
        sleep(1000);

        return number = number * 1;

    }

    // No Guarantee of order

    // Some method are inherent ordered
    //Some methid are unordered but may have order counterparts

    //forEachXXXXXX does not guarantee ordering unless the stream itself guarantees ordering
    // List does, Set Doesn't
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.parallelStream()
                .map(number -> process(number))
                .forEach(System.out::println);
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
