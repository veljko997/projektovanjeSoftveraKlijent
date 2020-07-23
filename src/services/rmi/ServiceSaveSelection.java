/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rmi;

import domain.Selection;
import org.apache.log4j.Logger;
import rmi.RMI;

/**
 *
 * @author Veljko
 */
public class ServiceSaveSelection {

    private final RMI rmi;
    private final Logger logger = org.apache.log4j.Logger.getLogger(ServiceSaveMatch.class);

    public ServiceSaveSelection(RMI rmi) {
        this.rmi = rmi;
    }

    public boolean saveSelection(Selection selection, int userID) {
        try {
            return rmi.saveSelection(selection, userID);
        } catch (Exception ex) {
            logger.error(ex);
            return false;
        }
    }
}
