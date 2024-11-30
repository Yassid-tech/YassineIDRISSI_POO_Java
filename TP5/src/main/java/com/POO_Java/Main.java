package com.POO_Java;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static MetierImpl metier = new MetierImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Ajouter professeur");
            System.out.println("2. Listes des professeurs");
            System.out.println("3. Chercher professeurs");
            System.out.println("4. Modifier professeur");
            System.out.println("5. Supprimer un professeur");
            System.out.println("6. Ajouter departement");
            System.out.println("7. Liste des departements");
            System.out.println("8. Trouver les professeurs par departement");
            System.out.println("9. Quitter");
            System.out.print("Veuillez entrer choix: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addProfesseur();
                case 2 -> listProfesseurs();
                case 3 -> searchProfesseurs();
                case 4 -> updateProfesseur();
                case 5 -> deleteProfesseur();
                case 6 -> addDepartement();
                case 7 -> listDepartements();
                case 8 -> professeursByDepartement();
                case 9 -> {
                    System.out.println("Au revoir...");
                    System.exit(0);
                }
                default -> System.out.println("choix invalide, veuillez ressayer.");
            }
        }
    }

    private static void addProfesseur() {
        System.out.print("Entrer nom: ");
        String nom = scanner.nextLine();
        System.out.print("Entrer prenom: ");
        String prenom = scanner.nextLine();
        System.out.print("Entrer CIN: ");
        String cin = scanner.nextLine();
        System.out.print("Entrer adresse: ");
        String adresse = scanner.nextLine();
        System.out.print("Entrer telephone: ");
        String telephone = scanner.nextLine();
        System.out.print("Entrer email: ");
        String email = scanner.nextLine();
        System.out.print("Entrer date de recruitment (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Entrer departement ID: ");
        int deptId = scanner.nextInt();

        Professeur professeur = new Professeur(0, nom, prenom, cin, adresse, telephone, email, java.sql.Date.valueOf(date), deptId);
        metier.addProfesseur(professeur);
        System.out.println("Professeur ajoute.");
    }

    private static void listProfesseurs() {
        List<Professeur> professeurs = metier.getAllProfesseurs();
        professeurs.forEach(prof -> System.out.println(prof.toString()));
    }

    private static void searchProfesseurs() {
        System.out.print("Enter keyword: ");
        String keyword = scanner.nextLine();
        List<Professeur> professeurs = metier.searchProfesseurs(keyword);
        professeurs.forEach(prof -> System.out.println(prof.toString()));
    }

    private static void updateProfesseur() {
        System.out.print("Enter professeur ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Entrer nom: ");
        String nom = scanner.nextLine();
        System.out.print("Entrer prenom: ");
        String prenom = scanner.nextLine();
        System.out.print("Entrer CIN: ");
        String cin = scanner.nextLine();
        System.out.print("Entrer adresse: ");
        String adresse = scanner.nextLine();
        System.out.print("Entrer telephone: ");
        String telephone = scanner.nextLine();
        System.out.print("Entrer email: ");
        String email = scanner.nextLine();
        System.out.print("Entrer la date de recrutement(YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Entrer l'ID de departement: ");
        int deptId = scanner.nextInt();

        Professeur professeur = new Professeur(id, nom, prenom, cin, adresse, telephone, email, java.sql.Date.valueOf(date), deptId);
        metier.updateProfesseur(professeur);
        System.out.println("Professeur modifie.");
    }

    private static void deleteProfesseur() {
        System.out.print("Entrer l'ID de professeur a supprimer: ");
        int id = scanner.nextInt();
        metier.removeProfesseur(id);
        System.out.println("Professeur supprime.");
    }

    private static void addDepartement() {
        System.out.print("Entrer le nom de departement: ");
        String nom = scanner.nextLine();
        Departement departement = new Departement(0, nom);
        metier.addDepartement(departement);
        System.out.println("Departement ajoute.");
    }

    private static void listDepartements() {
        List<Departement> departements = metier.getAllDepartements();
        departements.forEach(dept -> System.out.println(dept.toString()));
    }

    private static void professeursByDepartement() {
        System.out.print("Entrer l'ID de departement: ");
        int deptId = scanner.nextInt();
        List<Professeur> professeurs = metier.getProfesseursByDepartement(deptId);
        professeurs.forEach(prof -> System.out.println(prof.toString()));
    }
}