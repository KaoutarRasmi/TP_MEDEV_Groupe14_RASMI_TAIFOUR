/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.medev.tpnote_groupe14;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitaires pour la classe Pion
 * @author kaoutar, mouad
 */
public class PionTest {
    
    /**
     * Test du constructeur avec position et couleur
     */
    @Test
    public void testConstructeurComplet() {
        Position pos = new Position(4, 'd');
        Pion pion = new Pion(pos, 'N');
        
        assertEquals(pos, pion.getP(), "La position doit correspondre");
        assertEquals('N', pion.getCouleur(), "La couleur doit correspondre");
    }
    
    /**
     * Test du constructeur avec position seulement
     */
    @Test
    public void testConstructeurPosition() {
        Position pos = new Position(1, 'a');
        Pion pion = new Pion(pos);
        
        assertEquals(pos, pion.getP(), "La position doit correspondre");
        assertEquals('\0', pion.getCouleur(), "La couleur doit être la valeur par défaut char");
    }
    
    /**
     * Test du constructeur avec couleur seulement
     */
    @Test
    public void testConstructeurCouleur() {
        Pion pion = new Pion('B');
        
        assertNull(pion.getP(), "La position doit être null");
        assertEquals('B', pion.getCouleur(), "La couleur doit correspondre");
    }
    
    /**
     * Test des setters et getters pour la position
     */
    @Test
    public void testSetGetPosition() {
        Position pos1 = new Position(1, 'a');
        Position pos2 = new Position(8, 'h');
        Pion pion = new Pion(pos1, 'N');
        
        assertEquals(pos1, pion.getP(), "La position initiale doit correspondre");
        
        pion.setP(pos2);
        assertEquals(pos2, pion.getP(), "La nouvelle position doit correspondre");
    }
    
    /**
     * Test des setters et getters pour la couleur
     */
    @Test
    public void testSetGetCouleur() {
        Pion pion = new Pion(new Position(1, 'a'), 'N');
        
        assertEquals('N', pion.getCouleur(), "La couleur initiale doit être N");
        
        pion.setCouleur('B');
        assertEquals('B', pion.getCouleur(), "La nouvelle couleur doit être B");
    }
}
