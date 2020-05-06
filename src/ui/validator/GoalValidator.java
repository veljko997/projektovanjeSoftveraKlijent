/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.validator;

import controller.Controller;
import exceptions.IllegalGoalsException;
import java.util.Locale;

/**
 *
 * @author Veljko
 */
public class GoalValidator implements Validator {

    Locale locale;
    
    public GoalValidator() {
        locale = Controller.getLocale();
    }
    
    @Override
    public void validate(Object value) throws Exception {
        try {
            int broj = Integer.parseInt(value.toString());
            if (broj < 0) {
                throw Controller.readResourceBundle(new IllegalGoalsException());
            }
        } catch (NumberFormatException nfe) {
            throw Controller.readResourceBundle(new IllegalGoalsException());
        }
    }
}   
