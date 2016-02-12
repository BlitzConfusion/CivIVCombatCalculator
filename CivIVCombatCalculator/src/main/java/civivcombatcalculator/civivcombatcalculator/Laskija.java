
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
 *Keskeisin luokka varsinaisen taistelun todennäköisyyksien kannalta.
 * Kysyy muilta luokilta laskutoimituksia, ja soveltaa tulokset.
 * Tulee myöhemmin laskemaan keskimäärin voittajalle jääneen elämän.
 */
public class Laskija {
    private Voimasuhde voimasuhde;
    private FSKombinatooria fsKombinatooria;
    private Kombinatooria kombi;
    
    /**
     * Konstruktori tallentaa taistelun oleelliset tiedot.
     * @param attack on hyökkääjän voima.
     * @param defend on puolustajan voima.
     * @param abonus on hyökkääjän %-bonus taisteluun.
     * @param dbonus on puolustajan %-bonus taisteluun.
     * @param attackFS on hyökkääjan First Strike:n määrä.
     * @param defendFS on puolustajan First Strike:n määrä.
     */
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
            fsKombinatooria = new FSKombinatooria(voimasuhde, attackFS, defendFS);
        } catch (Exception ex) {
            System.out.println("Invalid values");
        }
    }
    
    /**
     * Laskee ja kertoo hyökkääjän voiton todennäköisyyden.
     * @return on hyökkääjän voiton todennäköisyys.
     */
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
                subChance = (double) kombi.kombinaatio(aLength + i, dLength);
                if (subChance == -1) {
                    return -1;
                }
                subChance *= Math.pow(defend, (double) dLength);
                subChance *= Math.pow(attack, (double) i);
                chance += subChance;
            }
            return (1.0 - chance);
        } else {
            for(int j = 0; j < aLength; j++) {
                subChance = (double) kombi.kombinaatio(dLength + j, aLength);
                if (subChance == -1) {
                    return -1;
                }
                subChance *= pow(attack, (double) aLength);
                subChance *= pow(defend, (double) j);
                chance += subChance;
            }
        }
        
        return chance;
        
    
    }
}
