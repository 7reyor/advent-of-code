package com.adventOfCode;

import java.security.MessageDigest;

/**
 --- Day 4: The Ideal Stocking Stuffer ---

 Santa needs help mining some AdventCoins (very similar to bitcoins) to use as gifts for all the economically forward-thinking little girls and boys.

 To do this, he needs to find MD5 hashes which, in hexadecimal, start with at least five zeroes. The input to the MD5 hash is some secret key (your puzzle input, given below) followed by a number in decimal. To mine AdventCoins, you must find Santa the lowest positive number (no leading zeroes: 1, 2, 3, ...) that produces such a hash.

 For example:

    If your secret key is abcdef, the answer is 609043, because the MD5 hash of abcdef609043 starts with five zeroes (000001dbbfa...), and it is the lowest such number to do so.
    If your secret key is pqrstuv, the lowest number it combines with to make an MD5 hash starting with five zeroes is 1048970; that is, the MD5 hash of pqrstuv1048970 looks like 000006136ef....

    input: "ckczppom"
 */
public class day04part01 {

    public static void main(String[] args) throws Exception {

        String key = "ckczppom";
        boolean foundAnswer = false;
        int pass = 1;
        char zero = "0".charAt(0);

        while(foundAnswer == false){
            String check = hashMD5(key + pass);
            // Check the first five characters for 0's
            if(check.charAt(0) == zero && check.charAt(1) == zero && check.charAt(2) == zero && check.charAt(3) == zero && check.charAt(4) == zero) {
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
