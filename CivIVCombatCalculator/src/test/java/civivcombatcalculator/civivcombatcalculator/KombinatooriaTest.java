/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civivcombatcalculator.civivcombatcalculator;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tatu
 */
public class KombinatooriaTest {
    Random rand = new Random();
    
    public KombinatooriaTest() {
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
        System.out.println("Test Zero situation");
        Kombinatooria komb = new Kombinatooria(1, 0);
        int k = komb.kombinaatio();
        assertTrue(1 == k);
    }
    @Test
    public void testOne() throws Exception {	
        System.out.println("Test One situation");
        Kombinatooria komb = new Kombinatooria(1, 1);
        int k = komb.kombinaatio();
        assertTrue(1 == k);
    }
    @Test
    public void testRand() throws Exception {	
        System.out.println("Test Random situation");
        int  n = rand.nextInt(10) + 2;
        Kombinatooria komb = new Kombinatooria(n, 1);
        int k = komb.kombinaatio();
        assertTrue(k >= 2);
    }
    @Test
    public void testComparison() throws Exception {	
        System.out.println("Test Random comparison situation");
        int  n = rand.nextInt(6) + 1;
        int k = n * 2;
        Kombinatooria komb = new Kombinatooria(k, n);
        Kombinatooria kombo = new Kombinatooria(k, n + 1);
        int m = komb.kombinaatio();
        int j = kombo.kombinaatio();
        assertTrue(m >= j);
    }
    @Test
    public void testBigger() throws Exception {	
        System.out.println("Test if K bigger situation");
        int  n = rand.nextInt(10) + 2;
        Kombinatooria komb = new Kombinatooria(n, n + 1);
        int k = komb.kombinaatio();
        assertTrue(k == 1);
    }
    @Test
    public void testNegative() throws Exception {	
        System.out.println("Test negative input.");
        int  n = -1;
        Kombinatooria komb = new Kombinatooria(n, n);
        int k = komb.kombinaatio();
        assertTrue(k == 1);
    }
    
}
