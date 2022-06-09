package com.software.practices.solutions.multithreading;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Sagar Kanojia
 */
@Slf4j
public class RunningProcessInBatches {

    private void process(List<Integer> ids) {
        int threadPoolSize = 10, bufferSize = 100;
        int startIndex = 0;
        int N = ids.size();

        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);

        try {
            for (int thread = 0; thread < threadPoolSize; thread++) {
                int endIndex = startIndex + bufferSize;
                if (startIndex >= N) {
                    break;
                }
                if (endIndex > N) {
                    endIndex = N;
                }

                try {
                    log.info("Process Batch Start {} End {}", startIndex, endIndex);

                    List<Integer> batch = ids.subList(startIndex, endIndex);

                    executorService.submit(() -> processBatch(batch));

                    log.info("Success Batch Start {} End {}", startIndex, endIndex);

                } catch (Exception e) {
                    log.error("Error in Batch Start {} End {}", startIndex, endIndex);
                }

                startIndex = endIndex;

            }
        } finally {
            executorService.shutdown();
        }
    }

    private void processBatch(List<Integer> batch) {

        for (Integer id : batch) {
            System.out.print(id + ",");
        }

    }

    public static void main(String[] args) {

        List<Integer> input = new ArrayList<>();

        for (int x = 0; x < 300; x++) {
            input.add(x);
        }

        RunningProcessInBatches process = new RunningProcessInBatches();

        process.process(input);
    }

}
