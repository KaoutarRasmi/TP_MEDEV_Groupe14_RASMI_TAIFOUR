/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.tpnote_groupe14;

import java.util.ArrayList;

/**
 * class qui représente le joueur 
 * @author kaoutar, mouad
 */
public class Joueur {
    //Attributs de la classe 
    /**
     * nom: le nom du joueur 
     * pions: la liste des pions de joueur 
     */
    private String nom;
    private ArrayList<Pion> pions;
    
    //Constructeur 
    public Joueur(String nom) {
        this.nom = nom;
        this.pions = new ArrayList<Pion>();
    }
    
    //getter and setter 
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Pion> getPions() {
        return pions;
    }

    public void setPions(ArrayList<Pion> pions) {
        this.pions = pions;
    }
    
    
    
    
}
