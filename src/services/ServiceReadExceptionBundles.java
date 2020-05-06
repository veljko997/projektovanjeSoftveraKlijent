/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import controller.Controller;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;

/**
 *
 * @author Veljko
 */
public class ServiceReadExceptionBundles {
    
   private final static Logger LOGGER = Logger.getLogger(ServiceReadExceptionBundles.class);

    public static Exception readException(Exception ex) {
        try {
            Locale locale = Controller.getLocale();

            String exceptionType = ex.getClass().getName();
            ResourceBundle resourceBundle = ResourceBundle.getBundle("resourceBundles.ResourceBundle_Exception_" + locale);
            String message = resourceBundle.getString(exceptionType);

            Class<?> c = Class.forName(exceptionType);
            Constructor<?> cons = c.getConstructor(String.class);
            ex = (Exception) cons.newInstance(message);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex1) {
           LOGGER.error(ex.getMessage());
        }
        return ex;
    }
}
