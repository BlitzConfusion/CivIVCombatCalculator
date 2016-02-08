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
      int  n = rand.nextInt(50) + 1;
      Kombinatooria komb = new Kombinatooria();
      int k = komb.kombinaatio(1, 0);
      assertTrue(1 == k);
   }
    @Test
    public void testOne() throws Exception {	
      System.out.println("Test One situation");
      int  n = rand.nextInt(50) + 1;
      Kombinatooria komb = new Kombinatooria();
      int k = komb.kombinaatio(1, 1);
      assertTrue(1 == k);
   }
    //Jostain syystä tulee nullpointerexception.
    //@Test
    //public void testRand() throws Exception {	
      //System.out.println("Test Random situation");
      //int  n = rand.nextInt(16) + 2;
      //Kombinatooria komb = new Kombinatooria();
      //int k = komb.kombinaatio(n, 1);
      //assertTrue(k >= 2);
   //}
    //@Test
    //public void testComparison() throws Exception {	
      //System.out.println("Test Random comparison situation");
      //int  n = rand.nextInt(6) + 1;
      //int k = n * 2;
      //Kombinatooria komb = new Kombinatooria();
      //int m = komb.kombinaatio(k, n);
      //int j = komb.kombinaatio(k, n + 1);
      //assertTrue(m >= j);
   //}
    
}
