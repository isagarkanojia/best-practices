package com.software.practices.solutions.java8.streams.collect;

import com.software.practices.solutions.java8.streams.dtos.Gender;
import com.software.practices.solutions.java8.streams.dtos.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Sagar Kanojia
 */
public class CollectMapGrouping {

    public static List<Person> createPeople() {

        return Arrays.asList(
                new Person("Jake", Gender.MALE, 27),
                new Person("Jake", Gender.MALE, 23),
                new Person("Pepper", Gender.FEMALE, 22),
                new Person("Rob", Gender.MALE, 32),
                new Person("Rob", Gender.MALE, 23),
                new Person("Jen", Gender.FEMALE, 25),
                new Person("Jen", Gender.FEMALE, 31),
                new Person("Lyla", Gender.FEMALE, 31),
                new Person("Cox", Gender.MALE, 26),
                new Person("Scarlet", Gender.FEMALE, 23)
        );
    }

    public static void main(String[] args) {
        List<Person> people = createPeople();

        // create a map with name as key and value as all the people of that name
        Map<String, List<Person>> collect =
                people.stream()
                        .collect(
                                Collectors.groupingBy(Person::getName)
                        );


        System.out.println(collect);

        // create a map with name as key
        // and value as all the ages of people with name;
        Map<String, List<Integer>> collect2 =
                people.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getName,
                                        Collectors.mapping(Person::getAge,Collectors.toList())
                                )
                        );


        System.out.println(collect2);
    }
}
