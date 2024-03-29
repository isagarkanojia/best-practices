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
public class UsingRandomRouteTrafficToNewService {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        int ServiceOne = 0;
        int ServiceTwo = 0;

        String[] list = DummyDataUtils.getTempIds();
        for (String id : list) {
            System.out.print(id + " ");

            boolean shouldRoute = routeRequestBasedOnRampUpUsingRandom(id, 50);

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

    public static boolean routeRequestBasedOnRampUpUsingRandom(String id, int rampUpPercent) {

        int computedValue = 1 + new Random().nextInt(100);

        return (computedValue + 1 <= rampUpPercent);
    }
}
