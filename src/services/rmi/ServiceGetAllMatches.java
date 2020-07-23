/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rmi;

import domain.Match;
import domain.Selection;
import java.util.List;
import org.apache.log4j.Logger;
import rmi.RMI;

/**
 *
 * @author Veljko
 */
public class ServiceGetAllMatches {
    private final RMI rmi;
    private final Logger logger = org.apache.log4j.Logger.getLogger(ServiceGetAllMatches.class);

    public ServiceGetAllMatches(RMI rmi) {
        this.rmi = rmi;
    }

    public List<Match> getAllMatches(Selection selection) {
        try {
            return rmi.getMatches(selection);
        } catch (Exception ex) {
            logger.error(ex);
            return null;
        }
    }
}
