package com.software.practices.solutions.multithreading;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
            System.out.println("CALLING SHUTDOWN");
            executorService.shutdown();
        }

        try {
            System.out.println("awaitTermination START");
            executorService.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println("awaitTermination END ");
        } catch (InterruptedException e) {
            log.error("awaitTermination ERROR ", e);
        } finally {
            System.out.println("FINALLY DONE");
        }
    }

    private void processBatch(List<Integer> batch) {

        for (Integer id : batch) {
            processOne(id);
        }

    }

    private void processOne(Integer id) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Processed " + id);
    }

    public static void main(String[] args) {

        List<Integer> input = new ArrayList<>();

        for (int x = 0; x < 10; x++) {
            input.add(x);
        }

        RunningProcessInBatches process = new RunningProcessInBatches();

        process.process(input);
    }

}
