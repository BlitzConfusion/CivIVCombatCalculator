/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civivcombatcalculator.civivcombatcalculator;
import java.util.*;
import graphicspackage.*;
/**
 *
 * @author Tatu
 */
public class Main {
    
    public static void main(String[] args) {
        //CombatCalculator laskin = new CombatCalculator();
        Laskija laske = new Laskija(60, 60, 0, 0, 0, 0, 0, 20, 20);
        System.out.println(laske.returnOdds());
        Laskija lasku = new Laskija(60, 60, 0, 0, 0, 0, 0, 20, 0);
        System.out.println(lasku.returnOdds());
        System.out.println(laske.returnWithdraw());
        //Kombinatooria kombi = new Kombinatooria(7, 5);
        //System.out.println(kombi.kombinaatio());
    }
}
    

