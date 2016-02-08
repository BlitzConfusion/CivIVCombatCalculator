
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civivcombatcalculator.civivcombatcalculator;

import static java.lang.Math.pow;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tatu
 */
public class Laskija {
    private Voimasuhde voimasuhde;
    //private FSKombinatooria fsKombinatooria;
    private Kombinatooria kombi;
    
    public Laskija(double attack, double defend, int abonus, int dbonus,
            int attackFS, int defendFS) {
        int bonus;
        double a = attack;
        double d = defend;
        if (abonus < dbonus) {
            bonus = dbonus - abonus;
            d *= 1.0 * (bonus + 100) / 100;
        } else {
            bonus = abonus - dbonus;
            a *= 1.0 * (bonus + 100) / 100;
        }
        try {
            voimasuhde = new Voimasuhde(a, d);
            //fsKombinatooria = new FSKombinatooria(voimasuhde, attackFS, defendFS);
        } catch (Exception ex) {
            System.out.println("Invalid values");
        }
    }
    
    public static int kertoma(int n) {
        int kertoma = 1;
        for (int i = 1; i <= n; i++) {
            kertoma *= i;
        }
        return kertoma;
    }
    
    public double laskeHyokkaysTod(){
        //Tämä on alustavasti ilman First Strikea jotta saan pohjan aikaiseksi.
        // jostain syystä kombinatoorian kombinaatio-metodin kutsunta aiheuttaa
        // NullPointerExceptionin. Miksi?
        double chance = 0;
        double attack = voimasuhde.attackReturn();
        double defend = voimasuhde.defendReturn();
        int aLength = voimasuhde.victoryAttackReturn();
        int dLength = voimasuhde.victoryDefendReturn();
        double subChance = 0;
        if (attack < defend) {
            for(int i = 0; i < dLength; i++) {
                int vali = kombi.kombinaatio(2, 2);
                subChance = (double) vali;
                subChance *= Math.pow(defend, (double) dLength);
                subChance *= Math.pow(attack, (double) i);
                chance += subChance;
            }
            return (1.0 - chance);
        } else {
            for(int j = 0; j < aLength; j++) {
                subChance = kombi.kombinaatio(2, 2);
                subChance *= pow(attack, (double) aLength);
                subChance *= pow(defend, (double) j);
                chance += subChance;
            }
        }
        
        return chance;
        
    
    }
    public static double kertomaOsuus(int a, int b) {
        double summa = kertoma(a + b) * 1.0;
        double akertoma = kertoma(a) * 1.0;
        double bkertoma = kertoma(b) * 1.0;
        return summa / (akertoma * bkertoma);
    }
}
