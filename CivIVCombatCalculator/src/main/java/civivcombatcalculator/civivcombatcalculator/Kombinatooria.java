/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civivcombatcalculator.civivcombatcalculator;

/**
 * Luokka laskee annettujen tapausmäärien perusteella mahdollisten kombinaatioiden
 * määrän, ja palauttaa lopputuloksena sen.
 */
public class Kombinatooria {
    
    
    /**
     * Luokalla ei attribuutteja, joten konstruktori ei varsinaisesti tärkeä.
     */
    public Kombinatooria() {
    }
    
    /**
     * Metodi laskee tapauksien P ja !P kombinaatioiden lukumäärän.
     * @param n on tapausten kokonaismäärä, joka settaa ylärajan kombinaatioille.
     * @param k on P, ja n-k on!P. Antaa tiedon kuinka monta kertaa k tapahtuu.
     * @return P ja !P mahdollisten kombinaatioiden määrän joukossa n.
     */
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
    
    /**
     * Laskee kertolaskun tuloksen luvusta toiseen kaikki väliluvut läpikäyden.
     * Kertoman toimintoa jäljittelevä metodi.
     * @param n on viimeinen kerrottava luku.
     * @param k on ensimmäinen kerrottava luku.
     * @return typistetyn kertoman tulos.
     */
    private int permutaatio( int n, int k) {
        int sum = 1;
        for(int i = k; i <= n; i++) {
                sum *= i;
            }
        return sum;
    }
}
