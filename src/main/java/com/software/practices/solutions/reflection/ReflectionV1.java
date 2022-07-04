package com.software.practices.solutions.reflection;

import com.software.practices.solutions.reflection.dtos.Data;
import com.software.practices.solutions.reflection.dtos.Result;
import com.software.practices.solutions.reflection.utils.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sagar Kanojia
 */
@Slf4j
public class ReflectionV1 {

    public static void main(String[] args) throws IntrospectionException, ReflectiveOperationException {

        Data data = new Data().builder()
                .name("Sagar")
                .email("sagar@sagar.ai")
                .build();

        List<Result> result = get(data, "name", "email");

        log.info("Result {}", result);
    }


    private static List<Result> get(Object object, String... properties) {

        List<Result> attributes = new ArrayList<>();

        if (properties.length == 0) {
            return attributes;
        }

        for (String property : properties) {

            String key = Constants.keys.getOrDefault(property, "anonymous");

            Result dto = new Result().builder()
                    .key(key)
                    .value((String) ReflectionUtils.getValueByFieldName(object, property))
                    .build();

            attributes.add(dto);
        }

        return attributes;

    }


}

