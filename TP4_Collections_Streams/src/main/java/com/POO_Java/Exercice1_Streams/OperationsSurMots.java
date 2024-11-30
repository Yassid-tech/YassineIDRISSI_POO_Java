package com.POO_Java.Exercice1_Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OperationsSurMots {
    public static void main(String[] args) {
        List<String> listeMots = new ArrayList<>();

        // Ajout des mots
        listeMots.add("Etudiant");
        listeMots.add("Universite");
        listeMots.add("Professeur");
        listeMots.add("Ecole");
        listeMots.add("Master");
        listeMots.add("SDIA");

        //Filtrer les mots qui contiennent la lettre "a"
        List<String> motsAvecA = listeMots.stream()
                .filter(mot -> mot.contains("a"))
                .collect(Collectors.toList());
        System.out.println("Mots contenant 'a' : " + motsAvecA);

        // Filtrer les mots qui ont une longueur supérieure à 3 et transformer chaque mot en son
        //inverse.
        System.out.println("Filtrer les mots qui ont une longueur supérieure à 3" +
                " et transformer chaque mot en son inverse.");
        List<String> listeInverse = listeMots.stream()
                .filter(mot-> mot.length()>3)
                .map(mot-> reverse(mot))
                .collect(Collectors.toList());
        System.out.println("Mots inversés : " + listeInverse);

        // Filtrer les chaînes qui contiennent la lettre "e" et
        // aplatir chaque chaîne en une liste de ses caractères
        List<List<Character>> listesDeCaracteresAvecE = listeMots.stream()
                .filter(mot -> mot.contains("e"))
                .map(mot -> mot.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
        System.out.println("Caractères des mots contenant 'e' : " + listesDeCaracteresAvecE);


        // Transformer chaque chaîne en sa version en majuscules.
        List<String> upperCaseList = listeMots.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Liste des mots en majuscules: " + upperCaseList);


        // Convertir chaque chaîne en sa longueur
        List<Integer> longueursDesMots = listeMots.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("Longueur de chaque mot : " + longueursDesMots);


        // Transformer chaque chaîne en une liste de ses caractères,
        // puis aplatir toutes les listes en une seule liste de caractères
        List<Character> tousLesCaracteres = listeMots.stream()
                .flatMap(mot -> mot.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toList());
        System.out.println("Tous les caractères aplatis : " + tousLesCaracteres);


        // À partir d'une liste de mots, transformer chaque nom en une chaîne
        // de la forme "Nom - Index" où l'index représente la position du nom dans la liste
        List<String> motsAvecIndex = IntStream.range(0, listeMots.size())
                .mapToObj(i -> listeMots.get(i) + " - " + i)
                .collect(Collectors.toList());
        System.out.println("Mots avec leur index : " + motsAvecIndex);

    }

    public static String reverse(String chaine){
        char ch;
        String rchaine="";

        for (int i=0; i<chaine.length(); i++)
        {
            ch= chaine.charAt(i);
            rchaine= ch + rchaine;
        }
        return rchaine;
    }
}