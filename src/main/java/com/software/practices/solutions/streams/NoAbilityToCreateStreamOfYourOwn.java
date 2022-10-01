package com.software.practices.solutions.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Sagar Kanojia
 */
public class NoAbilityToCreateStreamOfYourOwn {

    public static int process(int number) {

        // to mimic, it is an intensive task
        sleep(1000);

        return number = number * 1;

    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        use(numbers.stream());
    }

    // intermediate ops and terminal ops
    public static void use(Stream<Integer> stream) {
        stream.parallel()
                .map(number -> process(number))
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



// Streams                                      Reactive Streams
//sequential vs parallel                        async vs sync

//entire pipeline is sequenctial                It Depends
//or parallel, NO SEGMENTS                      With subscribeOn, NO SEGMENTS
//                                              With observeOn, SEGMENTS