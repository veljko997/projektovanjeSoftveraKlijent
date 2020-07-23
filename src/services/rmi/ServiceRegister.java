/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rmi;

import controller.Controller;
import exceptions.BusyUsernameException;
import org.apache.log4j.Logger;
import rmi.RMI;
import services.common.ServiceCryptPassword;

/**
 *
 * @author Veljko
 */
public class ServiceRegister {

    private final RMI rmi;
    private final Logger logger = org.apache.log4j.Logger.getLogger(ServiceRangLista.class);

    public ServiceRegister(RMI rmi) {
        this.rmi = rmi;
    }

    public boolean Register(String username, String password) throws Exception {
        try {
            return rmi.register(username, ServiceCryptPassword.Crypt(password));
        } catch (Exception ex) {
            logger.error(ex);
            throw Controller.getInstance().readResourceBundle(new BusyUsernameException());
        }
    }
}
