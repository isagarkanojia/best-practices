package com.software.practices.solutions;

import com.software.practices.solutions.stopwatch.RunningStopwatch;
import com.software.practices.solutions.stopwatch.Stopwatch;

/**
 * @author Sagar Kanojia
 */
public class EnforceMethodCallSequence {

    public static void main(String[] args) {

        RunningStopwatch runningStopwatch = Stopwatch.createRunning();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long elapsedTime = runningStopwatch.stop().getElapsedNanos();


        System.out.println("Total Time: " + elapsedTime);

    }
}
