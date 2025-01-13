/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.medev.tpnote_groupe14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitaires pour la classe Othello
 *
 * @author kaoutar, mouad
 */
public class OthelloTest {
    
    private Othello jeu;
    
    @BeforeEach
    public void setUp() {
        // Initialisation d'une nouvelle partie avant chaque test
        jeu = new Othello("Joueur1", "Joueur2");
    }
    
    /**
     * Test du constructeur
     * Vérifie que les joueurs et le plateau sont correctement initialisés
     */
    @Test
    public void testConstructeur() {
        // Création d'un nouveau jeu pour le test
        Othello othello = new Othello("Alice", "Bob");
        
        // Vérification des joueurs
        assertNotNull(othello, "L'instance Othello ne devrait pas être null");
        assertEquals("Alice", othello.getJoueur1().getNom(), "Le nom du joueur 1 devrait être Alice");
        assertEquals("Bob", othello.getJoueur2().getNom(), "Le nom du joueur 2 devrait être Bob");
        
        // Vérification des couleurs des joueurs
        assertEquals('N', othello.getJoueur1().getCouleur(), "Le joueur 1 devrait avoir la couleur N");
        assertEquals('B', othello.getJoueur2().getCouleur(), "Le joueur 2 devrait avoir la couleur B");
        
        // Vérification que le plateau est initialisé
        assertNotNull(othello.getPlateau(), "Le plateau ne devrait pas être null");
    }

    
}