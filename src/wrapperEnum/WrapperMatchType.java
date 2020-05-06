/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrapperEnum;

import controller.Controller;
import domain.MatchType;
import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;
import static domain.MatchType.*;


/**
 *
 * @author veljko
 */
public class WrapperMatchType implements Serializable{

    MatchType matchType;

    public WrapperMatchType(MatchType matchType) {
        this.matchType = matchType;
    }

    @Override
    public String toString() {
       
        Locale locale = Controller.getLocale();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resourceBundles.ResourceBundle_MatchType",locale);

        if (matchType == WorldCup) {
            return resourceBundle.getString("WorldCup");
        }
        if (matchType == FriendlyGame) {
            return resourceBundle.getString("FriendlyGame");
        }
        if (matchType == ConfederationCup) {
            return resourceBundle.getString("ConfederationCup");
        }
        if (matchType == WorldCupQualifier) {
            return resourceBundle.getString("WorldCupQualifier");
        }
        return "n/a";
    }

    public MatchType getConfederation() {
        return matchType;
    }
}
