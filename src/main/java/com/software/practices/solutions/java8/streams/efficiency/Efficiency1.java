package com.software.practices.solutions.java8.streams.efficiency;

import java.util.Arrays;
import java.util.List;

/**
 * @author Sagar Kanojia
 */
public class Efficiency1 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // find the double of the first even number greater than three

        int result = 0;
        for (int num : numbers) {
            if (num > 3 && num % 2 == 0) {
                result = num * 2;
                break;
            }
        }
        System.out.println(result);
        // how much work?
        // 8 units

        System.out.println(
                numbers.stream()
                        .filter(num -> num > 3)
                        .filter(num -> num % 2 == 0)
                        .map(num -> num * 2)
                        .findFirst()
        );

        //20 + 17 + 9 units 

        System.out.println(
                numbers.stream()
                        .filter(Efficiency1::isGTR3)
                        .filter(Efficiency1::isEven)
                        .map(Efficiency1::doubleIt)
                        .findFirst()
        );

        // ?

    }

    private static int doubleIt(Integer num) {
        System.out.println("doubleIft " + num);
        return num * 2;
    }

    private static boolean isEven(int num) {
        System.out.println("isEven " + num);
        return num % 2 == 0;
    }

    private static boolean isGTR3(int num) {
        System.out.println("isGTR3 " + num);
        return num > 3;
    }

}
