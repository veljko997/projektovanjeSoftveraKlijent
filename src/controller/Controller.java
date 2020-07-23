/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Match;
import domain.Selection;
import exceptions.ServerException;
import java.util.List;
import java.util.Locale;
import services.common.ServiceCreateControllers;
import wrapperEnum.WrapperConfederation;
import wrapperEnum.WrapperMatchType;

/**
 *
 * @author Veljko
 */
public class Controller {

    protected static AbstractController instance;

    public static AbstractController getInstance() throws Exception {
        if (instance == null) {
            instance = ServiceCreateControllers.createSocketFirst();
        }
        return instance;
    }
    
     public void writeLanguage(String language, String country) {
        instance.writeLanguage(language, country);
    }

    public void writeUsername(String username) {
        instance.writeUsername(username);
    }

    public void writeUserId(String id) {
        instance.writeUserId(id);
    }

    public List<WrapperMatchType> getAllMatchTypes() {
        return instance.getAllMatchTypes();
    }

    public List<WrapperConfederation> getAllConfederation() {
        return instance.getAllConfederation();
    }

    public String cryptPassoword(String password) {
        return instance.cryptPassoword(password);
    }

    public void writeAdministrator(boolean administator) {
        instance.writeAdministrator(administator);
    }

    public boolean readAdministrator() {
        return instance.readAdministrator();
    }

    public static Exception readResourceBundle(Exception exception) {
        return instance.readResourceBundle(exception);
    }

    public static Locale getLocale() {
        return instance.getLocale();
    }

    public int readId() {
        return instance.readId();
    }

    public boolean deactivateSelection(Selection selection) {
        return instance.deactivateSelection(selection);
    }

    public boolean deleteSelection(Selection selection){
        return instance.deleteSelection(selection);
    }

    public boolean deleteMatch(Match match) {
        return instance.deleteMatch(match);
    }

    public boolean saveSelection(Selection selection) {
        return instance.saveSelection(selection);
    }

    public List<Match> getMatches(Selection selection){
        return instance.getMatches(selection);
    }

    public List<Selection> getRangList(){
        return instance.getRangList();
    }

    public void register(String username, String password) throws ServerException, Exception {
        instance.register(username, password);
    }

    public  boolean saveMatch(Match match) {
        return instance.saveMatch(match);
    }

    public List<Selection> getAllSelections() {
        return instance.getAllSelections();
    }

    public void login(String username, String password) throws Exception {
        instance.login(username, password);
    } 

}
