package com.POO_Java.Exercice3_Collections;

import java.util.HashSet;

public class GestionEtudiants {

    public static void main(String[] args){
        HashSet<String> groupeA = new HashSet<>();
        HashSet<String> groupeB = new HashSet<>();


        // Ajouter les noms des etudiants
        //---------Groupe A-------------
        groupeA.add("Etudiant_1");
        groupeA.add("Etudiant_2");
        groupeA.add("Etudiant_3");
        groupeA.add("Etudiant_4");

        //---------Groupe B-------------
        groupeB.add("Etudiant_5");
        groupeB.add("Etudiant_6");
        groupeB.add("Etudiant_7");
        groupeB.add("Etudiant_8");


        // Intersection des deux HashSets
        HashSet<String> intersection = new HashSet<>(groupeA);

        intersection.retainAll(groupeB);
        System.out.println("Groupe A: " + groupeA);
        System.out.println("Groupe B: " + groupeB);
        System.out.println("Intersection: " + intersection);


        // Union des deux HashSets
        HashSet<String> union = new HashSet<>(groupeA);
        union.addAll(groupeB);
        System.out.println("Groupe A: " + groupeA);
        System.out.println("Groupe B: " + groupeB);
        System.out.println("Union: " + union);
    }

}
