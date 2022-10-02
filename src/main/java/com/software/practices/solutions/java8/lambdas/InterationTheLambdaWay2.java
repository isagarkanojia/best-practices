package com.software.practices.solutions.java8.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Sagar Kanojia
 */
public class InterationTheLambdaWay2 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        oldWay(numbers);

        newWay(numbers);

    }

    private static void oldWay(List<Integer> numbers) {

        //external iterator
        for (int x = 0; x < numbers.size(); x++) {
            System.out.println(numbers.get(x));
        }

        //external iterator
        for (int x : numbers) {
            System.out.println(x);
        }
    }

    // benefits of polymorphism
    private static void newWay(List<Integer> numbers) {

        // v1
        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        // v2
        numbers.forEach((Integer value) -> System.out.println(value));

        // v3, type inference, only for lambdas
        // also paranthesis is optional for single param
        numbers.forEach(value -> System.out.println(value));

        // :: just to show that we are passing the function
        numbers.forEach(System.out::println);

    }

    //Note: lambdas are not cute if you write 30 or 50 lines of code within a lambda
    // as a dev it is our responsibility to keep lambdas cute
    // One line is good

    // why so short?
    // code becomes hard, if long
    // very noisy
    // code cluttered
    // duplication of code
    // hard to test

    void example(List<Integer> numbers){

        numbers.forEach(value -> {
            //...;
            //...;
            //...;
            //return;
        });

        numbers.forEach(value -> process(value));

    }

    private void process(Integer value) {
        //...;
        //...;
        //...;
    }

}
