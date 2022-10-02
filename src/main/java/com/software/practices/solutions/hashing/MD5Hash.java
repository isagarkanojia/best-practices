package com.software.practices.solutions.hashing;

import org.springframework.util.DigestUtils;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author Sagar Kanojia
 */
public class MD5Hash {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String[] list = {"hshshhhss", "bshhehsshs", "sgsbeehshs"};
        for (String id : list) {
            System.out.print(id + " ");
            String hash = stringToMD5Hash(id);
            System.out.println(hash);
        }
    }


    public static String stringToMD5Hash(String string) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(string.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return hash;
    }

    public static String fileCheckSumMD5(File file) throws NoSuchAlgorithmException, IOException {
        byte[] data = Files.readAllBytes(file.toPath());
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(data);
        byte[] digest = md.digest();
        String checkSum = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return checkSum;
    }


    public String stringToMD5HashUsingApacheCommon(String string) {
//        String md5Hex = DigestUtils
//                .md5Hex(string).toUpperCase();
//        return md5Hex;

        return null;
    }


}
