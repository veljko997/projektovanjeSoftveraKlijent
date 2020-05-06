/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import controller.Controller;
import exceptions.BusyUsernameException;
import exceptions.DatabaseException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import transfer.RequestObject;
import transfer.ResponseObject;
import static util.Operation.*;
import util.ResponseStatus;

/**
 *
 * @author veljko
 */
public class ServiceRegistration {

    private final Logger logger = Logger.getLogger(ServiceRegistration.class);
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public ServiceRegistration(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }

    public void register(String username, String password) throws Exception {
        RequestObject requestObject = new RequestObject();
        Map<String, String> userMap = new HashMap<>();
        ResponseObject responseObject;

        userMap.put("username", username);
        userMap.put("password", password);

        requestObject.setData(userMap);
        requestObject.setOperation(OPERATION_REGISTRATION);

        try {
            out.writeObject(requestObject);
            responseObject = (ResponseObject) in.readObject();
            if (responseObject.getStatus() == ResponseStatus.ERROR) {
                if (responseObject.getErrorMessage().equals("Username is busy.")) {
                    throw Controller.readResourceBundle(new BusyUsernameException());
                } else {
                    throw Controller.readResourceBundle(new DatabaseException());
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            logger.error(ex.getMessage());
        }

    }

}
