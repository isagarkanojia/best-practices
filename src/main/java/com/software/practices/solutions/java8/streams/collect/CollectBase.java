package com.software.practices.solutions.java8.streams.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Sagar Kanojia
 */
public class CollectBase {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);

        //double the values and put this into a list

        List<Integer> doubleOfEven = new ArrayList<>();

        numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .forEach(n -> doubleOfEven.add(n));

        System.out.println(doubleOfEven);
        //Don't do this;
        //shared mutability is devil
        //multiple thread do together and it's a mess

        List<Integer> doubleOfEven2 = numbers
                .stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .collect(Collectors.toList());

        // thread safety by default
        System.out.println(doubleOfEven2);


        Set<Integer> doubleOfEven3 = numbers
                .stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .collect(Collectors.toSet());

        // thread safety by default
        System.out.println(doubleOfEven3);

    }
}
