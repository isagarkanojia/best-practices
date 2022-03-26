package com.software.practices.solutions.stopwatch;

public class FinishedStopwatch {
    private final long elapsedTime;

    FinishedStopwatch(long startTime) {
        elapsedTime = System.nanoTime() - startTime;
    }

    public long getElapsedNanos() {
        return elapsedTime;
    }
}