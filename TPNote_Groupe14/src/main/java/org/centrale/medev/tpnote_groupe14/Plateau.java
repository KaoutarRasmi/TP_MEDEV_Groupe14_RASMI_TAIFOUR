/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.tpnote_groupe14;
/**
 * Classe Plateau: le plateau du jeu
 * @author kaoutar, mouad
 */

import java.util.ArrayList;

public class Plateau {
    //Attribus de la classe
    /**
     * joueur1&2
     * plateau: le plateau du jeu
     */
    private Joueur joueur1;
    private Joueur joueur2;
    private Pion[][] plateau; 

    // Constructeur
    public Plateau(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.plateau = new Pion[8][8]; 
        initialiserPlateau();
    }

    // Getter et Setter
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

    public Pion[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(Pion[][] plateau) {
        this.plateau = plateau;
    }

    /**
     * initialisation du plateau
     */
    private void initialiserPlateau() {
        plateau[3][3] = new Pion(new Position(4, 'd'), 'B'); // Position 4d
        plateau[4][4] = new Pion(new Position(5, 'e'), 'B'); // Position 5e
        plateau[3][4] = new Pion(new Position(4, 'e'), 'N'); // Position 4e
        plateau[4][3] = new Pion(new Position(5, 'd'), 'N'); // Position 5d
    }

    
    
    /**
     * Capture les pions adverses en fonction du coup joué
     * @param position La position où le pion est posé
     * @param couleur  La couleur du pion joué
     * @return true si au moins un pion a été capturé, sinon false.
     */
    /*
    public boolean capture(Position position, char couleur) {
        boolean captureValide = false;

        // Convertir la position (lettre, chiffre) en indices (ligne, colonne)
        int x = position.getChifre() - 1; // Ligne (0-indexé)
        int y = position.getLettre() - 'a'; // Colonne (0-indexé)

        // Vérifier dans toutes les directions (8 directions possibles)
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx != 0 || dy != 0) { // Ignorer la direction (0, 0)
                    captureValide |= captureDirection(x, y, dx, dy, couleur);
                }
            }
        }

        return captureValide;
    }

    /**
     * Vérifie et capture dans une direction spécifique.
     * @param x        La position initiale
     * @param y        La position initiale
     * @param dx       Direction suivant X
     * @param dy       Direction suivant Y
     * @param couleur  La couleur du pion 
     * @return true si des pions ont été capturés dans cette direction.
     */
    /*
    private boolean captureDirection(int x, int y, int dx, int dy, char couleur) {
        char couleurAdverse = (couleur == 'N') ? 'B' : 'N';
        ArrayList<Pion> pionsACapturer = new ArrayList<>();

        int nx = x + dx;
        int ny = y + dy;

        while (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
            Pion currentPion = plateau[nx][ny];

            if (currentPion == null) {
                // Case vide : pas de capture possible dans cette direction
                return false;
            } else if (currentPion.getCouleur() == couleurAdverse) {
                // Ajouter le pion adverse à la liste temporaire
                pionsACapturer.add(currentPion);
            } else if (currentPion.getCouleur() == couleur) {
                // Si un pion de la même couleur est trouvé, retourner les pions
                for (Pion p : pionsACapturer) {
                    p.setCouleur(couleur);
                }
                return !pionsACapturer.isEmpty(); // Capture réussie si au moins un pion
            } else {
                // Autre cas, pas de capture possible
                return false;
            }

            // Continuer dans la même direction
            nx += dx;
            ny += dy;
        }

        return false; // Si on sort de la boucle sans capturer
    }
    */
    /**
     * Capture les pions adverses en fonction du coup joué
     * @param position La position où le pion est posé
     * @param couleur  La couleur du pion joué
     * @return true si au moins un pion a été capturé, sinon false.
     */
    public boolean capture(Position position, char couleur) {
        boolean captureValide = false;

        // Convertir la position (lettre, chiffre) en indices (ligne, colonne)
        int x = position.getChifre() - 1; // Ligne (0-indexé)
        int y = position.getLettre() - 'a'; // Colonne (0-indexé)

        // Vérifier dans toutes les directions (8 directions possibles)
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx != 0 || dy != 0) { // Ignorer la direction (0, 0)
                    captureValide |= captureDirection(x, y, dx, dy, couleur);
                }
            }
        }

        return captureValide;
    }

    /**
     * Vérifie et capture dans une direction spécifique.
     * @param x        La position initiale
     * @param y        La position initiale
     * @param dx       Direction suivant X
     * @param dy       Direction suivant Y
     * @param couleur  La couleur du pion 
     * @return true si des pions ont été capturés dans cette direction.
     */
    private boolean captureDirection(int x, int y, int dx, int dy, char couleur) {
        char couleurAdverse = (couleur == 'N') ? 'B' : 'N';
        ArrayList<Pion> pionsACapturer = new ArrayList<>();

        int nx = x + dx;
        int ny = y + dy;

        while (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
            Pion currentPion = plateau[nx][ny];

            if (currentPion == null) {
                // Case vide : pas de capture possible dans cette direction
                return false;
            } else if (currentPion.getCouleur() == couleurAdverse) {
                // Ajouter le pion adverse à la liste temporaire
                pionsACapturer.add(currentPion);
            } else if (currentPion.getCouleur() == couleur) {
                // Si un pion de la même couleur est trouvé, retourner les pions
                for (Pion p : pionsACapturer) {
                    p.setCouleur(couleur);
                }
                return !pionsACapturer.isEmpty(); // Capture réussie si au moins un pion
            } else {
                // Autre cas, pas de capture possible
                return false;
            }

            // Continuer dans la même direction
            nx += dx;
            ny += dy;
        }

        return false; // Si on sort de la boucle sans capturer
    }
    /**
     * affichage du plateau
     */
    public void afficherPlateau() {
        System.out.println("  a b c d e f g h"); 
        for (int i = 0; i < 8; i++) { 
            System.out.print((i + 1) + " "); 
            for (int j = 0; j < 8; j++) { 
                Pion pion = plateau[i][j];
                if (pion == null) {
                    System.out.print(". "); 
                } else {
                    System.out.print(pion.getCouleur() + " "); 
                }
            }
            System.out.println(); 
        }
    }

}
