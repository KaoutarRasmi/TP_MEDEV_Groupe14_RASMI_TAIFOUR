/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.medev.tpnote_groupe14;

import java.util.ArrayList;
import java.util.List;
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
public class JoueurTest {

    private Joueur joueur;

    @BeforeEach
    public void setUp() {
        // Initialisation d'un joueur pour les tests
        joueur = new Joueur("testo", 'N');
    }

    @AfterEach
    public void tearDown() {
        joueur = null;
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    /**
     * Test of getNom method, of class Joueur.
     */
    @Test
    public void testGetNom() {
        System.out.println("getNom");
        String expResult = "testo";
        String result = joueur.getNom();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNom method, of class Joueur.
     */
    @Test
    public void testSetNom() {
        System.out.println("setNom");
        String nom = "Bob";
        joueur.setNom(nom);
        assertEquals(nom, joueur.getNom());
    }

    /**
     * Test of getPions method, of class Joueur.
     */
    @Test
    public void testGetPions() {
        System.out.println("getPions");
        List<Pion> expResult = new ArrayList<>();
        List<Pion> result = joueur.getPions();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPions method, of class Joueur.
     */
    @Test
    public void testSetPions() {
        System.out.println("setPions");
        ArrayList<Pion> pions = new ArrayList<>();
        Pion pion = new Pion(new Position(1, 'a'), 'N');
        pions.add(pion);
        joueur.setPions(pions);
        assertEquals(pions, joueur.getPions());
    }

    /**
     * Test of ajouterPion method, of class Joueur.
     */
    @Test
    public void testAjouterPion() {
        System.out.println("ajouterPion");
        Pion pion = new Pion(new Position(1, 'a'), 'N');
        joueur.ajouterPion(pion);
        assertTrue(joueur.getPions().contains(pion));
    }

    /**
     * Test of jouerCoup method, of class Joueur.
     */
    @Test
    public void testJouerCoup() {
        System.out.println("jouerCoup");
        Plateau plateau = new Plateau(joueur, new Joueur("Bob", 'B'));
        Position position = new Position(4, 'c'); 
        joueur.jouerCoup(plateau, position);
        Pion pion = plateau.getPlateau()[position.getChifre() - 1][position.getLettre() - 'a'];
        assertNotNull(pion);
        assertEquals(pion.getCouleur(), joueur.getCouleur());
    }

    /**
     * Test of afficherPions method, of class Joueur.
     */
    @Test
    public void testAfficherPions() {
        System.out.println("afficherPions");
        Pion pion = new Pion(new Position(1, 'a'), 'N');
        joueur.ajouterPion(pion);
        joueur.afficherPions(); 
    }
}
