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
public class ServiceDeleteSelection {

    private final RMI rmi;
    private final Logger logger = org.apache.log4j.Logger.getLogger(ServiceDeleteSelection.class);

    public ServiceDeleteSelection(RMI rmi) {
        this.rmi = rmi;
    }

    public boolean deleteSelection(Selection selection) {
        try {
            return rmi.deactiveSelection(selection);
        } catch (Exception ex) {
            logger.error(ex);
            return false;
        }

    }
}
