/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rmi;

import domain.Match;
import org.apache.log4j.Logger;
import rmi.RMI;

/**
 *
 * @author Veljko
 */
public class ServiceSaveMatch {

    private final RMI rmi;
    private final Logger logger = org.apache.log4j.Logger.getLogger(ServiceSaveMatch.class);

    public ServiceSaveMatch(RMI rmi) {
        this.rmi = rmi;
    }

    public boolean saveMatch(Match match, int userID) {
        try {
            return rmi.saveMatch(match, userID);
        } catch (Exception ex) {
            logger.error(ex);
            return false;
        }
    }
}
