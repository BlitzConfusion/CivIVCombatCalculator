/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civivcombatcalculator.civivcombatcalculator;
import java.util.*;
/**
 *
 * @author Tatu
 */
public class Main {
    
    public static void main(String[] args) {
        Laskija laskija = new Laskija(40, 8, 0, 0, 0, 0);
        //jostain syystä chanssit aiheuttaa nullpointerexceptionin. Miksi?
        //Voimasuhde vs = new Voimasuhde(40, 38.09);
        Kombinatooria kombi = new Kombinatooria();
        System.out.println(kombi.kombinaatio(18, 9));
        //System.out.println("ABAABA");
        //System.out.println(vs.attackReturn());
        //System.out.println(vs.defendReturn());
        //System.out.println(vs.victoryAttackReturn());
        //System.out.println(vs.victoryDefendReturn());
        //System.out.println(laskija.laskeHyokkaysTod());
        
    }
}
    

