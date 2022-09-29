package com.software.practices.solutions.hashing;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

/**
 * @author Sagar Kanojia
 */
public class CRC32Hash {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String[] list = {"hshshhhss", "bshhehsshs", "sgsbeehshs"};
        for (String id : list) {
            System.out.print(id + " ");
            long hash = stringToCRC32Hash(id);
            System.out.println(hash);
        }
    }

    public static long stringToCRC32Hash(String string) throws NoSuchAlgorithmException {
        byte[] bytes = string.getBytes();
        Checksum checksum = new CRC32();
        checksum.update(bytes, 0, bytes.length);
        return checksum.getValue();
    }

    public static String stringToCRC32HashString(String string) {
        byte[] data = string.getBytes();
        CRC32 crc32 = new CRC32();
        crc32.update(data);
//        String hash = Long.toHexString(crc32.getValue());
        return String.format(Locale.US, "%08X", crc32.getValue());
    }

    public static String stringToCRC32HashStringUsingWithSalt(String string) {

        int mySaltSizeInBytes = 32;
        //SecureRandom class provides strong random numbers
        SecureRandom random = new SecureRandom();

        //salt mitigates dictionary/rainbow attacks
        byte salt[] = new byte[mySaltSizeInBytes];

        //random fill salt buffer with random bytes
        random.nextBytes(salt);

        //concatenates string a  and salt
        //into one big bytebuffer ready to be digested
        //this is just one way to do it
        //there might be better ways

        ByteBuffer bbuffer = ByteBuffer.allocate(mySaltSizeInBytes + string.length());
        bbuffer.put(salt);
        bbuffer.put(string.getBytes());

        //your crc class
        CRC32 crc32 = new CRC32();
        crc32.update(bbuffer.array());

        return String.format(Locale.US, "%08X", crc32.getValue());
    }


}
