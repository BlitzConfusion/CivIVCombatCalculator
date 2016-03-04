
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
     * @param time on taistelun maksimikesto. 0 on rajaton.
     * @param damage on voittajan aiheuttaman vahingon määrä.
     * @param withdraw on hyökkääjän pakomahdollisuus häviössä.
     */
    public Laskija(int attack, int defend, int abonus, int dbonus,
            int attackFS, int defendFS, int time, int damage, int withdraw) {
        double bonus;
        withdrawal = withdraw;
        damagePerTurn = damage;
        rounds = time;
        double a = 1.0 * attack;
        double d = 1.0 * defend;
        if (abonus < dbonus) {
            bonus = 1.0 * (dbonus - abonus);
            d *= (1.0 * bonus + 100.0) / 100.0;
        } else {
            bonus = 1.0 * (abonus - dbonus);
            a *= (1.0 * bonus + 100.0) / 100.0;
        }
        voimasuhde = new Voimasuhde(a, d, 0.01 * damage);
        fsKombinatooria = new FSKombinatooria(voimasuhde, attackFS, defendFS);
        if (rounds == 0) {
            if (fsKombinatooria.palautaFS() == 0) {
                laskeHyokkaysTod();
            } else {
                laskeFSTod();
            }
        } else {
            laskeRajoitettu();
        }
        
    }
    
    /**
     * Laskee ja kertoo hyökkääjän voiton todennäköisyyden.
     */
    //Tämä on alustava esimerkki ennen First Striken lisäystä.
    public void laskeHyokkaysTod() {
        int aLength = voimasuhde.victoryAttackReturn();
        int dLength = voimasuhde.victoryDefendReturn();
        propability = laskija(aLength, dLength);
                
    }
    /**
     * First Strike-versio todennäköisyydenlaskijasta.
     */
    public void laskeFSTod() {
        double chance = 0;
        int aLength = voimasuhde.victoryAttackReturn();
        int dLength = voimasuhde.victoryDefendReturn();
        if (fsKombinatooria.palautaFS() < 0) {
            for (int i = 0; i <= 0 - fsKombinatooria.palautaFS(); i++) {
                double subchance = 
                        (double) fsKombinatooria.palautaMahdollisuudet().get(i);
                if (dLength + fsKombinatooria.palautaFS() + i >= 1) {
                    subchance *= laskija(aLength, dLength + fsKombinatooria.palautaFS() + i);
                }
                chance += subchance;
            }
        } else {
            for (int i = 0; i <= fsKombinatooria.palautaFS(); i++) {
                double subchance = 
                        (double) fsKombinatooria.palautaMahdollisuudet().get(i);
                if (aLength - i >= 1) {
                    subchance *= laskija(aLength - i, dLength);
                }
                chance += subchance;
            }
        }
        propability = chance;
    }
    /**
     * Tulee olemaan rajoitettujen taistelukierrosten todennäköisyyslaskija.
     */
    public void laskeRajoitettu() {
        withdrawal = 100;
        double chance = 0;
        double attack = voimasuhde.attackReturn();
        double defend = voimasuhde.defendReturn();
        int aLength = voimasuhde.victoryAttackReturn();
        int dLength = voimasuhde.victoryDefendReturn();
        if (aLength > rounds) {
            propability = 0;
        } else {
            for (int i = aLength; i <= Math.min(rounds, aLength + dLength - 1); i++) {
                Kombinatooria kombi = new Kombinatooria(i - 1, aLength - 1);
                Double subChance = (double) kombi.kombinaatio();
                subChance *= Math.pow(defend, i - aLength);
                subChance *= Math.pow(attack, aLength);
                chance += subChance;
            }
            propability = chance;
            withdrawal = (int) Math.round(10000.0 - 10000.0 * propability);
        }
        if (dLength <= rounds) {
            double havio = 0.0;
            for (int i = dLength; i <= Math.min(rounds, aLength + dLength - 1); i++) {
                Kombinatooria kombi = new Kombinatooria(i - 1, dLength - 1);
                Double subChance = (double) kombi.kombinaatio();
                subChance *= Math.pow(attack, i - dLength);
                subChance *= Math.pow(defend, dLength);
                havio += subChance;
            }
            withdrawal = (int) Math.round(10000.0 - 10000.0 * propability - 10000.0 * havio);
        }
    }
    
    /**
     * Palauttaa lopullisen Withdraw:n todennäköisyyden.
     * @return Palauttaa lopullisen Withdraw-todennäköisyyden.
     */
    public double returnWithdraw() {
        if (rounds == 0) {
            double val = (double) 100 * (1.0 - propability) * withdrawal;
            val = Math.round(val);
            val = val / 100;
            return val;
        }
        double withdraw = (double) withdrawal / 100.0;
        return withdraw;
    }
    /**
     * Palauttaa lopullisen hyökkääjän voittotodennäköisyyden.
     * @return voittotodennäköisyys.
     */
    public double returnOdds() {
        double val = propability * 10000;
        val = Math.round(val);
        val = val / 100;
        return val;
    }
    /**
     * Toimii välilaskijana kombinaatioille normaalin ja FS-laskijan apuna.
     * @param lukua on hyökkääjän osalta voitot
     * @param lukud on puolustajan osalta voitot.
     * @return todennäköisyys tälle tapaukselle.
     */
    private double laskija(int lukua, int lukud) {
        
        if (lukud > 10) {
            lukud = 10;
        }
        double chance = 0;
        double actual = 0;
        double attack = voimasuhde.attackReturn();
        double defend = voimasuhde.defendReturn();
        if (lukua < lukud) {
            for (int i = 0; i < lukua; i++) {
                Kombinatooria kombi = new Kombinatooria(lukud + i - 1, lukud - 1);
                Double subChance = (double) kombi.kombinaatio();
                subChance *= Math.pow(attack, i);
                subChance *= Math.pow(defend, lukud);
                chance += subChance;
            }
            actual = (double) 1 - chance;
        } else {
            for (int i = 0; i < lukud; i++) {
                Kombinatooria kombi = new Kombinatooria(lukua + i - 1, lukua - 1);
                Double subChance = (double) kombi.kombinaatio();
                subChance *= Math.pow(defend, i);
                subChance *= Math.pow(attack, lukua);
                chance += subChance;
            }
            actual = chance;
        }
        return actual;
    }
    
    
}
