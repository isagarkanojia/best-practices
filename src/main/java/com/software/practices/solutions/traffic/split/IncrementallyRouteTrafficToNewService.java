package com.software.practices.solutions.traffic.split;

import com.software.practices.utils.DummyDataUtils;

import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

/**
 * @author Sagar Kanojia
 * Incrementally routing traffic to new service
 */
public class IncrementallyRouteTrafficToNewService {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        int ServiceOne = 0;
        int ServiceTwo = 0;

        String[] list = DummyDataUtils.getTempIds();
        for (String id : list) {
            System.out.print(id + " ");

            boolean shouldRoute = routeRequestBasedOnRampUp(id, 50);

            if (shouldRoute) {
                ServiceTwo++;
            } else {
                ServiceOne++;
            }

            System.out.println(shouldRoute);
        }

        System.out.println("Service One " + ServiceOne);
        System.out.println("Service Two " + ServiceTwo);
    }


    public static boolean routeRequestBasedOnRampUp(String id, int rampUpPercent)
            throws NoSuchAlgorithmException {
        long NUM_BUCKETS = 100;

        long hash = stringToCRC32Hash(id);

        long bucket = hash % NUM_BUCKETS;

        return (bucket + 1 <= rampUpPercent);
    }

    public static boolean routeRequestBasedOnRampUpUsingRandom(String id, int rampUpPercent) {

        int computedValue = 1 + new Random().nextInt(100);

        return (computedValue + 1 <= rampUpPercent);
    }


    public static long stringToCRC32Hash(String string) throws NoSuchAlgorithmException {
        byte[] bytes = string.getBytes();
        Checksum checksum = new CRC32();
        checksum.update(bytes, 0, bytes.length);
        return checksum.getValue();
    }
}
