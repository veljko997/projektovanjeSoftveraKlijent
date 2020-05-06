/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Match;
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
public class ServiceGetAllMatches {

    private final ObjectOutputStream out;
    private final ObjectInputStream in;
    private final Logger logger = Logger.getLogger(ServiceGetAllMatches.class);

    public ServiceGetAllMatches(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }

    public List<Match> getAll(Selection selection) {
        List<Match> matches = new LinkedList<>();
        RequestObject requestObject = new RequestObject();
        requestObject.setData(selection);
        requestObject.setOperation(OPERATION_GET_ALL_MATCHES);
        try {
            out.writeObject(requestObject);
            matches = (List<Match>) ((ResponseObject) in.readObject()).getData();
        } catch (IOException | ClassNotFoundException ex) {
            logger.error(ex.getMessage());
        }
        return matches;
    }

}
