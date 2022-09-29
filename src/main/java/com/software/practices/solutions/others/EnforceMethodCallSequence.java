package com.software.practices.solutions.others;

import com.software.practices.solutions.stopwatch.FinishedStopwatch;
import com.software.practices.solutions.stopwatch.RunningStopwatch;
import com.software.practices.solutions.stopwatch.Stopwatch;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Sagar Kanojia
 */
@Slf4j
public class EnforceMethodCallSequence {

    public static void main(String[] args) {

        RunningStopwatch runningStopwatch = Stopwatch.createRunning("main");


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        FinishedStopwatch finishedStopwatch = runningStopwatch.stop();

        log.info("elapsed time: {}", finishedStopwatch.getElapsedNanos());

    }
}
