package com.software.practices.solutions.traffic.split.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Distributor implements IDistributor {
    private int nextBucketIndex;
    private char[] senderBuckets;
    private Random r = new Random();
    private List<BucketInfo> bucketInfoList;

    public Distributor(List<BucketInfo> bucketInfos) {
        this.bucketInfoList = bucketInfos;
        generate();
    }

    private int getTotalWeights() {
        int totalWeight = 0;
        for (BucketInfo bucketInfo : bucketInfoList) {
            totalWeight = totalWeight + bucketInfo.getWeight();
        }
        return totalWeight;
    }

    private void generate() {
        List<BucketInfo> flatBuckets = new ArrayList<>();
        int i = 0;
        for (BucketInfo bucketInfo : bucketInfoList) {
            for (int j = 0; j < bucketInfo.getWeight(); ++j) {
                flatBuckets.add(i++, bucketInfo);
            }
        }
        int totalWeights = getTotalWeights();
        this.senderBuckets = new char[totalWeights];
        i = 0;
        while (i < totalWeights) {
            int index = r.nextInt(flatBuckets.size());
            senderBuckets[i++] = flatBuckets.remove(index).getBucketId();
        }
    }

    @Override
    public char getNextBucket() {
        this.nextBucketIndex++;
        this.nextBucketIndex = (this.nextBucketIndex == this.senderBuckets.length) ? 0 : this.nextBucketIndex;
        return senderBuckets[nextBucketIndex];
    }
}