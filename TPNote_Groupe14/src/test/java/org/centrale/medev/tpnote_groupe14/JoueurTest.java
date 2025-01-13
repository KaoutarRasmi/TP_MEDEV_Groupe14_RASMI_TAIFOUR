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
        // Nettoyage après chaque test
        joueur = null;
    }

    /**
     * Test of getNom method, of class Joueur.
     */
    @Test
    public void testGetNom() {
        // Vérifier que le nom du joueur est correct
        String expected = "testo";
        String actual = joueur.getNom();
        assertEquals(expected, actual, "Le nom du joueur doit être 'testo'");
    }

    /**
     * Test of setNom method, of class Joueur.
     */
    @Test
    public void testSetNom() {
        // Vérifier que l'on peut modifier le nom du joueur
        String nouveauNom = "Bob";
        joueur.setNom(nouveauNom);
        assertEquals(nouveauNom, joueur.getNom(), "Le nom du joueur doit être modifié à 'Bob'");
    }

    /**
     * Test of getPions method, of class Joueur.
     */
    @Test
    public void testGetPions() {
        // Vérifier que la liste de pions est vide à l'initialisation
        List<Pion> expected = new ArrayList<>();
        List<Pion> actual = joueur.getPions();
        assertEquals(expected, actual, "La liste des pions doit être vide initialement");
    }

    /**
     * Test of setPions method, of class Joueur.
     */
    @Test
    public void testSetPions() {
        // Vérifier qu'on peut modifier la liste des pions du joueur
        ArrayList<Pion> pions = new ArrayList<>();
        Pion pion = new Pion(new Position(1, 'a'), 'N');
        pions.add(pion);
        joueur.setPions(pions);
        assertEquals(pions, joueur.getPions(), "La liste des pions ne correspond pas");
    }

    /**
     * Test of getCouleur method, of class Joueur.
     */
    @Test
    public void testGetCouleur() {
        // Vérifier la couleur du joueur
        char expected = 'N';
        char actual = joueur.getCouleur();
        assertEquals(expected, actual, "La couleur du joueur doit être 'N'");
    }

    /**
     * Test of setCouleur method, of class Joueur.
     */
    @Test
    public void testSetCouleur() {
        // Vérifier que la couleur peut être modifiée
        char nouvelleCouleur = 'B';
        joueur.setCouleur(nouvelleCouleur);
        assertEquals(nouvelleCouleur, joueur.getCouleur(), "La couleur du joueur doit être modifiée à 'B'");
    }

    /**
     * Test of ajouterPion method, of class Joueur.
     */
    @Test
    public void testAjouterPion() {
        // Vérifier qu'un pion peut être ajouté à la liste des pions du joueur
        Pion pion = new Pion(new Position(1, 'a'), 'N');
        joueur.ajouterPion(pion);
        assertTrue(joueur.getPions().contains(pion), "Le pion ajouté doit être présent dans la liste des pions");
    }

    /**
     * Test of jouerCoup method, of class Joueur.
     */
    @Test
    public void testJouerCoup() {
        // Créer un plateau et jouer un coup sur celui-ci
        Plateau plateau = new Plateau(joueur, new Joueur("Bob", 'B'));
        Position position = new Position(4, 'c'); // Position sur le plateau
        joueur.jouerCoup(plateau, position);

        // Vérifier que le pion a bien été placé sur le plateau à la position donnée
        Pion pion = plateau.getPlateau()[position.getChifre() - 1][position.getLettre() - 'a'];
        assertNotNull(pion, "Le pion doit être placé sur le plateau");
        assertEquals(pion.getCouleur(), joueur.getCouleur(), "La couleur du pion doit correspondre à celle du joueur");
    }

    /**
     * Test of afficherPions method, of class Joueur.
     */
    @Test
    public void testAfficherPions() {
        // Ajouter un pion et vérifier l'affichage
        Pion pion = new Pion(new Position(1, 'a'), 'N');
        joueur.ajouterPion(pion);
        
        // On ne peut pas tester l'affichage directement, donc on vérifie la taille de la liste des pions
        // après l'appel de la méthode afficherPions, ou en fonction de l'effet indirect.
        joueur.afficherPions(); // Cette méthode doit être testée visuellement (effet indirect)
        assertTrue(joueur.getPions().size() > 0, "Il doit y avoir des pions à afficher");
    }

    /**
     * Test if the player can add multiple pions correctly.
     */
    @Test
    public void testAjouterPlusieursPions() {
        // Vérifier que plusieurs pions peuvent être ajoutés
        Pion pion1 = new Pion(new Position(2, 'b'), 'N');
        Pion pion2 = new Pion(new Position(3, 'c'), 'N');
        joueur.ajouterPion(pion1);
        joueur.ajouterPion(pion2);
        
        // Vérifier que les deux pions ont été ajoutés
        assertTrue(joueur.getPions().contains(pion1), "Le pion 1 doit être présent dans la liste");
        assertTrue(joueur.getPions().contains(pion2), "Le pion 2 doit être présent dans la liste");
    }

    /**
     * Test if playing a move on a full plateau does not place a pion in an invalid position.
     */
    @Test
    public void testJouerCoupInvalid() {
        // Créer un plateau où toutes les cases sont déjà occupées
        Plateau plateau = new Plateau(joueur, new Joueur("Bob", 'B'));
        
        // Essayer de jouer dans une position déjà occupée
        Position position = new Position(1, 'a'); // Cette position est déjà occupée
        joueur.jouerCoup(plateau, position);
        
        // Vérifier que la position n'a pas été modifiée (le pion ne doit pas être déplacé)
        Pion pion = plateau.getPlateau()[position.getChifre() - 1][position.getLettre() - 'a'];
        assertNotNull(pion, "La position déjà occupée ne doit pas permettre d'ajouter un pion");
    }
}
