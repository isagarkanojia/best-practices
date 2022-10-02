package com.software.practices.solutions.java8.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Sagar Kanojia
 */

// only useful in simple and trivial use cases
// Use Case: not alter it but pass through
public class MethodReferences3 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.forEach(value -> System.out.println(value));

        numbers.forEach(System.out::println);


        // params as an argument to static method
        numbers.stream()
                .map(n -> String.valueOf(n))
                .forEach(System.out::println);


        numbers.stream()
                .map(String::valueOf)
                .forEach(System.out::println);


        numbers.stream()
                .map(e -> String.valueOf(e))
                .map(String::toString)
                .forEach(System.out::println);


        System.out.println(
                numbers.stream()
                        .reduce(0, (total, n) -> Integer.sum(total, n))
        );

        System.out.println(
                numbers.stream()
                        .reduce(0, Integer::sum)
        );

        System.out.println(
                numbers.stream()
                        .map(String::valueOf)
                        .reduce("", (carry, string) -> carry.concat(string))

        );

        System.out.println(
                numbers.stream()
                        .map(String::valueOf)
                        .reduce("", String::concat)

        );


        //Limitations
        // Can't use if there is any manipulation
        // Conflict between static and instance method
        // Integer toString example

    }


}
