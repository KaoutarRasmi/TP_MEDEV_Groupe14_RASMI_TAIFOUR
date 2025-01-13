/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.tpnote_groupe14;

import java.util.Scanner;

/**
 * classe Othello
 * @author kaoutar, mouad
 */
public class Othello {
    //Attribus de la classe
    /**
     * joueur1: le premier joueur 
     * joueur2: le deuxième joueur 
     */
    private Joueur joueur1;
    private Joueur joueur2;
    private Plateau plateau;

    public Othello(String nom1,String nom2) {
        joueur1 = new Joueur(nom1, 'N'); 
        joueur2 = new Joueur(nom2, 'B'); 
        plateau = new Plateau(joueur1, joueur2);
    }
    
    
    public void lancerJeu(){

        // Création du scanner pour la saisie de l'utilisateur
        Scanner scanner = new Scanner(System.in);
        
        // Le jeu continue tant qu'il y a des coups à jouer
        boolean jeuEnCours = true;
        Joueur joueurActuel = joueur1; // Le joueur 1 commence
        
        // Boucle de jeu
        while (jeuEnCours) {
            // Affichage du plateau à chaque tour
            plateau.afficherPlateau();

            // Demander au joueur de jouer un coup
            System.out.println(joueurActuel.getNom() + " (" + joueurActuel.getCouleur() + "), entrez votre coup (format: ligne, colonne) : ");
            
            // Lire la saisie du joueur
            String input = scanner.nextLine();
            String[] inputSplit = input.split(",");
            
            if (inputSplit.length != 2) {
                System.out.println("Entrée invalide. Format attendu : ligne, colonne.");
                continue;
            }
            
            try {
                int ligne = Integer.parseInt(inputSplit[0].trim());
                char colonne = inputSplit[1].trim().charAt(0);
                
                // Convertir la colonne (lettre) en indice (0-indexé)
                int colIndex = colonne - 'a';

                // Vérifier si la position est valide
                if (ligne < 1 || ligne > 8 || colIndex < 0 || colIndex > 7) {
                    System.out.println("Position invalide. Les coordonnées doivent être dans les limites du plateau (1-8 pour la ligne, a-h pour la colonne).");
                    continue;
                }
                
                // Convertir la ligne en index 0-indexé
                Position position = new Position(ligne, colonne);
                
                // Le joueur joue son coup
                if (joueurActuel.jouerCoup(plateau, position)) {
                    System.out.println(joueurActuel.getNom() + " a joué à la position " + position.getChifre() + position.getLettre());
                    // Changer de joueur
                    joueurActuel = (joueurActuel == joueur1) ? joueur2 : joueur1;
                } else {
                    System.out.println("Coup invalide, essayez à nouveau.");
                }
                
            } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                System.out.println("Entrée invalide. Format attendu : ligne, colonne.");
            }
        }

        // Clôture du scanner
        scanner.close();
    }
    
}

