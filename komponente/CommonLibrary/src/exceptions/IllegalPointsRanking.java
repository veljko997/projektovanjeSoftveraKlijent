/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Veljko
 */
public class IllegalPointsRanking extends Exception{
    
    private String msg;
    
    /**
     * Creates a new instance of <code>IllegalDateException</code> without detail message.
     */
    public IllegalPointsRanking() {
        
    }


    /**
     * Constructs an instance of <code>IllegalDateException</code> with the specified detail
     * message.
     *
     * @param msg the detail message.
     */
    public IllegalPointsRanking(String msg) {
        super(msg);
    }

}

