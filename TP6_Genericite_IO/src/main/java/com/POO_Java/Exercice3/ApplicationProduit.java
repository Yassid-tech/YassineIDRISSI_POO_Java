package com.POO_Java.Exercice3;

import java.util.Scanner;

public class ApplicationProduit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MetierProduitImpl metierProduit = new MetierProduitImpl("produits.dat");

        while (true) {
            System.out.println("\n--- MENU PRODUITS ---");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher un produit par nom");
            System.out.println("3. Ajouter un produit");
            System.out.println("4. Supprimer un produit par nom");
            System.out.println("5. Sauvegarder les produits");
            System.out.println("6. Quitter");

            System.out.print("Choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    metierProduit.getAll().forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Entrez le nom du produit : ");
                    String nomRecherche = scanner.nextLine();
                    Produit produit = metierProduit.findByNom(nomRecherche);
                    System.out.println(produit != null ? produit : "Produit introuvable.");
                    break;
                case 3:
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Marque : ");
                    String marque = scanner.nextLine();
                    System.out.print("Prix : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Description : ");
                    String description = scanner.nextLine();
                    System.out.print("Stock : ");
                    int stock = scanner.nextInt();
                    scanner.nextLine();
                    metierProduit.add(new Produit(nom, marque, prix, description, stock));
                    System.out.println("Produit ajouté.");
                    break;
                case 4:
                    System.out.print("Entrez le nom du produit à supprimer : ");
                    String nomSupprime = scanner.nextLine();
                    metierProduit.delete(nomSupprime);
                    System.out.println("Produit supprimé.");
                    break;
                case 5:
                    metierProduit.saveAll();
                    System.out.println("Produits sauvegardés.");
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
