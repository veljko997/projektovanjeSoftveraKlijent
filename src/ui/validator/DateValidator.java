/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.validator;

import controller.Controller;
import exceptions.IllegalDateException;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Veljko
 */
public class DateValidator implements Validator {

    Locale locale;
    
    @Override
    public void validate(Object value) throws Exception {
            Date date = (Date) value;
            if (date.after(new Date())) {
                throw Controller.readResourceBundle(new IllegalDateException());
        }
    }
    
    public void setLocale(Locale locale){
        this.locale=locale;
    }
}
