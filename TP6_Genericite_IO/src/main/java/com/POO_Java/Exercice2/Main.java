package com.POO_Java.Exercice2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Chemin du répertoire pour stocker les fichiers de contact
        System.out.print("Entrez le chemin du répertoire pour les contacts : ");
        String directoryPath = scanner.nextLine();

        DossierContact dossierContact = new DossierContact(directoryPath);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Rechercher un numéro de téléphone");
            System.out.println("2. Ajouter un nouveau contact");
            System.out.println("3. Supprimer un contact");
            System.out.println("4. Changer le numéro de téléphone d’un contact");
            System.out.println("5. Quitter");

            System.out.print("Entrez votre choix : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne restante

            switch (choice) {
                case 1:
                    System.out.print("Entrez le nom du contact à rechercher : ");
                    String searchName = scanner.nextLine();
                    String number = dossierContact.searchContact(searchName);
                    if (number != null) {
                        System.out.println("Numéro trouvé : " + number);
                    } else {
                        System.out.println("Contact introuvable.");
                    }
                    break;

                case 2:
                    System.out.print("Entrez le nom du nouveau contact : ");
                    String newName = scanner.nextLine();
                    System.out.print("Entrez le numéro du contact : ");
                    String newNumber = scanner.nextLine();
                    dossierContact.addContact(newName, newNumber);
                    System.out.println("Contact ajouté avec succès !");
                    break;

                case 3:
                    System.out.print("Entrez le nom du contact à supprimer : ");
                    String removeName = scanner.nextLine();
                    dossierContact.removeContact(removeName);
                    System.out.println("Contact supprimé avec succès !");
                    break;

                case 4:
                    System.out.print("Entrez le nom du contact à modifier : ");
                    String updateName = scanner.nextLine();
                    System.out.print("Entrez le nouveau numéro : ");
                    String updateNumber = scanner.nextLine();
                    dossierContact.updateContact(updateName, updateNumber);
                    System.out.println("Contact mis à jour avec succès !");
                    break;

                case 5:
                    System.out.println("Merci d'avoir utilisé l'annuaire téléphonique.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }
}
