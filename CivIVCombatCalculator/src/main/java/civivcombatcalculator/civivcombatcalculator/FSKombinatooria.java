/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civivcombatcalculator.civivcombatcalculator;
import java.util.*;
/**
 * Luokka laskee eri mahdolliset First Strike:n vaikutukset.
 * ArrayList antaa järjestyksessä todennäköisyydet.
 */
public class FSKombinatooria {
    private final Voimasuhde voimasuhde;
    private final int kokoFS;
    private final ArrayList<Double> mahdollisuudet = new ArrayList();
    
    /**
     * Konstruktori kutsuu jo mahdollisuustäyttäjää ArrayListejä varten.
     * @param suhde on saatu Voimasuhde.
     * @param aFS on hyökkääjän First Strike-määrä.
     * @param dFS on puolustajan First Strike-määrä.
     * Ne vähennetään toisistaan.
     */
    public FSKombinatooria(Voimasuhde suhde, int aFS, int dFS) {
        voimasuhde = suhde;
        kokoFS = aFS - dFS;
        mahdollisuusTayttaja();
    }
    
    /**
     * Metodi kutsuu vuorollaan kombinaatioista vastaavaa metodia.
     */
    private void mahdollisuusTayttaja() {
        for (int i = Math.min(kokoFS, 0); i <= Math.max(kokoFS, 0); i++) {
            voimaKombinaatio(i);
        }
    }
    /**
     * Varsinainen Kombinatooriaa hyödyntävä todennäköisyyksien laskija.
     * @param kukaFS on vuorossa olevien FS-voittojen määrä.
     */
    private void voimaKombinaatio(int kukaFS) {
        double chance = 1.0;
        if (kukaFS == 0 && kokoFS > 0) {
            chance *= Math.pow(voimasuhde.defendReturn(), kokoFS);
        }
        if (kukaFS < 0) {
            Kombinatooria kombi = new Kombinatooria(0 - kokoFS, 0 - kukaFS);
            chance *= kombi.kombinaatio();
            chance *= Math.pow(voimasuhde.defendReturn(), 0 - kukaFS);
            chance *= Math.pow(voimasuhde.attackReturn(), kukaFS - kokoFS);
        }
        if (kukaFS > 0) {
            Kombinatooria kombi = new Kombinatooria(kokoFS, kukaFS);
            chance *= kombi.kombinaatio();
            chance *= Math.pow(voimasuhde.attackReturn(), kukaFS);
            chance *= Math.pow(voimasuhde.defendReturn(), kokoFS - kukaFS);
        }
        if (kukaFS == 0 && kokoFS < 0) {
            chance *= Math.pow(voimasuhde.attackReturn(), 0 - kokoFS);
        }
        mahdollisuudet.add(chance);
    }
    /**
     * Palauttaa ArrayListin todennäköisyyksistä.
     * @return mahdollisuudet, eli todennäköisyydet.
     */
    public ArrayList palautaMahdollisuudet() {
        return mahdollisuudet;
    }
    
    /**
     * Palauttaa tiedon First Strike-kokonauhtesta.
     * @return integerinä kenellä First Strikeä.
     */
    public int palautaFS() {
        return kokoFS;
    }
}
