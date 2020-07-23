/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rmi;

import controller.Controller;
import domain.User;
import exceptions.DeletedUserException;
import exceptions.NoSuchUserException;
import org.apache.log4j.Logger;
import rmi.RMI;
import services.common.ServiceCryptPassword;

/**
 *
 * @author Veljko
 */
public class ServiceLogin {

    private final RMI rmi;
    private final Logger logger = org.apache.log4j.Logger.getLogger(ServiceLogin.class);

    public ServiceLogin(RMI rmi) {
        this.rmi = rmi;
    }

    public void login(String username, String password) throws Exception {
        User user = rmi.login(username, ServiceCryptPassword.Crypt(password));
        if (user == null) {
            logger.info("Login with wrong username or password");
            throw new NoSuchUserException();
        } else if (!user.isActive()) {
            logger.info("Deleted user " + username + " trying to login.");
            throw new DeletedUserException();
        }
        writeSystemDetails(user);
        
    }

    private void writeSystemDetails(User user) throws Exception {
        logger.info("Succesfull login by " + user.getUsername());
        Controller.getInstance().writeUsername(user.getUsername());
        Controller.getInstance().writeUserId(user.getId() + "");
        Controller.getInstance().writeAdministrator(user.isAdministator());
    }
}
