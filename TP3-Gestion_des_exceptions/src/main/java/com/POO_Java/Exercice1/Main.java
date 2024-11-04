package com.POO_Java.Exercice1;

public class Main {
    public static void main(String[] args) {
        Vehicule vehicule = new Vehicule();
        try {
            vehicule.testVitesse(90);
            vehicule.testVitesse(120);
        } catch (TropViteException e){
            System.out.println(e.getMessage());
        }
    }
}