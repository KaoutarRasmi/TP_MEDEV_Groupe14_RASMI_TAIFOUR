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
     * getter 
     * @return le chiffre de la position
     */
    public int getChifre() {
        return chifre;
    }
    /**
     * set le chiffre de la position 
     * @param chifre 
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
     * @param lettre 
     */
    public void setLettre(char lettre) {
        this.lettre = lettre;
    }
    
    /**
     * deplacer un pion dans une position(x,c)
     * @param x
     * @param c
     */
    public void deplacer(int x, char c){
        //vérification de la validité de la position de déplacement 
        if(x>=1 && x<=8) this.chifre=x;
        if(c>='a' && c<='h') this.lettre=c;
    } 
}
