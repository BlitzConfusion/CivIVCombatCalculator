/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civivcombatcalculator.civivcombatcalculator;
import static java.lang.Math.ceil;
/**
 *
 * @author Tatu
 */
public class Voimasuhde {
    private final double hyokkayssuhde;
    private final double puolustussuhde;
    
    
    
    public Voimasuhde(double attack, double defend) {
        
        hyokkayssuhde = attack / (attack + defend);
        puolustussuhde = defend / (attack + defend);
    }
    
    public double attackReturn() {
        return hyokkayssuhde;
    }
    public double defendReturn() {
        return puolustussuhde;
    }
    public int victoryDefendReturn() {
        double damage = puolustussuhde / hyokkayssuhde * 0.2;
        int rounds = (int) Math.ceil(1.0 / damage);
        return rounds;
    }
    public int victoryAttackReturn() {
        double damage = hyokkayssuhde / puolustussuhde * 0.2;
        int rounds = (int) Math.ceil(1.0 / damage);
        return rounds;
    }
    
}
