/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.tpnote_groupe14;

/**
 * Classe Position: définit la position du pion dans le plateau
 * @author kaoutar, mouad
 */
public class Position {
    //Attributs de la classe
    /**
     * chifre: indique le chifre correspondant à la postion du pion
     * lettre: indique la lettere correspondante à la position du pion
     */
    private int chifre;
    private char lettre;

    /**
    * Constructeur de la classe Position
    * @param chifre le chiffre de la position (1-8)
    * @param lettre la lettre de la position (a-h)
    */
    public Position(int chifre, char lettre) {
        this.chifre = chifre;
        this.lettre = lettre;
    }
    
    /**
     * getter 
     * @return le chiffre de la position
     */
    public int getChifre() {
        return chifre;
    }
    /**
     * set le chiffre de la position   
     * @param chifre le chiffre à définir pour la position (1-8)
     */
    public void setChifre(int chifre) {
        this.chifre = chifre;
    }
    /**
     * getter
     * @return la lettre de la position
     */
    public char getLettre() {
        return lettre;
    }
    
    /**
    * set la lettre de la position
    * @param lettre la lettre à définir pour la position (a-h)
    */
    public void setLettre(char lettre) {
        this.lettre = lettre;
    }
    
}
