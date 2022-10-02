package com.software.practices.solutions.java8.streams.characterisitics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Sagar Kanojia
 */
public class Characteristics {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);

        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        // sized, ordered, non-distinct, non-sorted
        // inherited from the list


        // change properties along the way
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .sorted()
                .forEach(System.out::println);

        // change properties along the way
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .distinct()
                .forEach(System.out::println);


        System.out.println(Stream.iterate(100, num -> num + 1));


    }


}
