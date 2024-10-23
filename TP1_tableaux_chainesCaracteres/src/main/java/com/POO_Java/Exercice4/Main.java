package com.POO_Java.Exercice4;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez une ligne de texte (max. 100 caractères) : ");
        String ch = scanner.nextLine();
        OccurenceAlphabet occurenceAlphabet = new OccurenceAlphabet(ch);
        occurenceAlphabet.calculerOccurencesLettres();

        scanner.close();

    }
}