/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrapperEnum;

import controller.Controller;
import domain.Confederation;
import static domain.Confederation.*;
import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author veljko
 */
public class WrapperConfederation implements Serializable {

    Confederation confederation;

    public WrapperConfederation(Confederation confederation) {
        this.confederation = confederation;
    }

    @Override
    public String toString() {

        Locale locale = Controller.getLocale();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resourceBundles.ResourceBundle_Confederation", locale);

        if (confederation == ASIA) {
            return resourceBundle.getString("Asia");
        }
        if (confederation == EUROPE) {
            return resourceBundle.getString("Europe");
        }
        if (confederation == SOUTHAMERICA) {
            return resourceBundle.getString("SouthAmerica");
        }
        if (confederation == NORTHAMERICA) {
            return resourceBundle.getString("NorthAmerica");
        }
        if (confederation == OCEANIA) {
            return resourceBundle.getString("Oceania");
        }
        if (confederation == AFRICA) {
            return resourceBundle.getString("Africa");
        }
        return "n/a";
    }

    public Confederation getConfederation() {
        return confederation;
    }
}
