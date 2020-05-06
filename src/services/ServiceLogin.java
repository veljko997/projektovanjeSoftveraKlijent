/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import controller.Controller;
import domain.User;
import exceptions.DatabaseException;
import exceptions.DeletedUserException;
import exceptions.NoSuchUserException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import transfer.RequestObject;
import transfer.ResponseObject;
import static util.Operation.OPERATION_LOGIN;
import util.ResponseStatus;

/**
 *
 * @author Veljko
 */
public class ServiceLogin {

    private final ObjectOutputStream out;
    private final ObjectInputStream in;
    private final Logger logger = Logger.getLogger(ServiceLogin.class);

    public ServiceLogin(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }

    public void LoginUser(String username, String password) throws Exception {
        User user = null;
        RequestObject requestObject = new RequestObject();
        Map<String, String> userMap = new HashMap<>();
        ResponseObject responseObject;
        
        userMap.put("username", username);
        userMap.put("password", password);
        
        requestObject.setData(userMap);
        requestObject.setOperation(OPERATION_LOGIN);
        out.writeObject(requestObject);
        
        try {
            responseObject = (ResponseObject) in.readObject();
            user = (User) responseObject.getData();
        } catch (IOException | ClassNotFoundException ex) {
            logger.error(ex.getMessage());
            throw new DatabaseException();
        }
        
        if(responseObject.getStatus() == ResponseStatus.ERROR) throw new DatabaseException();
        
        if (user == null) {
            logger.info("Login with wrong username or password");
            throw new NoSuchUserException();
        } else if (!user.isActive()) {
            logger.info("Deleted user " + username + " trying to login.");
            throw new DeletedUserException();
        }
        
        logger.info("Succesfull login by " + username);
        Controller.getInstance().writeUsername(user.getUsername());
        Controller.getInstance().writeUserId(user.getId() + "");
        Controller.getInstance().writeAdministrator(user.isAdministator());
    }
}
