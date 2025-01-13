/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.tpnote_groupe14;

import java.util.Scanner;

public class Othello {
    private Plateau plateau;
    private Joueur joueurCourant;
    private boolean partieTerminee;

    public Othello() {
        // Initialisation des joueurs
        Joueur joueur1 = new Joueur("Joueur 1", 'N');
        Joueur joueur2 = new Joueur("Joueur 2", 'B');
        
        // Création du plateau avec les joueurs
        this.plateau = new Plateau(joueur1, joueur2);
        
        // Le joueur noir commence toujours
        this.joueurCourant = joueur1;
        this.partieTerminee = false;
    }
    
    /**
     * Démarre et gère une partie d'Othello
     */
    public void jouerPartie() {
        Scanner scanner = new Scanner(System.in);
        
        while (!partieTerminee) {
            // Afficher l'état actuel
            plateau.afficherPlateau();
            System.out.println("C'est au tour de " + joueurCourant.getNom() + 
                             " (couleur: " + joueurCourant.getCouleur() + ")");
            
            // Vérifier s'il y a des coups possibles
            if (!existeCoupsPossibles()) {
                // Si le joueur ne peut pas jouer, on passe au joueur suivant
                System.out.println(joueurCourant.getNom() + " ne peut pas jouer.");
                changerJoueur();
                
                // Si l'autre joueur ne peut pas non plus jouer, la partie est terminée
                if (!existeCoupsPossibles()) {
                    partieTerminee = true;
                    break;
                }
                continue;
            }
            
            // Demander le coup au joueur
            Position coup;
            boolean coupValide;
            do {
                coup = demanderCoup(scanner);
                coupValide = joueurCourant.jouerCoup(plateau, coup);
                
                if (!coupValide) {
                    System.out.println("Coup invalide, veuillez réessayer.");
                }
            } while (!coupValide);
            
            // Passer au joueur suivant
            changerJoueur();
        }
        
        // Afficher le résultat final
        afficherResultat();
        scanner.close();
    }
    
    /**
     * Vérifie s'il existe des coups possibles pour le joueur courant
     * @return true s'il existe au moins un coup possible
     */
    private boolean existeCoupsPossibles() {
        for (int i = 1; i <= 8; i++) {
            for (char j = 'a'; j <= 'h'; j++) {
                Position pos = new Position(i, j);
                if (plateau.getPlateau()[i-1][j-'a'] == null) {
                    if (plateau.capture(pos, joueurCourant.getCouleur())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /**
 * Demande au joueur d'entrer son coup et vérifie sa validité
 * @param scanner Scanner pour la saisie
 * @return la position choisie
 */
private Position demanderCoup(Scanner scanner) {
    while (true) {
        System.out.print("Entrez votre coup (ex: e3) : ");
        String coup = scanner.nextLine().trim().toLowerCase();
        
        // Vérifier la longueur de l'entrée
        if (coup.length() != 2) {
            System.out.println("Format incorrect. Veuillez entrer une lettre (a-h) suivie d'un chiffre (1-8).");
            continue;
        }
        
        char lettre = coup.charAt(0);
        char chiffre = coup.charAt(1);
        
        // Vérifier que la lettre est valide (a-h)
        if (lettre < 'a' || lettre > 'h') {
            System.out.println("Lettre invalide. Veuillez utiliser une lettre entre 'a' et 'h'.");
            continue;
        }
        
        // Vérifier que le chiffre est valide (1-8)
        if (chiffre < '1' || chiffre > '8') {
            System.out.println("Chiffre invalide. Veuillez utiliser un chiffre entre 1 et 8.");
            continue;
        }
        
        // Convertir le chiffre en int
        int ligne = Character.getNumericValue(chiffre);
        
        // Créer et retourner la position
        Position position = new Position(ligne, lettre);
        
        // Vérifier si la case est vide
        if (plateau.getPlateau()[ligne-1][lettre-'a'] != null) {
            System.out.println("Cette case est déjà occupée. Veuillez choisir une case vide.");
            continue;
        }
        
        // Vérifier si le coup permet une capture
        if (!plateau.capture(position, joueurCourant.getCouleur())) {
            System.out.println("Ce coup ne permet pas de capture. Veuillez choisir un autre coup.");
            continue;
        }
        
        return position;
    }
}
    
    /**
     * Change le joueur courant
     */
    private void changerJoueur() {
        joueurCourant = (joueurCourant == plateau.getJoueur1()) ? 
                        plateau.getJoueur2() : plateau.getJoueur1();
    }
    
    /**
     * Affiche le résultat final de la partie
     */
    private void afficherResultat() {
        plateau.afficherPlateau();
        
        int pionsNoirs = 0;
        int pionsBlancs = 0;
        
        // Compter les pions
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Pion pion = plateau.getPlateau()[i][j];
                if (pion != null) {
                    if (pion.getCouleur() == 'N') pionsNoirs++;
                    else pionsBlancs++;
                }
            }
        }
        
        // Afficher les scores
        System.out.println("\nFin de la partie !");
        System.out.println("Score des Noirs : " + pionsNoirs);
        System.out.println("Score des Blancs : " + pionsBlancs);
        
        // Déterminer le vainqueur
        if (pionsNoirs > pionsBlancs) {
            System.out.println("Le joueur Noir gagne !");
        } else if (pionsBlancs > pionsNoirs) {
            System.out.println("Le joueur Blanc gagne !");
        } else {
            System.out.println("Match nul !");
        }
    }
    
    
}
