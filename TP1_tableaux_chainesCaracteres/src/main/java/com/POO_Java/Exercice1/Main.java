package com.POO_Java.Exercice1_Collections;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nombre de notes à insérer: ");
        int nbrNotes = scanner.nextInt();
        // Créer une instance de NoteEtudiant avec une taille fixe
        NoteEtudiant noteEtudiant = new NoteEtudiant(nbrNotes);
        // Demander à l'utilisateur de saisir les notes
        for (int i = 0; i < nbrNotes; i++) {
            System.out.print("Entrez la note " + (i + 1) + ": ");
            float note = scanner.nextFloat();
            noteEtudiant.ajouterNote(note);  // Add each note to the array
        }
        // Récupérez les notes et affichez la liste originale
        float[] notes = noteEtudiant.getNotes();
        System.out.println("Notes avant tri: " + java.util.Arrays.toString(notes));
        // Trier les notes et afficher le tableau trié
        noteEtudiant.trierListe();
        // Calculer la note moyenne
        float moyenne = noteEtudiant.calculerMoyenne();
        System.out.println("La moyenne des notes est: " + moyenne);
        // Afficher la note maximale et la note minimale
        noteEtudiant.maxEtMinNotes();
        // Le nombre d’étudiants ayant une note saisie par l’utilisateur
        System.out.print("Entrez la note: ");
        float noteChercher = scanner.nextFloat();
        int occurence = noteEtudiant.occurenceNote(noteChercher);
        System.out.println("Le nombre d'etudiants ayant la note " + noteChercher + " est: " + occurence);
        scanner.close();
    }
}