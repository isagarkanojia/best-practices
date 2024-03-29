package com.software.practices.solutions.traffic.split;

import com.software.practices.solutions.traffic.split.dtos.BucketInfo;
import com.software.practices.solutions.traffic.split.dtos.Distributor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sagar Kanojia
 */
public class ExactTrafficSplitting {

    public static void main(String[] args) {
        splitTest();
    }

    public static void splitTest() {
        List<BucketInfo> bucketInfoList = new ArrayList<>();
        bucketInfoList.add(new BucketInfo('a', 5));
        bucketInfoList.add(new BucketInfo('b', 4));
        bucketInfoList.add(new BucketInfo('c', 1));

        Distributor distributor = new Distributor(bucketInfoList);

        int aBucketCount = 0, bBucketCount = 0, cBucketCount = 0;

        for (int i = 0; i < 100; ++i) {
            char bucket = distributor.getNextBucket();
            switch (bucket) {
                case 'a':
                    aBucketCount++;
                    break;
                case 'b':
                    bBucketCount++;
                    break;
                case 'c':
                    cBucketCount++;
                    break;
            }
        }
        System.out.println("A BucketCount: " + aBucketCount);
        System.out.println("B BucketCount: " + bBucketCount);
        System.out.println("C BucketCount: " + cBucketCount);
    }

}
