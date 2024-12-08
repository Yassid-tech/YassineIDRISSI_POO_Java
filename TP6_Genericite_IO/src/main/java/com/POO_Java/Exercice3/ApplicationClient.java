package com.POO_Java.Exercice3;

import java.util.Scanner;

public class ApplicationClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MetierClientImpl metierClient = new MetierClientImpl("clients.dat");

        while (true) {
            System.out.println("\n--- MENU CLIENTS ---");
            System.out.println("1. Afficher la liste des clients");
            System.out.println("2. Rechercher un client par nom");
            System.out.println("3. Ajouter un client");
            System.out.println("4. Supprimer un client par nom");
            System.out.println("5. Sauvegarder les clients");
            System.out.println("6. Quitter");

            System.out.print("Choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    metierClient.getAll().forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Entrez le nom du client : ");
                    String nomRecherche = scanner.nextLine();
                    Client client = metierClient.findByNom(nomRecherche);
                    System.out.println(client != null ? client : "Client introuvable.");
                    break;
                case 3:
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prenom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Adresse : ");
                    String adresse = scanner.nextLine();
                    System.out.print("Telephone : ");
                    String tel = scanner.nextLine();
                    System.out.print("Email : ");
                    String email = scanner.nextLine();
                    metierClient.add(new Client(nom, prenom, adresse, tel, email));
                    System.out.println("Client ajouté.");
                    break;
                case 4:
                    System.out.print("Entrez le nom du client à supprimer : ");
                    String nomSupprime = scanner.nextLine();
                    metierClient.delete(nomSupprime);
                    System.out.println("Client supprimé.");
                    break;
                case 5:
                    metierClient.saveAll();
                    System.out.println("Clients sauvegardés.");
                    break;
                case 6:
                    System.out.println("Au revoir !");
                    scanner.close();
                    return;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }
}
