package com.POO_Java.Exercice3;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Déclarer et instancier une liste de trois ordinateurs
        Ordinateur ordinateur1 = new Ordinateur("MacBook Air", "Apple", 15000, "Ultrabook léger", 10);
        Ordinateur ordinateur2 = new Ordinateur("XPS 13", "Dell", 8900, "Ultrabook haute performance", 5);
        Ordinateur ordinateur3 = new Ordinateur("ThinkPad X1", "Lenovo", 10000, "Ultrabook professionnel", 8);
        List<Ordinateur> ordinateurs = new ArrayList<>();
        ordinateurs.add(ordinateur1);
        ordinateurs.add(ordinateur2);
        ordinateurs.add(ordinateur3);

        // Déclarer et instancier une catégorie
        Categorie categorie = new Categorie("Ultrabooks", "Ordinateurs portables légers et puissants");
        categorie.setOrdinateurList(ordinateurs);

        // Déclarer et instancier un client
        Client client = new Client("IDRISSI", "Yassine", "Kasbah des Oudayas, rue Jirara", "idrissi@example.com", "Rabat", "0123456789");

        // Déclarer et instancier une commande du client
        Commande commande = new Commande("cmd1", client, new Date(), "En cours");
        client.ajouterCommande(commande);

        // Déclarer et instancier une liste de trois lignes de commandes pour la commande et les ordinateurs créés
        LigneCommande ligne1 = new LigneCommande(1, commande, ordinateur1);
        LigneCommande ligne2 = new LigneCommande(2, commande, ordinateur2);
        LigneCommande ligne3 = new LigneCommande(1, commande, ordinateur3);
        List<LigneCommande> lignesCommande = new ArrayList<>();
        lignesCommande.add(ligne1);
        lignesCommande.add(ligne2);
        lignesCommande.add(ligne3);

        // Afficher toutes les informations de la commande
        System.out.println("Informations de la commande :");
        System.out.println("Référence : " + commande.getReference());
        System.out.println("Client : " + commande.getClient());
        System.out.println("Date : " + commande.getDate());
        System.out.println("État : " + commande.getEtatCommande());
        System.out.println("Lignes de commande :");
        for (LigneCommande ligne : lignesCommande) {
            System.out.println("  - " + ligne);
        }
    }
}