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
public class VoimasuhdeTest {
    Random rand = new Random();
    
    public VoimasuhdeTest() {
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

    /**
     * Test of attackReturn method, of class Voimasuhde.
     */
    

    /**
     * Test of defendReturn method, of class Voimasuhde.
     * @throws java.lang.Exception
     */
    @Test
    public void testOne() throws Exception {	
      System.out.println("Test Equal situation");
      double  n = (double) rand.nextInt(50) + 1.0;
      Voimasuhde vs = new Voimasuhde(n, n, 0.2);
      assertTrue(vs.attackReturn() == 0.5);
   }
   @Test
    public void testLess() throws Exception {	
      System.out.println("Test Weak Defender");
      double  n = (double) rand.nextInt(50) + 1.0;
      Voimasuhde vs = new Voimasuhde(n, 1.0, 0.2);
      assertTrue(vs.attackReturn() >= 0.5);
   }
   @Test
    public void testLessD() throws Exception {	
      System.out.println("Test Weak Defender with Defender Ratio");
      double  n = (double) rand.nextInt(50) + 1.0;
      Voimasuhde vs = new Voimasuhde(n, 1.0, 0.2);
      assertTrue(vs.defendReturn() <= 0.5);
   }
    @Test
    public void testMoreD() throws Exception {	
      System.out.println("Test Strong Defender with DRatio");
      double  n = (double) rand.nextInt(50) + 1.0;
      Voimasuhde vs = new Voimasuhde(1.0, n, 0.2);
      assertTrue(vs.defendReturn() >= 0.5);
   }
    @Test
    public void testMore() throws Exception {	
      System.out.println("Test Strong Defender with DRatio");
      double  n = (double) rand.nextInt(50) + 1.0;
      Voimasuhde vs = new Voimasuhde(1.0, n, 0.2);
      assertTrue(vs.attackReturn() <= 0.5);
   }
    @Test
    public void testLessRatio() throws Exception {	
      System.out.println("Test Weak Defender Ratio");
      double  n = (double) rand.nextInt(50) + 1.0;
      double k = (double) rand.nextInt(10) + 1;
      double z = 1.0 / (k + 1); 
      Voimasuhde vs = new Voimasuhde(n, n * k, 0.2);
      assertTrue(vs.attackReturn() == z);
   }
    @Test
    public void testSum() throws Exception {	
      System.out.println("Test ratio sum");
      int  n = rand.nextInt(50) + 1;
      int  k = rand.nextInt(50) + 1;
      Voimasuhde vs = new Voimasuhde(n, k, 0.2);
      assertTrue(1 == vs.attackReturn() + vs.defendReturn());
   }
    @Test
    public void testAVictoryEqual() throws Exception {	
      System.out.println("Test Equal Attacker victory situation");
      int  n = rand.nextInt(50) + 1;
      Voimasuhde vs = new Voimasuhde(n, n, 0.2);
      assertTrue(vs.victoryAttackReturn() == 5);
   }
    @Test
    public void testBVictoryEqual() throws Exception {	
      System.out.println("Test Equal Defender victory situation");
      int  n = rand.nextInt(50) + 1;
      Voimasuhde vs = new Voimasuhde(n, n, 0.2);
      assertTrue(vs.victoryDefendReturn() == 5);
   }
}
