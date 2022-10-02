package com.software.practices.solutions.java8.streams;

import java.util.Arrays;
import java.util.List;

/**
 * @author Sagar Kanojia
 */
public class Streams2 {

    public static int process(int number){

        // to mimic, it is an intensive task
        sleep(1000);

        return   number = number*1;

    }


    // master switch -- stream to parallel stream

    // In imperative style code the structure of code is very different
    // from the structure of concurrent code

    // Using stream, the benefit is
    // the structure of sequential code is identical to the concurrent code

    // The challenge , a lot of mutability in the code
    // mutability and parallel don't go together
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                .map( number -> process(number))
                .forEach(System.out::println);
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
