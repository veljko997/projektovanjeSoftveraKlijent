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
import org.apache.log4j.Logger;
import services.socket.ServiceDeativateSelection;
import services.socket.ServiceGetAllMatches;
import services.socket.ServiceLogin;
import services.socket.ServiceRegistration;
import services.socket.ServiceDeleteMatch;
import services.socket.ServiceDeleteSelection;
import services.socket.ServiceMatch;
import services.socket.ServiceRangList;
import services.socket.ServiceSelection;

/**
 *
 * @author veljko
 */
public class SocketController extends AbstractController {

    private final Socket socket;
    private final ObjectOutputStream objectOutputStream;
    private final ObjectInputStream objectInputStream;

    public SocketController() throws IOException {
        socket = new Socket("localhost", 9000);
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void login(String username, String password) throws Exception {
        new ServiceLogin(objectOutputStream, objectInputStream).
                LoginUser(username, cryptPassoword(password));
    }

    @Override
    public List<Selection> getAllSelections() {
        return new ServiceSelection(objectOutputStream, objectInputStream).
                getAllSelections();
    }

    @Override
    public boolean saveMatch(Match match) {
        return new ServiceMatch(objectOutputStream, objectInputStream).
                saveMatch(match, readId());
    }

    @Override
    public void register(String username, String password) throws ServerException, Exception {
        new ServiceRegistration(objectOutputStream, objectInputStream).
                register(username, cryptPassoword(password));
    }

    @Override
    public List<Selection> getRangList() {
        return new ServiceRangList(objectOutputStream, objectInputStream).getRangList();
    }

    @Override
    public List<Match> getMatches(Selection selection) {
        return new ServiceGetAllMatches(objectOutputStream, objectInputStream).getAll(selection);
    }

    @Override
    public boolean saveSelection(Selection selection) {
        return new ServiceSelection(objectOutputStream, objectInputStream).
                saveSelection(selection, readId());
    }

    @Override
    public boolean deleteMatch(Match match) {
        return new ServiceDeleteMatch(objectOutputStream, objectInputStream).deleteMatch(match);
    }

    @Override
    public boolean deleteSelection(Selection selection) {
        return new ServiceDeleteSelection(objectOutputStream, objectInputStream).deleteSelection(selection);
    }

    @Override
    public boolean deactivateSelection(Selection selection) {
        return new ServiceDeativateSelection(objectOutputStream, objectInputStream).deactivateSelection(selection);
    }

}
