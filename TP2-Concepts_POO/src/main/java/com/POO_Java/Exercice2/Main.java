package com.POO_Java.Exercice2;




public class Main {
    public static void main(String[] args) {
        Ingenieur ingenieur = new Ingenieur("Dupont", "Jean", "jean.dupont@example.com", "0702030405", 8000, "AI");
        Manager manager = new Manager("IDRISSI", "Yassine", "yassine.idrissi@example.com", "0607080910", 10000, "IT");

        System.out.println("Informations de l'Ingenieur:");
        ingenieur.afficherInfo();

        System.out.println("\nInformations du Manager:");
        manager.afficherInfo();
    }
}