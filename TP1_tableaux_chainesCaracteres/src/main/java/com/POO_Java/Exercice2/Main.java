package com.POO_Java.Exercice2;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez un verbe du premier groupe: ");
        String verbe = scanner.nextLine();
        Conjugaison conjugaison = new Conjugaison(verbe);
        String[] verbeConjuguer = conjugaison.conjuguerAuPresent();
        for(String str:verbeConjuguer){
            System.out.println(str);
        }

        scanner.close();
    }
}