/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Selection;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;
import transfer.RequestObject;
import transfer.ResponseObject;
import static util.Operation.*;

/**
 *
 * @author Veljko
 */
public class ServiceRangList {

    private final Logger logger = Logger.getLogger(ServiceRangList.class);
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public ServiceRangList(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }

    public List<Selection> getRangList() {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(OPERATION_RANG_LIST);
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
}
