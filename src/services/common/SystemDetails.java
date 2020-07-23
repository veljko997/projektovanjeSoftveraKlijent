/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.common;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author veljko
 */
public class SystemDetails {

    private static Properties properties = new Properties();
    private final Logger logger = Logger.getLogger(SystemDetails.class);

    private SystemDetails() {
        try {
            properties = new Properties();
            properties.load(getClass().getResourceAsStream("System.properties"));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    public static Locale getLocale() {
        return new Locale(properties.getProperty("language"), properties.getProperty("country"));
    }


    public static void writeLanguage(String language, String country) {
        properties.put("language", language);
        properties.put("country", country);
    }

    public static String getLanguage() {
        return properties.getProperty("language");
    }

    public static String getCountry() {
        return properties.getProperty("country");
    }

    public static void writeUser(String username) {
        properties.put("username", username);
    }

    public static void writeUserId(String id) {
        properties.put("userId", id);
    }

    public static String getUser() {
        return properties.getProperty("username");
    }

    public static int getUserId() {
        return Integer.parseInt(properties.getProperty("userId"));
    }

    public static void writeAdministator(boolean administator) {
        properties.put("administrator", administator);
    }

    public static boolean getAdministrator() {
        return (boolean) properties.get("administrator");
    }
}
