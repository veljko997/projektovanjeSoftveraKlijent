/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components;

/**
 *
 * @author student1
 */
public interface IValue {
    public Object getValue() throws Exception;
    public void initialize(Object initValue);
    public void setValue(Object value);
}
