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
public class LaskijaTest {
    Random rand = new Random();
    
    public LaskijaTest() {
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

    
    //@Test
    //public void testZero() throws Exception {	
    //System.out.println("Test Basic situation");
    //int n = rand.nextInt(50) + 1;
    //Laskija laskija = new Laskija(n, n, 0, 0, 0, 0);
    //assertTrue(laskija.laskeHyokkaysTod() == 0.5);
    //}

    /**
     * Test of laskeHyokkaysTod method, of class Laskija.
     */
    @Test
    public void testLaskeHyokkaysTod() {
        System.out.println("laskeHyokkaysTod");
        Laskija instance = null;
        instance.laskeHyokkaysTod();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of laskeRajoitettu method, of class Laskija.
     */
    @Test
    public void testLaskeRajoitettu() {
        System.out.println("laskeRajoitettu");
        Laskija instance = null;
        instance.laskeRajoitettu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnWithdraw method, of class Laskija.
     */
    @Test
    public void testReturnWithdraw() {
        System.out.println("returnWithdraw");
        Laskija instance = null;
        double expResult = 0.0;
        double result = instance.returnWithdraw();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnOdds method, of class Laskija.
     */
    @Test
    public void testReturnOdds() {
        System.out.println("returnOdds");
        Laskija instance = null;
        double expResult = 0.0;
        double result = instance.returnOdds();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
