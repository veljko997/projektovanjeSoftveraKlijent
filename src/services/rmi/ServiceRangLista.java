/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rmi;

import domain.Match;
import domain.Selection;
import java.util.List;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import rmi.RMI;

/**
 *
 * @author Veljko
 */
public class ServiceRangLista {

    private final RMI rmi;
    private final Logger logger = org.apache.log4j.Logger.getLogger(ServiceRangLista.class);

    public ServiceRangLista(RMI rmi) {
        this.rmi = rmi;
    }

    public List<Selection> getRangList() {
        try {
            return rmi.getRangList();
        } catch (Exception ex) {
            logger.error(ex);
            return null;
        }
    }
}
