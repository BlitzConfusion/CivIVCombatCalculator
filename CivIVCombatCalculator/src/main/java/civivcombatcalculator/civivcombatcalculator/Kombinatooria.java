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
public class Kombinatooria {
    
    public int kombinaatio(int n, int k) {
        return permutaatio(n) / (permutaatio(k) * permutaatio(n - k));
    }

    public int permutaatio(int i) {
        if (i == 1 || i == 0) {
            return 1;
        }
        return i * permutaatio(i - 1);
    }
}
