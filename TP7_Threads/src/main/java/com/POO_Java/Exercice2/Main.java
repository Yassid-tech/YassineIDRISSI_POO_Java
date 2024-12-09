package com.POO_Java.Exercice2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Créer un tableau d'entiers
        int[] tableau = new int[100];
        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = i + 1; // Valeurs de 1 à 100
        }

        // Définir le nombre de threads (plages)
        int nombreDeThreads = 4;
        int taillePlage = tableau.length / nombreDeThreads;

        // Créer une liste pour les threads et les instances Sommeur
        List<Thread> threads = new ArrayList<>();
        List<Sommeur> sommeurs = new ArrayList<>();

        // Diviser le travail et créer les threads
        for (int i = 0; i < nombreDeThreads; i++) {
            int debut = i * taillePlage;
            int fin = (i == nombreDeThreads - 1) ? tableau.length : debut + taillePlage;

            Sommeur sommeur = new Sommeur(tableau, debut, fin);
            sommeurs.add(sommeur);

            Thread thread = new Thread(sommeur);
            threads.add(thread);
            thread.start(); // Démarrer le thread
        }

        // Attendre que tous les threads aient terminé
        for (Thread thread : threads) {
            try {
                thread.join(); // Attendre la fin du thread
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Calculer la somme totale
        int sommeTotale = 0;
        for (Sommeur sommeur : sommeurs) {
            sommeTotale += sommeur.getSomme(); // Récupérer la somme partielle
        }


        // Afficher la somme totale
        System.out.println("Somme totale du tableau : " + sommeTotale);

        int test=0;
        for (int i = 1; i <= 100; i++) {
            test= test+i;
        }

        System.out.println(test);
    }
}
