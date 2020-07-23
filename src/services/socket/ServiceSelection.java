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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import transfer.RequestObject;
import transfer.ResponseObject;
import util.Operation;
import util.ResponseStatus;

/**
 *
 * @author veljko
 */
public class ServiceSelection {

    private final Logger logger = Logger.getLogger(ServiceSelection.class);
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public ServiceSelection(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }

    public List<Selection> getAllSelections() {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_ALL_SELECTIONS);
        List<Selection> selections = new LinkedList<>();

        try {
            out.writeObject(requestObject);
            ResponseObject responseObject = (ResponseObject) in.readObject();
            selections = (List<Selection>) responseObject.getData();
        } catch (IOException | ClassNotFoundException ex) {
            logger.error(ex.getMessage());
        }
        return selections;
    }

    public boolean saveSelection(Selection selection, int id) {
        RequestObject requestObject = new RequestObject();
        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("Selection", selection);
        hashMap.put("Id", id);
        requestObject.setData(hashMap);
        requestObject.setOperation(Operation.OPERATION_SAVE_SELECTION);
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
