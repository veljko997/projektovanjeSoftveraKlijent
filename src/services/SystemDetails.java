/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

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
    private static SystemDetails instance;
    private final Logger logger = Logger.getLogger(SystemDetails.class);

    private SystemDetails() {
        try {
            properties = new Properties();
            properties.load(getClass().getResourceAsStream("System.properties"));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    public Locale getLocale() {
        return new Locale(properties.getProperty("language"), properties.getProperty("country"));
    }

    public static SystemDetails getInstance() {
        if (instance == null) {
            instance = new SystemDetails();
        }
        return instance;
    }

    public void writeLanguage(String language, String country) {
        properties.put("language", language);
        properties.put("country", country);
    }

    public String getLanguage() {
        return properties.getProperty("language");
    }

    public String getCountry() {
        return properties.getProperty("country");
    }

    public void writeUser(String username) {
        properties.put("username", username);
    }

    public void writeUserId(String id) {
        properties.put("userId", id);
    }

    public String getUser() {
        return properties.getProperty("username");
    }

    public String getUserId() {
        return properties.getProperty("userId");
    }

    public void writeAdministator(boolean administator) {
        properties.put("administrator", administator);
    }

    public boolean getAdministrator() {
        return (boolean) properties.get("administrator");
    }
}
