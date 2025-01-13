/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

 package org.centrale.medev.tpnote_groupe14;

 import org.junit.jupiter.api.Test;
 import static org.junit.jupiter.api.Assertions.*;
 
 /**
  * Tests unitaires pour la classe Position
  * @author kaoutar, mouad
  */
 public class PositionTest {
     
     /**
      * Test du constructeur
      */
     @Test
     public void testConstructeur() {
         Position position = new Position(4, 'd');
         
         assertEquals(4, position.getChifre(), "Le chiffre devrait être 4");
         assertEquals('d', position.getLettre(), "La lettre devrait être d");
     }
     
     /**
      * Test des limites valides pour le constructeur
      */
     @Test
     public void testConstructeurLimites() {
         // Test des valeurs minimales
         Position posMin = new Position(1, 'a');
         assertEquals(1, posMin.getChifre());
         assertEquals('a', posMin.getLettre());
         
         // Test des valeurs maximales
         Position posMax = new Position(8, 'h');
         assertEquals(8, posMax.getChifre());
         assertEquals('h', posMax.getLettre());
     }
     
     
     
     /**
      * Test de plusieurs positions différentes
      */
     @Test
     public void testDifferentesPositions() {
         // Test plusieurs positions sur le plateau
         Position pos1 = new Position(1, 'a');
         Position pos2 = new Position(4, 'd');
         Position pos3 = new Position(8, 'h');
         
         // Vérification des positions
         assertEquals(1, pos1.getChifre());
         assertEquals('a', pos1.getLettre());
         
         assertEquals(4, pos2.getChifre());
         assertEquals('d', pos2.getLettre());
         
         assertEquals(8, pos3.getChifre());
         assertEquals('h', pos3.getLettre());
     }
 }