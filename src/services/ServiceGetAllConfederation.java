/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Confederation;
import java.util.LinkedList;
import java.util.List;
import wrapperEnum.WrapperConfederation;

/**
 *
 * @author veljko
 */
public class ServiceGetAllConfederation {

    public static List<WrapperConfederation> getAll() {
        List<WrapperConfederation> confederations = new LinkedList<>();
        confederations.add(new WrapperConfederation(Confederation.ASIA));
        confederations.add(new WrapperConfederation(Confederation.EUROPE));
        confederations.add(new WrapperConfederation(Confederation.NORTHAMERICA));
        confederations.add(new WrapperConfederation(Confederation.SOUTHAMERICA));
        confederations.add(new WrapperConfederation(Confederation.AFRICA));
        confederations.add(new WrapperConfederation(Confederation.OCEANIA));
        return confederations;
    }

}
