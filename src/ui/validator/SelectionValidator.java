/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.validator;

import exceptions.IllegalSelectionName;

/**
 *
 * @author veljko
 */
public class SelectionValidator implements Validator {

    @Override
    public void validate(Object value) throws Exception {
        String nameSelection = value.toString();
        if(nameSelection.isEmpty()) 
         throw new IllegalSelectionName("Prazno ime");
    }
    
}
