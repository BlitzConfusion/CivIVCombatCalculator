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
public class FSKombinatooria {
    private final Voimasuhde voimasuhde;
    private final int kokoFS;
    private ArrayList mahdollisuudet = new ArrayList();
    private Kombinatooria kombinatooria;
    
    public FSKombinatooria(Voimasuhde suhde, int aFS, int dFS){
        voimasuhde = suhde;
        kokoFS = aFS - dFS;
        mahdollisuusTayttaja();
    }
    private void mahdollisuusTayttaja() {
        if (0 < kokoFS) {
            voimaKombinaatio(kokoFS, voimasuhde.attackReturn(), voimasuhde.defendReturn());
        }
        if (0 >= kokoFS) {
            voimaKombinaatio(0 - kokoFS, voimasuhde.defendReturn(), voimasuhde.attackReturn());
        }
    }
    private void voimaKombinaatio(int newFS, double up, double down) {
        double voimaMahd;
        for(int i = 0; i <= newFS; i++) {
                voimaMahd = Math.pow(up, i);
                voimaMahd *= Math.pow(down, newFS - i);
                voimaMahd *= kombinatooria.kombinaatio(newFS, i);
                mahdollisuudet.add(voimaMahd);
            }
    
    }
    public ArrayList palautaMahdollisuudet() {
        return mahdollisuudet;
    }
}
