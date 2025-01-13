/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.tpnote_groupe14;

/**
 *
 * @author kaoutar, mouad
 */
public class Plateau {
    //Attribus de la classe 
    /**
     * joueur1&2: sont les joueurs d Othello
     */
    private Joueur joueur1;
    private Joueur joueur2;
    //constructeur 

    public Plateau(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }
    
    //getter and setter
    
    public Joueur getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(Joueur joueur1) {
        this.joueur1 = joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(Joueur joueur2) {
        this.joueur2 = joueur2;
    }
    
    
}
