/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civivcombatcalculator.civivcombatcalculator;
/**
 * Luokka laskee taistelun osapuolien voimasuhteen ja tuhoon vaadittavat voitot.
 */
public class Voimasuhde {
    private final double hyokkayssuhde;
    private final double puolustussuhde;
    
    
    /**
     * Konstruktori tallentaa voimasuhteet osapuolten näkökulmista.
     * @param attack on hyökkääjän voiman arvo.
     * @param defend on puolustajan voiman arvo.
     */
    public Voimasuhde(double attack, double defend) {
        
        hyokkayssuhde = attack / (attack + defend);
        puolustussuhde = defend / (attack + defend);
    }
    /**
     * @return palauttaa hyökkääjän voimasuhteen.
     */
    public double attackReturn() {
        return hyokkayssuhde;
    }
    /**
     * @return palauttaa puolustajan voimasuhteen.
     */
    public double defendReturn() {
        return puolustussuhde;
    }
    
    /**
     * Metodi laskee kuinka monta voittoa puolustaja tarvitsee hyökkääjän 
     * tappamiseen. Myöhemmin tulee ottamaan huomion vahingon määrän, tällä
     * hetkellä toimii default Damage/Turn:llä.
     * @return puolustajan vaatimien voittojen määrä.
     */
    public int victoryDefendReturn() {
        double damage = puolustussuhde / hyokkayssuhde * 0.2;
        int rounds = (int) Math.ceil(1.0 / damage);
        return rounds;
    }
    /**
     * Metodi laskee kuinka monta voittoa hyökkääjä tarvitsee puolustajan 
     * tappamiseen. Myöhemmin tulee ottamaan huomion vahingon määrän, tällä
     * hetkellä toimii default Damage/Turn:llä.
     * @return hyökkääjän vaatimien voittojen määrä.
     */
    public int victoryAttackReturn() {
        double damage = hyokkayssuhde / puolustussuhde * 0.2;
        int rounds = (int) Math.ceil(1.0 / damage);
        return rounds;
    }
    
}
