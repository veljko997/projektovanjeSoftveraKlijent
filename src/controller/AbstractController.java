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
import services.common.ServiceCryptPassword;
import services.common.ServiceGetAllConfederation;
import services.common.ServiceGetAllMatchTypes;
import services.common.ServiceReadExceptionBundles;
import services.common.SystemDetails;
import wrapperEnum.WrapperConfederation;
import wrapperEnum.WrapperMatchType;

/**
 *
 * @author Veljko
 */
public abstract class AbstractController {

    public void writeLanguage(String language, String country) {
        SystemDetails.writeLanguage(language, country);
    }

    public void writeUsername(String username) {
        SystemDetails.writeUser(username);
    }

    public void writeUserId(String id) {
        SystemDetails.writeUserId(id);
    }

    public List<WrapperMatchType> getAllMatchTypes() {
        return ServiceGetAllMatchTypes.getAll();
    }

    public List<WrapperConfederation> getAllConfederation() {
        return ServiceGetAllConfederation.getAll();
    }

    public String cryptPassoword(String password) {
        return ServiceCryptPassword.Crypt(password);
    }

    public void writeAdministrator(boolean administator) {
        SystemDetails.writeAdministator(administator);
    }

    public boolean readAdministrator() {
        return SystemDetails.getAdministrator();
    }

    public Exception readResourceBundle(Exception exception) {
        return ServiceReadExceptionBundles.readException(exception);
    }

    public Locale getLocale() {
        return SystemDetails.getLocale();
    }

    public int readId() {
        return SystemDetails.getUserId();
    }

    public abstract boolean deactivateSelection(Selection selection);

    public abstract boolean deleteSelection(Selection selection);

    public abstract boolean deleteMatch(Match match);

    public abstract boolean saveSelection(Selection selection);

    public abstract List<Match> getMatches(Selection selection);

    public abstract List<Selection> getRangList();

    public abstract void register(String username, String password) throws ServerException, Exception;

    public abstract boolean saveMatch(Match match);

    public abstract List<Selection> getAllSelections();

    public abstract void login(String username, String password) throws Exception;
}
