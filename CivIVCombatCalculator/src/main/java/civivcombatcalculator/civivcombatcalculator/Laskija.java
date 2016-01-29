
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
public class Laskija {
    private final Voimasuhde voimasuhde;
    private FSKombinatooria fsKombinatooria;
    private Kombinatooria kombinatooria;
    
    public Laskija(double attack, double defend, int abonus, int dbonus,
            int attackFS, int defendFS) throws Exception {
        int bonus;
        if (abonus < dbonus) {
            bonus = dbonus - abonus;
            defend *= (bonus + 100) / 100;
        } else {
            bonus = abonus - dbonus;
            attack *= (bonus + 100) / 100;
        }
        voimasuhde = new Voimasuhde(attack, defend);
        fsKombinatooria = new FSKombinatooria(voimasuhde, attackFS, defendFS);
    }
    
    public static int kertoma(int n) {
        int kertoma = 1;
        for (int i = 1; i <= n; i++) {
            kertoma *= i;
        }
        return kertoma;
    }
    public static double laskeTod(){
        
        
        return 100;
        
    
    }
    public static double kertomaOsuus(int a, int b) {
        double summa = kertoma(a + b) * 1.0;
        double akertoma = kertoma(a) * 1.0;
        double bkertoma = kertoma(b) * 1.0;
        return summa / (akertoma * bkertoma);
    }
}
