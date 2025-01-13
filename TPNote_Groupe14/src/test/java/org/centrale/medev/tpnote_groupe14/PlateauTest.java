/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.medev.tpnote_groupe14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitaires pour la classe Plateau
 */
public class PlateauTest {
    
    private Plateau plateau;
    private Joueur joueur1;
    private Joueur joueur2;
    
    @BeforeEach
    public void setUp() {
        joueur1 = new Joueur("Joueur1", 'N');
        joueur2 = new Joueur("Joueur2", 'B');
        plateau = new Plateau(joueur1, joueur2);
    }
    
    /**
     * Test du constructeur et de l'initialisation du plateau
     */
    @Test
    public void testConstructeurEtInitialisation() {
        // Vérification des joueurs
        assertEquals(joueur1, plateau.getJoueur1());
        assertEquals(joueur2, plateau.getJoueur2());
        
        // Vérification de la taille du plateau
        assertEquals(8, plateau.getPlateau().length);
        assertEquals(8, plateau.getPlateau()[0].length);
        
        // Vérification des positions initiales
        // Position 4d (B)
        assertNotNull(plateau.getPlateau()[3][3]);
        assertEquals('B', plateau.getPlateau()[3][3].getCouleur());
        
        // Position 5e (B)
        assertNotNull(plateau.getPlateau()[4][4]);
        assertEquals('B', plateau.getPlateau()[4][4].getCouleur());
        
        // Position 4e (N)
        assertNotNull(plateau.getPlateau()[3][4]);
        assertEquals('N', plateau.getPlateau()[3][4].getCouleur());
        
        // Position 5d (N)
        assertNotNull(plateau.getPlateau()[4][3]);
        assertEquals('N', plateau.getPlateau()[4][3].getCouleur());
    }
    
    
    
    /**
     * Test de capture valide
     */
    @Test
    public void testCaptureValide() {
        // Test d'une capture valide pour le joueur noir
        Position positionCapture = new Position(4, 'c'); // Position permettant une capture
        assertTrue(plateau.capture(positionCapture, 'N'));
        
        // Vérification que les pions ont été capturés
        assertEquals('N', plateau.getPlateau()[3][3].getCouleur()); // Le pion blanc en 4d devrait être capturé
    }
    
    /**
     * Test de capture invalide
     */
    @Test
    public void testCaptureInvalide() {
        // Test d'une capture invalide (position éloignée)
        Position positionInvalide = new Position(1, 'a');
        assertFalse(plateau.capture(positionInvalide, 'N'));
    }
    
    
    /**
     * Test de l'affichage du plateau
     * Note: Ce test vérifie simplement que la méthode ne lève pas d'exception
     */
    @Test
    public void testAfficherPlateau() {
        assertDoesNotThrow(() -> plateau.afficherPlateau());
    }
}
