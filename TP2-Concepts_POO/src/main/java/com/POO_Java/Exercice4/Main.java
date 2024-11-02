package com.POO_Java.Exercice4;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Produit produit;
        IMetierProduit iMetierProduit = new MetierProduitImpl();
        int choice;
        do {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Afficher la liste des produits.");
            System.out.println("2. Rechercher des produits par mot clé.");
            System.out.println("3. Ajouter un nouveau produit dans la liste.");
            System.out.println("4. Récupérer et afficher un produit par ID.");
            System.out.println("5. Supprimer un produit par id.");
            System.out.println("6. Quitter");

            System.out.print("Veuillez entrer votre choix : ");
            choice = scanner.nextInt();
            scanner.nextLine();

            // Traiter le choix de l'utilisateur
            switch (choice) {
                case 1:
                    System.out.println("----Vous avez sélectionné 'Afficher la liste des produits'----");
                    List<Produit> produitList = iMetierProduit.getAll();
                    if (produitList==null){
                        Thread.sleep(1000);
                    } else {
                        for (Produit p1:produitList){
                            System.out.println(p1.toString());
                        }
                    }

                    break;
                case 2:
                    System.out.println("----Vous avez sélectionné 'Rechercher des produits par mot clé'----");
                    System.out.print("Veuillez saisir le nom cle: ");
                    String nomCle = scanner.nextLine();
                    List<Produit> produits = iMetierProduit.findByNom(nomCle);
                    if (produits==null){
                        Thread.sleep(1000);
                    } else {
                        for (Produit p2:produits){
                            System.out.println(p2.toString());
                        }
                    }
                    break;
                case 3:
                    System.out.println("----Vous avez sélectionné 'Ajouter un nouveau produit dans la liste'----");
                    System.out.print("Veuillez saisir un ID pour votre produit: ");
                    long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Veuillez saisir le nom du produit: ");
                    String nom = scanner.nextLine();
                    System.out.print("Veuillez saisir la marque du produit: ");
                    String marque = scanner.nextLine();
                    System.out.print("Veuillez saisir le prix du produit: ");
                    float prix = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.print("Veuillez saisir la description du produit: ");
                    String description = scanner.nextLine();
                    System.out.print("Veuillez saisir le nombre de stock du produit: ");
                    int nbrStock = scanner.nextInt();
                    scanner.nextLine();
                    produit = new Produit(id,nom, marque, prix, description, nbrStock);
                    System.out.println(iMetierProduit.add(produit));
                    break;
                case 4:
                    System.out.println("----Vous avez sélectionné 'Récupérer et afficher un produit par ID'----");
                    System.out.print("Veuillez entrer l'ID du produit à afficher : ");
                    long id1 = scanner.nextLong();
                    scanner.nextLine();
                    Produit p3 = iMetierProduit.findById(id1);
                    if (p3==null){
                        Thread.sleep(1000);
                    } else {
                        System.out.println(p3.toString());
                    }

                    break;
                case 5:
                    System.out.println("----Vous avez sélectionné 'Supprimer un produit par id'----");
                    System.out.print("Veuillez entrer l'ID du produit à supprimer : ");
                    int idSupprimer = scanner.nextInt();
                    scanner.nextLine();
                    iMetierProduit.delete(idSupprimer);
                    break;
                case 6:
                    System.out.println("Vous quittez le programme.");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }

            if (choice != 6) {
                System.out.println("Frappez une touche pour revenir au menu.");
                scanner.nextLine();
            }

        } while (choice != 6);

        scanner.close();
    }
}