package com.POO_Java.Exercice2_Collections;

import java.util.HashMap;

public class GestionNotes {
    public static void main(String[] args) {
        HashMap<String, Double> notesEtudiants = new HashMap<>();

        // Insérer des notes des étudiants
        notesEtudiants.put("Yassine", 15.5);
        notesEtudiants.put("Soufiane", 12.0);
        notesEtudiants.put("Saad", 18.0);
        notesEtudiants.put("Walid", 16.5);

        afficherNotes(notesEtudiants);

        // Augmenter la note d’un étudiant
        String etudiant = "Yassine";
        if (notesEtudiants.containsKey(etudiant)) {
            notesEtudiants.put(etudiant, notesEtudiants.get(etudiant) + 1.0);
            System.out.println("\nNote de " + etudiant + " augmentée de 1 point.");
        }
        afficherNotes(notesEtudiants);

        // Supprimer la note d’un étudiant
        etudiant = "Saad";
        notesEtudiants.remove(etudiant);
        System.out.println("\nNote de " + etudiant + " supprimée.");
        afficherNotes(notesEtudiants);

        // Afficher la taille du map
        System.out.println("\nTaille du map : " + notesEtudiants.size());

        // Afficher la note moyenne, max et min
        afficherStats(notesEtudiants);

        // Vérifier s’il y a une note égale à 20
        boolean noteDeVingt = notesEtudiants.containsValue(20.0);
        System.out.println("\nY a-t-il une note égale à 20 ? " + (noteDeVingt ? "Oui" : "Non"));
    }

    // Méthode pour afficher les notes avec une boucle forEach et une expression lambda
    public static void afficherNotes(HashMap<String, Double> notes) {
        System.out.println("\nListe des notes des étudiants :");
        notes.forEach((nom, note) -> System.out.println(nom + " : " + note));
    }

    // Méthode pour calculer et afficher la moyenne, la note max et la note min
    public static void afficherStats(HashMap<String, Double> notes) {
        if (notes.isEmpty()) {
            System.out.println("\nAucune note disponible.");
            return;
        }

        double somme = 0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

        for (double note : notes.values()) {
            somme += note;
            if (note > max) max = note;
            if (note < min) min = note;
        }

        double moyenne = somme / notes.size();
        System.out.println("\nStatistiques des notes :");
        System.out.printf("Moyenne : %.2f\n", moyenne);
        System.out.printf("Note maximale : %.2f\n", max);
        System.out.printf("Note minimale : %.2f\n", min);
    }
}
