package com.software.practices.solutions.hashing;

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
public class Base64Hash {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String[] list = {"xhsehshhshhs", "bshhehsshs", "sgsbeehshs"};
        for (String id : list) {
            System.out.print(id + " ");
            String hash = stringSha256ToBase64(id);
            System.out.println(hash);
        }

    }

    public static String stringSha256ToBase64(String string) throws NoSuchAlgorithmException {
        MessageDigest digester = MessageDigest.getInstance("SHA-256");
        digester.update(string.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(digester.digest());
    }

    public static String fileSha256ToBase64(File file) throws NoSuchAlgorithmException, IOException {
        byte[] data = Files.readAllBytes(file.toPath());
        MessageDigest digester = MessageDigest.getInstance("SHA-256");
        digester.update(data);
        return Base64.getEncoder().encodeToString(digester.digest());
    }
}
