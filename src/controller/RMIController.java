/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Match;
import domain.Selection;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import org.apache.log4j.Logger;
import rmi.RMI;
import services.common.SystemDetails;
import services.rmi.ServiceAllSelections;
import services.rmi.ServiceDeactiveSelection;
import services.rmi.ServiceDeleteMatch;
import services.rmi.ServiceDeleteSelection;
import services.rmi.ServiceGetAllMatches;
import services.rmi.ServiceLogin;
import services.rmi.ServiceRangLista;
import services.rmi.ServiceRegister;
import services.rmi.ServiceSaveMatch;
import services.rmi.ServiceSaveSelection;

/**
 *
 * @author Veljko
 */
public class RMIController extends AbstractController {

    private static Registry registry;
    private static RMI rmi;
    private final static Logger LOGGER = org.apache.log4j.Logger.getLogger(RMIController.class);

    public RMIController() throws RemoteException, NotBoundException,NotBoundException {
        registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        rmi = (RMI) registry.lookup("Server");
    }

    @Override
    public boolean deactivateSelection(Selection selection) {
        return new ServiceDeactiveSelection(rmi).deactiveSelection(selection);
    }

    @Override
    public boolean deleteSelection(Selection selection) {
        return new ServiceDeleteSelection(rmi).deleteSelection(selection);
    }

    @Override
    public boolean deleteMatch(Match match) {
        return new ServiceDeleteMatch(rmi).deleteMatch(match);
    }

    @Override
    public boolean saveSelection(Selection selection) {
        return new ServiceSaveSelection(rmi).saveSelection(selection, SystemDetails.getUserId());
    }

    @Override
    public List<Match> getMatches(Selection selection) {
        return new ServiceGetAllMatches(rmi).getAllMatches(selection);
    }

    @Override
    public List<Selection> getRangList() {
        return new ServiceRangLista(rmi).getRangList();
    }

    @Override
    public void register(String username, String password) throws Exception {
        new ServiceRegister(rmi).Register(username, password);
    }

    @Override
    public boolean saveMatch(Match match) {
        return new ServiceSaveMatch(rmi).saveMatch(match, SystemDetails.getUserId());
    }

    
    //ispravi 
    @Override
    public List<Selection> getAllSelections() {
        try {
            return new ServiceAllSelections(rmi).getAllSelections();
        } catch (Exception ex) {
            LOGGER.error(ex);
            return null;
        }
    }

    @Override
    public void login(String username, String password) throws Exception {
        new ServiceLogin(rmi).login(username, password);
    }

}
