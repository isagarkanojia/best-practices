package com.software.practices.solutions.java8.streams;

import java.util.Arrays;
import java.util.List;

/**
 * @author Sagar Kanojia
 */
public class Streams1 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        interativeWay(numbers);
        functionalWay(numbers);

    }


    // synchronize and suffer model
    private static void interativeWay(List<Integer> numbers) {

        int total = 0;

        for (int number : numbers) {
            if (number % 2 == 0) {
                total += number * 2;
            }
        }

        System.out.println("Total: " + total);

    }


    // functional composition - Collection Pipeline Pattern // Martin Fowler
    // less accidental complexity
    // less complexity and easy to parallelize
    // pure functions - lambdas
    private static void functionalWay(List<Integer> numbers) {

        int total = 0;

        total = numbers
                .stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(number -> number * 2)
                .sum();

        System.out.println("Total: " + total);
    }
}
