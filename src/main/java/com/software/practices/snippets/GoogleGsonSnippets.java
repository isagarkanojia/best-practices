package com.software.practices.snippets;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.software.practices.snippets.dtos.CategoryConfig;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sagar Kanojia
 */
public class GoogleGsonSnippets {


    public static final String categoriesJson = "[\n" +
            "  {\n" +
            "    \"order\": 2,\n" +
            "    \"type\": \"Fashion\",\n" +
            "    \"active\": true\n" +
            "  },\n" +
            "  {\n" +
            "    \"order\": 1,\n" +
            "    \"type\": \"Fashion\",\n" +
            "    \"active\": true\n" +
            "  },\n" +
            "  {\n" +
            "    \"order\": 3,\n" +
            "    \"type\": \"Fashion\",\n" +
            "    \"active\": true\n" +
            "  }\n" +
            "]";

    public static final String categoryJson =
            "  {\n" +
            "    \"order\": 2,\n" +
            "    \"type\": \"Fashion\",\n" +
            "    \"active\": true\n" +
            "  }\n";


    private CategoryConfig[] jsonToArray() {

        CategoryConfig[] configs = new Gson().fromJson(categoriesJson, CategoryConfig[].class);

        return configs;
    }

    private List<CategoryConfig> jsonToArrayList() {

        Type configType = new TypeToken<ArrayList<CategoryConfig>>(){}.getType();

        ArrayList<CategoryConfig> configs = new Gson().fromJson(categoriesJson, configType);

        return configs;
    }

    private CategoryConfig jsonToObject() {

        CategoryConfig config = new Gson().fromJson(categoryJson, CategoryConfig.class);

        System.out.println(config);

        return config;
    }
}
