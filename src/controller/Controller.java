/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Match;
import domain.Selection;
import exceptions.ServerException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Locale;
import org.apache.log4j.Logger;
import services.ServiceCryptPassword;
import services.ServiceDeativateSelection;
import services.ServiceGetAllConfederation;
import services.ServiceGetAllMatchTypes;
import services.ServiceGetAllMatches;
import services.ServiceLogin;
import services.ServiceReadExceptionBundles;
import services.ServiceRegistration;
import services.ServiceDeleteMatch;
import services.ServiceDeleteSelection;
import services.ServiceMatch;
import services.ServiceRangList;
import services.ServiceSelection;
import services.SystemDetails;
import wrapperEnum.WrapperConfederation;
import wrapperEnum.WrapperMatchType;

/**
 *
 * @author veljko
 */
public class Controller {

    private static Controller instance;

    private final Socket socket;
    private final ObjectOutputStream objectOutputStream;
    private final ObjectInputStream objectInputStream;
    private final static Logger logger = Logger.getLogger(Controller.class);

    private Controller() throws IOException {
        socket = new Socket("localhost", 9000);
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());
    }

    public static Controller getInstance() throws ServerException {
        if (instance == null) {
            try {
                instance = new Controller();
            } catch (IOException ex) {
                logger.fatal(ex.getMessage());
                throw new ServerException("Server side error");
            }
        }
        return instance;
    }

    public void writeLanguage(String language, String country) {
        SystemDetails.getInstance().writeLanguage(language, country);
    }

    public void login(String username, String password) throws Exception {
        new ServiceLogin(objectOutputStream, objectInputStream).
                LoginUser(username, cryptPassoword(password));
    }

    public void writeUsername(String username) {
        SystemDetails.getInstance().writeUser(username);
    }

    public void writeUserId(String id) {
        SystemDetails.getInstance().writeUserId(id);
    }


    public List<Selection> getAllSelections() {
        return new ServiceSelection(objectOutputStream, objectInputStream).
                getAllSelections();
    }

    public boolean saveMatch(Match match) {
        return new ServiceMatch(objectOutputStream, objectInputStream).
                saveMatch(match,readId());
    }

    public void register(String username, String password) throws ServerException, Exception {
        new ServiceRegistration(objectOutputStream, objectInputStream).
                register(username, cryptPassoword(password));
    }

    public List<Selection> getRangList() {
        return new ServiceRangList(objectOutputStream, objectInputStream).getRangList();
    }

    public List<WrapperMatchType> getAllMatchTypes() {
        return ServiceGetAllMatchTypes.getAll();
    }

    public List<WrapperConfederation> getAllConfederation() {
        return ServiceGetAllConfederation.getAll();
    }

    public List<Match> getMatches(Selection selection) {
        return new ServiceGetAllMatches(objectOutputStream, objectInputStream).getAll(selection);
    }

    public static Exception readResourceBundle(Exception exception) {
        return ServiceReadExceptionBundles.readException(exception);
    }

    public static Locale getLocale() {
        return SystemDetails.getInstance().getLocale();
    }

    public String readId() {
        return SystemDetails.getInstance().getUserId();
    }

    public boolean saveSelection(Selection selection) {
          return new ServiceSelection(objectOutputStream, objectInputStream).
                saveSelection(selection,Integer.parseInt(readId().trim()));
    }

    public void writeAdministrator(boolean administator) {
        SystemDetails.getInstance().writeAdministator(administator);
    }
    
    public boolean readAdministrator() {
        return SystemDetails.getInstance().getAdministrator();
    }

    public boolean deleteMatch(Match match) {
        return new ServiceDeleteMatch(objectOutputStream,objectInputStream).deleteMatch(match);
    }

    public boolean deleteSelection(Selection selection) {
        return new ServiceDeleteSelection(objectOutputStream,objectInputStream).deleteSelection(selection);
    }

    public boolean deactivateSelection(Selection selection) {
        return new ServiceDeativateSelection(objectOutputStream, objectInputStream).deactivateSelection(selection);
    }

    public String cryptPassoword(String password) {
        return ServiceCryptPassword.Crypt(password);
    }
}
