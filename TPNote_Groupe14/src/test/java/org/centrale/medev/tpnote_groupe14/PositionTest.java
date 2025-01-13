/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.medev.tpnote_groupe14;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kaoutar, mouad
 */
public class PositionTest {
    
    public PositionTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getChifre method, of class Position.
     */
    @Test
    public void testGetChifre() {
        System.out.println("getChifre");
        Position instance = null;
        int expResult = 0;
        int result = instance.getChifre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setChifre method, of class Position.
     */
    @Test
    public void testSetChifre() {
        System.out.println("setChifre");
        int chifre = 0;
        Position instance = null;
        instance.setChifre(chifre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLettre method, of class Position.
     */
    @Test
    public void testGetLettre() {
        System.out.println("getLettre");
        Position instance = null;
        char expResult = ' ';
        char result = instance.getLettre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLettre method, of class Position.
     */
    @Test
    public void testSetLettre() {
        System.out.println("setLettre");
        char lettre = ' ';
        Position instance = null;
        instance.setLettre(lettre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
