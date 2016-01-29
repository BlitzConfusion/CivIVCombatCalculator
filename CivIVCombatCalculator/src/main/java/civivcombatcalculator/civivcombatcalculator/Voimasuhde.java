/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civivcombatcalculator.civivcombatcalculator;

/**
 *
 * @author Tatu
 */
public class Voimasuhde {
    private double hyokkayssuhde;
    private double puolustussuhde;
    
    public Voimasuhde(double attack, double defend) throws Exception {
        hyokkayssuhde = attack / (attack + defend);
        puolustussuhde = defend / (attack + defend);
    }
    
    public double attackReturn() {
        return hyokkayssuhde;
    }
    public double defendReturn() {
        return puolustussuhde;
    }
}
