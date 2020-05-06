/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.log4j.Logger;

/**
 *
 * @author Veljko
 */
public class ServiceCryptPassword {

    private static final Logger LOGGER = Logger.getLogger(ServiceCryptPassword.class);
    
    public static String Crypt(String passoword) {
        String cyrptedPassword = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(passoword.getBytes());
            byte[] digest = messageDigest.digest();
            for (byte b : digest) {
                cyrptedPassword += String.format("%02x", b);
            }
        } catch (NoSuchAlgorithmException ex) {
            LOGGER.error(ex.getMessage());
            throw new RuntimeException(ex);
        }
        return cyrptedPassword;
    }
}
