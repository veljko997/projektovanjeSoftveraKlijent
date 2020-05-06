/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.validator;

/**
 *
 * @author student1
 */
public class NumberValidator implements Validator{

    @Override
    public void validate(Object value) throws Exception {
        try{
           Integer.parseInt(value.toString());
        }catch(NumberFormatException nfe){
            throw new NumberFormatException("Value: "+ value + " is not number");
        }
        
    }
    
}
