/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.socket;

import domain.Selection;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.apache.log4j.Logger;
import transfer.RequestObject;
import transfer.ResponseObject;
import static util.Operation.*;
import util.ResponseStatus;

/**
 *
 * @author Veljko
 */
public class ServiceDeativateSelection {

    private final ObjectOutputStream out;
    private final ObjectInputStream in;
    private final Logger logger = Logger.getLogger(ServiceDeativateSelection.class);

    public ServiceDeativateSelection(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }

    public boolean deactivateSelection(Selection selection) {
        RequestObject requestObject = new RequestObject();
        requestObject.setData(selection);
        requestObject.setOperation(OPERATION_DEACTIVATE_SELECTION);
        try {
            out.writeObject(requestObject);
            ResponseObject responseObject = (ResponseObject) in.readObject();
            return responseObject.getStatus() == ResponseStatus.SUCESS;
        } catch (IOException | ClassNotFoundException ex) {
            logger.error(ex.getMessage());
            return false;
        }
    }
}
