package com.adventOfCode;

import java.security.MessageDigest;

/**
 --- Part Two ---

 Now find one that starts with six zeroes.

 input: "ckczppom"
 */
public class day04part02 {

    public static void main(String[] args) throws Exception {

        String key = "ckczppom";
        boolean foundAnswer = false;
        int pass = 1;
        char zero = "0".charAt(0);

        while(foundAnswer == false){
            String check = hashMD5(key + pass);
            // Check the first five characters for 0's
            if(check.charAt(0) == zero && check.charAt(1) == zero && check.charAt(2) == zero && check.charAt(3) == zero && check.charAt(4) == zero && check.charAt(5) == zero) {
                System.out.println("Original: " + key + pass);
                System.out.println("MD5: " + check);
                foundAnswer = true;
            }
            else {
                pass++;
            }

        }
    }

    public static String hashMD5(String s) throws Exception{
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(s.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest){
            sb.append(String.format("%02x", b &0xff));
        }
        return sb.toString();
    }

}
