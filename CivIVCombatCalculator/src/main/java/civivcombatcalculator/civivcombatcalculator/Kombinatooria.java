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
    
    public Kombinatooria() {
    }
    //Jostain syystä kutsuttaessa tietyistä luokista tulee nullpointerException.
    public int kombinaatio(int n, int k) {
        int result = 1;
        if (n <= 1 || k <= 1 || n <= k || n - k <= 1) {
            return result;
        }
        if (n >= 19 && Math.min(k, n - k) >= 6) {
            return -1;
        }
        if (k < n - k) {
            result *= permutaatio(n, n - k + 1);
            result /= permutaatio(k, 2);
                
        } else {
            result *= permutaatio(n, k + 1);
            result /= permutaatio(n - k, 2);
        
        }
        return result;
    }
    private int permutaatio( int n, int k) {
        int sum = 1;
        for(int i = k; i <= n; i++) {
                sum *= i;
            }
        return sum;
    }
}
