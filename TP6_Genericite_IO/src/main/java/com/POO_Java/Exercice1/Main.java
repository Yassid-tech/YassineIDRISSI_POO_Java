package com.POO_Java.Exercice1;

public class Main {
    public static void main(String[] args) {

        // Saisir le chemin du répertoire
        System.out.print("Entrez le chemin complet du répertoire : ");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String directoryPath = scanner.nextLine();
        scanner.close();

        // Créer une instance de SimulationLS et exécuter la simulation
        SimulationLS simulation = new SimulationLS();
        simulation.simulate(directoryPath);
    }
}