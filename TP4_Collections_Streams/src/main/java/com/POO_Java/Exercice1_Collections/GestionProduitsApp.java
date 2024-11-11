package com.POO_Java.Exercice1_Collections;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionProduitsApp {


    public static void main(String[] args) {
        ArrayList<Produit> listProduit = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Ajouter un produit");
            System.out.println("2. Supprimer un produit par indice");
            System.out.println("3. Afficher la liste des produits");
            System.out.println("4. Modifier un produit par indice");
            System.out.println("5. Rechercher un produit par nom");
            System.out.println("6. Quitter");

            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    // Ajouter un produit
                    System.out.print("ID : ");
                    long id = scanner.nextLong();
                    scanner.nextLine(); // Consomme la nouvelle ligne
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prix : ");
                    double prix = scanner.nextDouble();

                    listProduit.add(new Produit(id, nom, prix));
                    System.out.println("Produit ajouté !");
                    break;

                case 2:
                    // Supprimer un produit par indice
                    System.out.print("Indice à supprimer : ");
                    int indiceSuppression = scanner.nextInt();
                    if (indiceSuppression >= 0 && indiceSuppression < listProduit.size()) {
                        listProduit.remove(indiceSuppression);
                        System.out.println("Produit supprimé !");
                    } else {
                        System.out.println("Indice invalide !");
                    }
                    break;

                case 3:
                    // Afficher la liste des produits
                    System.out.println("Liste des produits :");
                    for (Produit produit : listProduit) {
                        System.out.println(produit);
                    }
                    break;

                case 4:
                    // Modifier un produit par indice
                    System.out.print("Indice à modifier : ");
                    int indiceModification = scanner.nextInt();
                    if (indiceModification >= 0 && indiceModification < listProduit.size()) {
                        System.out.print("Nouveau nom : ");
                        scanner.nextLine(); // Consomme la nouvelle ligne
                        String nouveauNom = scanner.nextLine();
                        System.out.print("Nouveau prix : ");
                        double nouveauPrix = scanner.nextDouble();

                        Produit produitAModifier = listProduit.get(indiceModification);
                        produitAModifier.setNom(nouveauNom);
                        produitAModifier.setPrix(nouveauPrix);
                        System.out.println("Produit modifié !");
                    } else {
                        System.out.println("Indice invalide !");
                    }
                    break;

                case 5:
                    // Rechercher un produit par nom
                    System.out.print("Nom du produit à rechercher : ");
                    String nomRecherche = scanner.nextLine();
                    boolean trouve = false;
                    for (Produit produit : listProduit) {
                        if (produit.getNom().equalsIgnoreCase(nomRecherche)) {
                            System.out.println("Produit trouvé : " + produit);
                            trouve = true;
                            break;
                        }
                    }
                    if (!trouve) {
                        System.out.println("Aucun produit trouvé avec ce nom.");
                    }
                    break;

                case 6:
                    System.out.println("Au revoir !");
                    scanner.close();
                    return;

                default:
                    System.out.println("Option invalide !");
            }
        }
    }
}
