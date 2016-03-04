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

    
    @Test
    public void testZero() throws Exception {	
    System.out.println("Test Basic situation");
    int n = rand.nextInt(50) + 1;
    Laskija laskija = new Laskija(n, n, 0, 0, 0, 0, 0, 20, 0);
    double voittoTod = (double) laskija.returnOdds();
    assertTrue(voittoTod == 50);
    }

    @Test
    public void testFasterAttacker() throws Exception {	
    System.out.println("Test Attacker with more First Strikes");
    int n = rand.nextInt(50) + 1;
    int k = rand.nextInt(4) + 1;
    Laskija laskija = new Laskija(n, n, 0, 0, k, 0, 0, 20, 0);
    double voittoTod = (double) laskija.returnOdds();
    assertTrue(voittoTod >= 56 && voittoTod <= 90);
    }
    @Test
    public void testStrongerAttacker() throws Exception {	
    System.out.println("Test Stronger Attacker");
    Laskija laskija = new Laskija(400, 399, 0, 0, 0, 0, 0, 20, 0);
    double voittoTod = (double) laskija.returnOdds();
    assertTrue(voittoTod >= 62.4 && voittoTod <= 62.5);
    }
    @Test
    public void testMirror() throws Exception {	
    System.out.println("See that totals equal all possibilities");
    int n = rand.nextInt(50) + 1;
    Laskija laskija = new Laskija(n + 1, n, 0, 0, 0, 0, 0, 20, 0);
    Laskija mirror = new Laskija(n, n + 1, 0, 0, 0, 0, 0, 20, 0);
    double voittoTod = (double) laskija.returnOdds() + mirror.returnOdds();
    assertTrue(voittoTod >= 99.99 && voittoTod <= 100.01);
    }
    @Test
    public void testFSMirror() throws Exception {	
    System.out.println("Test that totals equal all possibilities with FS");
    int n = rand.nextInt(50) + 1;
    int k = rand.nextInt(4) + 1;
    Laskija laskija = new Laskija(n + 1, n, 0, 0, 0, k, 0, 20, 0);
    Laskija mirror = new Laskija(n, n + 1, 0, 0, k, 0, 0, 20, 0);
    double voittoTod = (double) laskija.returnOdds() + mirror.returnOdds();
    assertTrue(voittoTod >= 99.99 && voittoTod <= 100.01);
    }
    @Test
    public void testRelativeEffect() throws Exception {	
    System.out.println("Test that First Strike not as strong as Strength");
    Laskija laskija = new Laskija(400, 399, 0, 0, 0, 1, 0, 20, 0);
    double voittoTod = (double) laskija.returnOdds();
    assertTrue(voittoTod >= 56.31 && voittoTod <= 56.32);
    }
    @Test
    public void testLimitedRemovesFS() throws Exception {	
    System.out.println("Test that limited rounds remove First Strikes");
    int n = rand.nextInt(50) + 1;
    int k = rand.nextInt(4) + 1;
    Laskija laskija = new Laskija(n, n, 0, 0, 0, k, 15, 20, 0);
    double voittoTod = (double) laskija.returnOdds();
    assertTrue(voittoTod == 50);
    }
    @Test
    public void testLimitedRemovesWithdraw() throws Exception {	
    System.out.println("Test that limited rounds remove normal Withdraw chance");
    int n = rand.nextInt(50) + 1;
    int k = (rand.nextInt(4) + 1) * 5;
    Laskija laskija = new Laskija(n, n, 0, 0, 0, 0, 15, 20, k);
    double withdraw = (double) laskija.returnWithdraw();
    assertTrue(withdraw == 0);
    }
    @Test
    public void testLimitedIncludesWithdraw() throws Exception {	
    System.out.println("Test that limited rounds allow tie withdrawal");
    int n = rand.nextInt(50) + 1;
    Laskija laskija = new Laskija(n, n, 0, 0, 0, 0, 6, 20, 0);
    double withdraw = (double) laskija.returnWithdraw();
    assertTrue(withdraw > 0);
    }
    @Test
    public void testLimitedDamageAndEqual() throws Exception {	
    System.out.println("Test that increased damage does not alter equals");
    int n = rand.nextInt(50) + 1;
    int k = (rand.nextInt(4) + 1) * 5;
    Laskija laskija = new Laskija(n, n, 0, 0, 0, 0, 15, 20, k);
    Laskija laskuja = new Laskija(n, n, 0, 0, 0, 0, 15, 60, k);
    double withdraw = (double) laskija.returnWithdraw();
    double withdrawal = (double) laskuja.returnWithdraw();
    double voittoTod = (double) laskija.returnOdds();
    double voittoT = (double) laskuja.returnOdds();
    assertTrue(withdraw == withdrawal && voittoTod == voittoT);
    }
    @Test
    public void testBonusVSBruteStength() throws Exception {	
    System.out.println("Test that a bonus equals raw strength");
    int n = rand.nextInt(50) + 1;
    Laskija laskija = new Laskija(n * 2, n, 50, 150, 0, 0, 0, 20, 0);
    double voittoTod = (double) laskija.returnOdds();
    assertTrue(voittoTod == 50);
    }
}
