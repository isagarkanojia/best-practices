package com.software.practices.solutions.stopwatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FinishedStopwatch {
    private final long elapsedTime;

    FinishedStopwatch(String processName, long startTime) {

        long endTime = System.nanoTime();

        elapsedTime = endTime - startTime;

        log.info("{} - finshed at: {} (nano time)", processName, endTime);
        log.info("{} - elapsed time: {} (nano seconds)", processName, elapsedTime);
    }

    public long getElapsedNanos() {
        return elapsedTime;
    }
}