package com.software.practices.snippets;

import com.software.practices.snippets.dtos.CategoryConfig;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Sagar Kanojia
 */
public class HeapSnippets {


    public static void main(String[] args) {

        HeapSnippets heapSnippets = new HeapSnippets();

        heapSnippets.heapOfObjects();
    }

    private void heapOfObjects() {

        PriorityQueue<CategoryConfig> priorityQueue = new PriorityQueue<>(new Comparator<CategoryConfig>() {
            @Override
            public int compare(CategoryConfig a, CategoryConfig b) {
                return a.getOrder() > b.getOrder() ? 1 : -1;
            }
        });


        priorityQueue.add(new CategoryConfig(2, "CLOTHING", true));

        priorityQueue.add(new CategoryConfig(3, "ELECTRONICS", true));

        priorityQueue.add(new CategoryConfig(1, "FASHION", true));


        CategoryConfig e = priorityQueue.peek();
        System.out.println(e);

    }


}
