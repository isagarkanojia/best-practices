package com.software.practices.solutions.stopwatch;

public class RunningStopwatch {
    private final long startTime;

    RunningStopwatch() {
        startTime = System.nanoTime();
    }

    public FinishedStopwatch stop() {
        return new FinishedStopwatch(startTime);
    }
}