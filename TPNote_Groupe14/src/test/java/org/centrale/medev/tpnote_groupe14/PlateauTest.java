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
public class PlateauTest {

    private Plateau plateau;
    private Joueur joueur1;
    private Joueur joueur2;

    @BeforeEach
    public void setUp() {
        joueur1 = new Joueur("Alice", 'N');
        joueur2 = new Joueur("Bob", 'B');
        plateau = new Plateau(joueur1, joueur2);
    }

    @AfterEach
    public void tearDown() {
        plateau = null;
        joueur1 = null;
        joueur2 = null;
    }
     
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    /**
     * Test of getJoueur1 method, of class Plateau.
     */
    @Test
    public void testGetJoueur1() {
        System.out.println("getJoueur1");
        Joueur expResult = joueur1;
        Joueur result = plateau.getJoueur1();
        assertEquals(expResult, result);
    }

    /**
     * Test of setJoueur1 method, of class Plateau.
     */
    @Test
    public void testSetJoueur1() {
        System.out.println("setJoueur1");
        Joueur joueur1 = new Joueur("Charlie", 'B');
        plateau.setJoueur1(joueur1);
        assertEquals(joueur1, plateau.getJoueur1());
    }

    /**
     * Test of getJoueur2 method, of class Plateau.
     */
    @Test
    public void testGetJoueur2() {
        System.out.println("getJoueur2");
        Joueur expResult = joueur2;
        Joueur result = plateau.getJoueur2();
        assertEquals(expResult, result);
    }

    /**
     * Test of setJoueur2 method, of class Plateau.
     */
    @Test
    public void testSetJoueur2() {
        System.out.println("setJoueur2");
        Joueur joueur2 = new Joueur("David", 'N');
        plateau.setJoueur2(joueur2);
        assertEquals(joueur2, plateau.getJoueur2());
    }

    /**
     * Test of getPlateau method, of class Plateau.
     */
    @Test
    public void testGetPlateau() {
        System.out.println("getPlateau");
        Pion[][] expResult = new Pion[8][8];
        Pion[][] result = plateau.getPlateau();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of setPlateau method, of class Plateau.
     */
    @Test
    public void testSetPlateau() {
        System.out.println("setPlateau");
        Pion[][] plateauTest = new Pion[8][8];
        plateau.setPlateau(plateauTest);
        assertArrayEquals(plateauTest, plateau.getPlateau());
    }

    /**
     * Test of capture method, of class Plateau.
     */
    @Test
    public void testCapture() {
        System.out.println("capture");
        Position position = new Position(4, 'd');
        char couleur = 'N'; // Couleur du pion qui joue
        boolean expResult = false; 
        boolean result = plateau.capture(position, couleur);
        assertEquals(expResult, result);
    }

    /**
     * Test of afficherPlateau method, of class Plateau.
     */
    @Test
    public void testAfficherPlateau() {
        System.out.println("afficherPlateau");
        plateau.afficherPlateau();
    }
}
