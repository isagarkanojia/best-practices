package com.software.practices.solutions.java8.lambdas;

/**
 * @author Sagar Kanojia
 */
public class LambdasBase1 {

    public static void main(String[] args) {
        oldWay();
        newWay();
    }


    private static void oldWay() {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("another thread");
            }
        });

        t.start();

        System.out.println("main thread");
    }

    // invoke dynamic
    private static void newWay() {

        Thread t = new Thread(() -> System.out.println("another thread"));

        t.start();
        System.out.println("main thread");
    }

}
