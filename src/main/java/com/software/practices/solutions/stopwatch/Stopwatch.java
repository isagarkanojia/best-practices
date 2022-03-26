package com.software.practices.solutions.stopwatch;

public class Stopwatch {
    public static RunningStopwatch createRunning(String processName) {
        return new RunningStopwatch(processName);
    }
}
