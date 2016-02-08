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
    
    public int kombinaatio(int n, int k) {
        int result = 1;
        if (n == k || n == 0 || n == 1 || k == 0 || k == 1) {
            return result;
        }
        if (k < n - k) {
            result *= permutaatio(n, n - k);
            result /= permutaatio(k, 2);
                
        } else {
            result *= permutaatio(n, k);
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
