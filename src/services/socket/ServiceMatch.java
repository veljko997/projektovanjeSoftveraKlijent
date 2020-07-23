/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.socket;

import domain.Match;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import org.apache.log4j.Logger;
import transfer.RequestObject;
import transfer.ResponseObject;
import static util.Operation.*;
import util.ResponseStatus;

/**
 *
 * @author veljko
 */
public class ServiceMatch {

    private final Logger logger = Logger.getLogger(ServiceMatch.class);
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public ServiceMatch(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }

    public boolean saveMatch(Match match, int id) {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(OPERATION_SAVE_MATCH);
        HashMap<String, Object> hashMap = new HashMap<>();
        
        hashMap.put("Match", match);
        hashMap.put("Id", id);
        requestObject.setData(hashMap);
        
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
