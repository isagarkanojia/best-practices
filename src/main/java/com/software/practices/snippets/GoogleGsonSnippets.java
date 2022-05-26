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
            "    \"type\": \"Fashion\",\n" +
            "    \"active\": true\n" +
            "  }\n" +
            "]";


    private CategoryConfig[] jsonToArray() {

        CategoryConfig[] configs = new Gson().fromJson(categoriesJson, CategoryConfig[].class);

        return configs;
    }

    private List<CategoryConfig> jsonToArrayList() {

        Type configType = new TypeToken<ArrayList<CategoryConfig>>(){}.getType();

        ArrayList<CategoryConfig> configs = new Gson().fromJson(categoriesJson, configType);

        return configs;
    }

}
