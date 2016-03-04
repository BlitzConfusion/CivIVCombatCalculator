/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civivcombatcalculator.civivcombatcalculator;

import java.util.ArrayList;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Tatu
 */
public class FSKombinatooriaTest {
    Random rand = new Random();
    
    public FSKombinatooriaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testZero() throws Exception {	
        System.out.println("Test Default situation");
        Voimasuhde suhde = new Voimasuhde(1, 1, 0.2);
        FSKombinatooria kombi = new FSKombinatooria(suhde, 1, 0);
        assertTrue(kombi.palautaFS() == 1);
    }
    @Test
    public void testTotal() throws Exception {	
        System.out.println("Test First Strike Total");
        Voimasuhde suhde = new Voimasuhde(1, 1, 0.2);
        int  n = rand.nextInt(5) + 2;
        FSKombinatooria kombi = new FSKombinatooria(suhde, n, 0);
        assertTrue(kombi.palautaFS() == n);
    }
    @Test
    public void testMahdollisuudet() throws Exception {	
        System.out.println("Test Mahdollisuudet-Array");
        Voimasuhde suhde = new Voimasuhde(1, 1, 0.2);
        int  n = rand.nextInt(5) + 1;
        FSKombinatooria kombi = new FSKombinatooria(suhde, 2, 0);
        ArrayList<Double> array = kombi.palautaMahdollisuudet();
        double total = 0;
        for (Double array1 : array) {
            total += array1;
        }
        assertTrue(total - 0.01 <= 1 && total + 0.01 >= 1);
    }
    
}
