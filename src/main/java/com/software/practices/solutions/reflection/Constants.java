package com.software.practices.solutions.reflection;

import com.software.practices.solutions.reflection.enums.Key;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sagar Kanojia
 */
public class Constants {

    public static Map<String, String> keys = new HashMap<>();

    static {
        keys.put("name", Key.FIRST_NAME.name());
        keys.put("email", Key.EMAIL.name());
    }

}
