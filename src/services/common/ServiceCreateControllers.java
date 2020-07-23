/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.common;

import controller.AbstractController;
import controller.RMIController;
import controller.SocketController;
import org.apache.log4j.Logger;

/**
 *
 * @author Veljko
 */
public class ServiceCreateControllers {
    
    private final static Logger LOOGER = Logger.getLogger(ServiceCreateControllers.class);
    private static AbstractController instance;

    public static AbstractController createSocketFirst() throws Exception {
        try {
            instance = new SocketController();
        } catch (Exception ex) {
            LOOGER.info(ex);
            instance = new RMIController();
        }
        return instance;
    }
    
    public static AbstractController createRMIFirst() throws Exception {
        try {
            instance = new RMIController();
        } catch (Exception ex) {
            LOOGER.info(ex);
            instance = new SocketController();
        }
        return instance;
    }
}
