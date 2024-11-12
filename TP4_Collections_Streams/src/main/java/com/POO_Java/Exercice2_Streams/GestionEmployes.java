package com.POO_Java.Exercice2_Streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GestionEmployes {

    public static void main(String[] args) {
        ArrayList<Employe> employes = new ArrayList<Employe>();

        // Instanciation des emplyes
        Employe employe1 = new Employe("Yassine", "IT", 15000);
        Employe employe2 = new Employe("Soufiane", "IT", 6900);
        Employe employe3 = new Employe("Kaoutar", "RH", 12000);
        Employe employe4 = new Employe("Imane", "Finance", 9000);

        // Insertion dans la liste
        employes.add(employe1);
        employes.add(employe2);
        employes.add(employe3);
        employes.add(employe4);

        // Calculer la somme totale des salaires de tous les employés
        double sommeSalaires = employes.stream()
                .mapToDouble(Employe::getSalaire)
                .sum();
        System.out.println("Somme totale des salaires : " + sommeSalaires);


        // Trier la liste des employés par ordre alphabétique du nom
        ArrayList<Employe> listeTrier = employes.stream()
                .sorted(Comparator.comparing(Employe::getNom))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Employés triés par nom : " + listeTrier);

        // Trouver l'employé avec le salaire le plus bas
        Optional<Employe> employeMoinsPaye = employes.stream()
                .min(Comparator.comparingDouble(Employe::getSalaire));
        System.out.println(employeMoinsPaye);

        // Liste des employés ayant un salaire supérieur à une valeur donnée
        double seuil = 9000;
        ArrayList<Employe> employesSalaireSuperieur = employes.stream()
                .filter(employe -> employe.getSalaire()>seuil)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Employés avec un salaire supérieur à " + seuil + " : " + employesSalaireSuperieur);


        // Employé avec le salaire le plus élevé dans l'ensemble de l'entreprise
        Optional<Employe> employeSalaireMax = employes.stream()
                .reduce((emp1,emp2)-> emp1.getSalaire()>emp2.getSalaire()?emp1:emp2);
        System.out.println("Employé avec le salaire le plus élevé : " + employeSalaireMax);


        // Concaténer les noms de tous les employés
        String nomsConcatenes = employes.stream()
                .map(Employe::getNom)
                .reduce((nom1, nom2) -> nom1 + ", " + nom2)
                .orElse("");
        System.out.println("Noms concaténés de tous les employés : " + nomsConcatenes);
    }
}
