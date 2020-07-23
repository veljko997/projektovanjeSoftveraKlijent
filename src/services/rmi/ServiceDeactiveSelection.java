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
public class ServiceDeactiveSelection {
    private final RMI rmi;
    private final Logger logger = org.apache.log4j.Logger.getLogger(ServiceDeactiveSelection.class);

    public ServiceDeactiveSelection(RMI rmi) {
        this.rmi = rmi;
    }

    public boolean deactiveSelection(Selection selection) {
        try {
            return rmi.deactiveSelection(selection);
        } catch (Exception ex) {
            logger.error(ex);
            return false;
        }
    }
}
