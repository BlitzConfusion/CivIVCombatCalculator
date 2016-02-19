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
    int suuri;
    int pieni;
    
    
    /**
     * Luokalla ei attribuutteja, joten konstruktori ei varsinaisesti tärkeä.
     * @param suurempi on tapausten kokonaismäärä, joka settaa ylärajan kombinaatioille.
     * @param pienempi on P, ja n-k on!P. Antaa tiedon kuinka monta kertaa k tapahtuu.
     */
    public Kombinatooria(int suurempi, int pienempi) {
        suuri = suurempi;
        pieni = pienempi;
    }
    
    /**
     * Metodi laskee tapauksien P ja !P kombinaatioiden lukumäärän joukossa n.
     */
    public int kombinaatio() {
        int n = suuri;
        int k = pieni;
        double result = (double) 1;
        int h = n - k;
        if (n < 1 || k < 1 || n == k || k > n) {
            return (int) Math.round(result);
        }
        if (n - k == 1) {
            return n;
        }
        if (k > h) {
            for (int i = 1; i <= h; i++) {
                result *= (double) (n - h + i);
                result /= (double) i;
            }
        } else {
            for (int i = 1; i <= k; i++) {
                result *= (double) (n - k + i);
                result /= (double) i;
            }
        }
        return (int) Math.round(result);
    }
    
    
}
