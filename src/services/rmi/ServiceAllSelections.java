/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rmi;

import domain.Selection;
import java.util.List;
import org.apache.log4j.Logger;
import rmi.RMI;

/**
 *
 * @author Veljko
 */
public class ServiceAllSelections {

    private final RMI rmi;
    private final Logger logger = org.apache.log4j.Logger.getLogger(ServiceDeactiveSelection.class);

    public ServiceAllSelections(RMI rmi) {
        this.rmi = rmi;
    }

    public List<Selection> getAllSelections() throws Exception {
        try {
            return rmi.getAllSelection();
        } catch (Exception ex) {
            logger.error(ex);
            throw ex;
        }
    }
}
