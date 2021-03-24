package com.mst.java.mini.projet.usf.elm.helpers;

import java.util.Base64;

public class EncryptionHelper {
    /*inspired from  Al-Mothafar
    * response link on StackOverflow :
    * https://stackoverflow.com/a/37318088/13783377
    */

    /**
     * @param data the data your would like to encrypt
     * @return the encrypted data
     */
    //encrypt
    public static String encrypt(String data) {
        String b64encoded = Base64.getEncoder().encodeToString(data.getBytes());
        // Reverse the string
        String reverse = new StringBuffer(b64encoded).reverse().toString();

        StringBuilder tmp = new StringBuilder();
        final int OFFSET = 4;
        for (int i = 0; i < reverse.length(); i++) {
            tmp.append((char) (reverse.charAt(i) + OFFSET));
        }
        return tmp.toString();
    }


    public static String decrypt(String encryptedData) {


        StringBuilder tmp = new StringBuilder();
        final int OFFSET = 4;
        for (int i = 0; i < encryptedData.length(); i++) {
            tmp.append((char) (encryptedData.charAt(i) - OFFSET));
        }
        String reversed = new StringBuffer(tmp.toString()).reverse().toString();
        return new String(Base64.getDecoder().decode(reversed));
    }
}
