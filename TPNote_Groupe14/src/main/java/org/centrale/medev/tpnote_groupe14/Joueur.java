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
     * couleur: Couleur associée au joueur N ou B
     */
    private String nom;
    private ArrayList<Pion> pions;
    private char couleur; 

    // Constructeur
    public Joueur(String nom, char couleur) {
        this.nom = nom;
        this.couleur = couleur;
        this.pions = new ArrayList<>();
    }

    // Getters et Setters
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

    public char getCouleur() {
        return couleur;
    }

    public void setCouleur(char couleur) {
        this.couleur = couleur;
    }

    /**
     * Ajoute un pion à la liste des pions du joueur.
     *
     * @param pion Le pion à ajouter.
     */
    public void ajouterPion(Pion pion) {
        pions.add(pion);
    }

    /**
     * Pose un pion sur le plateau et effectue les captures si possible.
     * @param plateau Le plateau de jeu.
     * @param position La position où poser le pion.
     * @return true si le coup est valide et au moins une capture a eu lieu, false sinon.
     */
    public boolean jouerCoup(Plateau plateau, Position position) {
        if (plateau.capture(position, couleur)) {
            Pion nouveauPion = new Pion(position, couleur);
            plateau.getPlateau()[position.getChifre() - 1][position.getLettre() - 'a'] = nouveauPion;
            ajouterPion(nouveauPion);
            return true;
        }
        return false; // Coup non valide
    }

    /**
     * Affiche les positions de tous les pions du joueur.
     */
    public void afficherPions() {
        System.out.println("Pions de " + nom + ":");
        for (Pion pion : pions) {
            Position pos = pion.getP();
            System.out.println("Position: " + pos.getChifre() + pos.getLettre());
        }
    }
}
