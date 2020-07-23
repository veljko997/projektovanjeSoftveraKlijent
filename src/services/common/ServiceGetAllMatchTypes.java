/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.common;

import domain.MatchType;
import java.util.LinkedList;
import java.util.List;
import wrapperEnum.WrapperMatchType;


/**
 *
 * @author veljko
 */
public class ServiceGetAllMatchTypes {

    
    public static List<WrapperMatchType> getAll() {
         List<WrapperMatchType> confederations = new LinkedList<>();
         confederations.add(new WrapperMatchType(MatchType.ConfederationCup));
         confederations.add(new WrapperMatchType(MatchType.FriendlyGame));
         confederations.add(new WrapperMatchType(MatchType.WorldCup));
         confederations.add(new WrapperMatchType(MatchType.WorldCupQualifier));
         return confederations;
    } 

   
}
