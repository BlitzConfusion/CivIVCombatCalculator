
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civivcombatcalculator.civivcombatcalculator;

/**
 *Keskeisin luokka varsinaisen taistelun todennäköisyyksien kannalta.
 * Kysyy muilta luokilta laskutoimituksia, ja soveltaa tulokset.
 * Tulee myöhemmin laskemaan keskimäärin voittajalle jääneen elämän.
 */
public final class Laskija {
    private Voimasuhde voimasuhde;
    private FSKombinatooria fsKombinatooria;
    private int withdrawal;
    private int damagePerTurn;
    private int rounds;
    private double propability;
    
    /**
     * Konstruktori tallentaa taistelun oleelliset tiedot.
     * @param attack on hyökkääjän voima.
     * @param defend on puolustajan voima.
     * @param abonus on hyökkääjän %-bonus taisteluun.
     * @param dbonus on puolustajan %-bonus taisteluun.
     * @param attackFS on hyökkääjan First Strike:n määrä.
     * @param defendFS on puolustajan First Strike:n määrä.
     */
    public Laskija(int attack, int defend, int abonus, int dbonus,
            int attackFS, int defendFS, int time, int damage, int withdraw) {
        int bonus;
        withdrawal = withdraw;
        damagePerTurn = damage;
        rounds = time;
        double a = (double) attack;
        double d = (double) defend;
        if (abonus < dbonus) {
            bonus = dbonus - abonus;
            d *= (double) (bonus + 100) / (double) 100;
        } else {
            bonus = abonus - dbonus;
            a *= (double)(bonus + 100) / (double)100;
        }
        voimasuhde = new Voimasuhde(a, d, 0.01 * damage);
        fsKombinatooria = new FSKombinatooria(voimasuhde, attackFS, defendFS);
        if (rounds == 0) {
            laskeHyokkaysTod();
        } else {
            laskeRajoitettu();
        }
        
    }
    
    /**
     * Laskee ja kertoo hyökkääjän voiton todennäköisyyden.
     */
    //Tämä on alustava esimerkki ennen First Striken lisäystä.
    public void laskeHyokkaysTod(){
        double chance = 0;
        double attack = voimasuhde.attackReturn();
        double defend = voimasuhde.defendReturn();
        int aLength = voimasuhde.victoryAttackReturn();
        int dLength = voimasuhde.victoryDefendReturn();
        if (aLength < dLength) {
            for (int i = 0; i < aLength; i++) {
                Kombinatooria kombi = new Kombinatooria(dLength + i - 1, dLength - 1);
                Double subChance = (double) kombi.kombinaatio();
                subChance *= Math.pow(attack, i);
                subChance *= Math.pow(defend, dLength);
                chance += subChance;
            }
            propability = (double) 1 - chance;
        } else {
            for (int i = 0; i < dLength; i++) {
                Kombinatooria kombi = new Kombinatooria(aLength + i - 1, aLength - 1);
                Double subChance = (double) kombi.kombinaatio();
                subChance *= Math.pow(defend, i);
                subChance *= Math.pow(attack, aLength);
                chance += subChance;
            }
            propability = chance;
        }
        
    }
    
    /**
     * Tulee olemaan rajoitettujen taistelukierrosten todennäköisyyslaskija.
     */
    public void laskeRajoitettu() {
        if (rounds * damagePerTurn * voimasuhde.attackReturn() 
                < voimasuhde.victoryAttackReturn()) {
            propability = 0;
        }
    }
    
    /**
     * Palauttaa lopullisen Withdraw:n todennäköisyyden.
     */
    public double returnWithdraw() {
        return ((double) 1) - propability * withdrawal;
    
    }
    /**
     * Palauttaa lopullisen hyökkääjän voittotodennäköisyyden.
     */
    public double returnOdds() {
        if (rounds == 0) {
            return propability * (double) 100;
        }
        return ((double) 1) - propability; 
    }
    
}
