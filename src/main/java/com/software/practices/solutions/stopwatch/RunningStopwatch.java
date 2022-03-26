package com.software.practices.solutions.stopwatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunningStopwatch {
    private final long startTime;
    private final String processName;

    RunningStopwatch(String processName) {

        this.processName = processName;

        startTime = System.nanoTime();

        log.info("{} - started at: {} (nano time)", processName, startTime);
    }

    public FinishedStopwatch stop() {
        return new FinishedStopwatch(processName, startTime);
    }
}