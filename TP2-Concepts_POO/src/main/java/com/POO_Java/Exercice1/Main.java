package com.POO_Java.Exercice1;


public class Main {
    public static void main(String[] args) {
        Adherent adherent = new Adherent("Doe", "John", "johndoe@example.com", "0123456789", 25, 123);
        Auteur auteur = new Auteur("Smith", "Jane", "janesmith@example.com", "0987654321", 40, 456);
        Livre livre = new Livre(123456, "Introduction to Java", auteur);

        System.out.println("Informations de l'Adhérent:");
        adherent.afficher();
        System.out.println("\nInformations du Livre:");
        livre.afficher();
    }
}