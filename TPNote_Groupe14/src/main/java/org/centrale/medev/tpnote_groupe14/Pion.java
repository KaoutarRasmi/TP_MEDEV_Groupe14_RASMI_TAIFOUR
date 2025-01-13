/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.tpnote_groupe14;

/**
 * Pion 
 * @author kaoutar, mouad
 */
public class Pion {
    //Attribus de la classe
    /**
     * p: position du pion
     * couleur: couleur du pion
     */
    private Position p;
    private char couleur;
    
    //constructeur 

    public Pion(Position p, char couleur) {
        this.p = p;
        this.couleur = couleur;
    }

    public Pion(Position p) {
        this.p = p;
    }

    public Pion(char couleur) {
        this.couleur = couleur;
    }
    
    
    //getter et setter
    public Position getP() {
        return p;
    }

    public void setP(Position p) {
        this.p = p;
    }

    public char getCouleur() {
        return couleur;
    }

    public void setCouleur(char couleur) {
        this.couleur = couleur;
    }
    
    
}
