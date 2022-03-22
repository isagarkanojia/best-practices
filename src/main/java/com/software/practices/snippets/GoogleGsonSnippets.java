package com.software.practices.snippets;

import com.google.gson.Gson;
import com.software.practices.snippets.dtos.CategoryConfig;

/**
 * @author Sagar Kanojia
 */
public class GoogleGsonSnippets {


    public static final String categoriesJson = "[\n" +
            "  {\n" +
            "    \"order\": 2,\n" +
            "    \"type\": \"Cloths\",\n" +
            "    \"active\": true\n" +
            "  },\n" +
            "  {\n" +
            "    \"order\": 1,\n" +
            "    \"type\": \"Electronics\",\n" +
            "    \"active\": true\n" +
            "  },\n" +
            "  {\n" +
            "    \"order\": 2,\n" +
            "    \"type\": \"Fasion\",\n" +
            "    \"active\": true\n" +
            "  }\n" +
            "]";


    private CategoryConfig[] jsonToArray() {

        CategoryConfig[] configs = new Gson().fromJson(categoriesJson, CategoryConfig[].class);

        return configs;
    }
}
