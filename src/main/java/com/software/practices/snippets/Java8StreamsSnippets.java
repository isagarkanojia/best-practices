package com.software.practices.snippets;

import com.software.practices.snippets.dtos.CategoryConfig;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        Map<String, CategoryConfig> kycPreferencesConfigMap = new HashMap<>();

        kycPreferencesConfigMap = configs.stream()
                .collect(Collectors.toMap(CategoryConfig::getType, Function.identity()));

        return kycPreferencesConfigMap;
    }

    public static List<CategoryConfig> filter(List<CategoryConfig> configs){

        Set<String> types = new HashSet<>();
        types.add("Fashion");
        types.add("Cloths");

        List<CategoryConfig> result = configs.stream()
                .filter(p -> types.contains(p.getType())).collect(Collectors.toList());

        return result;
    }
}
