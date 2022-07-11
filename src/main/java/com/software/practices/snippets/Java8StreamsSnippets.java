package com.software.practices.snippets;

import com.software.practices.snippets.dtos.CategoryConfig;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author Sagar Kanojia
 */
public class Java8StreamsSnippets {

    public static Set<String> toSet(String commaSeperatedString) {

        Set<String> set = Stream.of(commaSeperatedString.trim().split("\\s*,\\s*"))
                .collect(Collectors.toSet());

        return set;
    }


    public static Map<String, CategoryConfig> listToMap(List<CategoryConfig> configs) {

        Map<String, CategoryConfig> map = new HashMap<>();

        map = configs.stream()
                .collect(Collectors.toMap(CategoryConfig::getType, Function.identity()));

        return map;
    }

    public static Map<String, List<CategoryConfig>> listToGroupByMap(List<CategoryConfig> configs) {

        Map<String, List<CategoryConfig>> map = configs.stream()
                .collect(Collectors.groupingBy(CategoryConfig::getType));

        return map;
    }

    public static Map<String, List<CategoryConfig>> listToGroupByMapNullKeySafe(List<CategoryConfig> configs) {

        Map<String, List<CategoryConfig>> map = configs.stream()
           .collect(groupingBy(config -> config.getType() == null ? "nullType" : config.getType()));

        return map;
    }

    public static List<CategoryConfig> filter(List<CategoryConfig> configs) {

        Set<String> types = new HashSet<>();
        types.add("Fashion");
        types.add("Cloths");

        List<CategoryConfig> result = configs.stream()
                .filter(p -> types.contains(p.getType())).collect(Collectors.toList());

        return result;
    }

    public static Map<String, CategoryConfig> listToMapWithMergeFunction(List<CategoryConfig> configs) {

        Map<String, CategoryConfig> map = configs.stream()
                .collect(Collectors.toMap(CategoryConfig::getType, Function.identity(),(o1,o2) -> o1));

        return map;
    }
}
