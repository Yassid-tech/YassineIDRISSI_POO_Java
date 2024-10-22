package com.POO_Java.Exercice3;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringManupulator stringManupulator = null;
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Saisir");
            System.out.println("2. Afficher");
            System.out.println("3. Inverser");
            System.out.println("4. Nombre de mots");
            System.out.println("5. Quitter");


            System.out.print("Veuillez entrer votre choix : ");
            choice = scanner.nextInt();
            scanner.nextLine();

            // Traiter le choix de l'utilisateur
            switch (choice) {
                case 1:
                    System.out.println("----Vous avez sélectionné 'Saisir'----");
                    System.out.print("Veuillez saisir une chaîne de caractères: ");
                    String chaine = scanner.nextLine();
                    stringManupulator = new StringManupulator(chaine);
                    break;
                case 2:
                    System.out.println("----Vous avez sélectionné 'Afficher'----");
                    if (stringManupulator != null) {
                        System.out.println("La chaîne saisie est la suivante -->  '" + stringManupulator.getChaine() + "'");
                    } else {
                        System.out.println("Aucune chaîne n'a été saisie pour le moment.");
                    }
                    break;
                case 3:
                    System.out.println("----Vous avez sélectionné 'Inverser'----");
                    if (stringManupulator != null) {
                        System.out.println("L'inverse de la chaîne saisie est -->  '" + stringManupulator.inverserChaine() + "'");
                    } else {
                        System.out.println("Aucune chaîne n'a été saisie pour le moment.");
                    }
                    break;
                case 4:
                    System.out.println("----Vous avez sélectionné 'Nombre de mots'----");
                    if (stringManupulator != null) {
                        System.out.println("Le nombre de mots de la chaîne est -->  " + stringManupulator.calculerNombreMots());
                    } else {
                        System.out.println("Aucune chaîne n'a été saisie pour le moment.");
                    }
                    break;
                case 5:
                    System.out.println("Vous quittez le programme.");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }

            if (choice != 5) {
                System.out.println("Frappez une touche pour revenir au menu.");
                scanner.nextLine();
            }

        } while (choice != 5);

        scanner.close();
    }
}