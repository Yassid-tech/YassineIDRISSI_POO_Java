package com.POO_Java.Exercice2;

import java.lang.reflect.Array;

public class Sommeur implements Runnable{

    private final int[] entiers;
    private final int debut;
    private final int fin;
    private int somme = 0;

    public Sommeur(int[] entiers, int debut, int fin) {
        this.entiers = entiers;
        this.debut = debut;
        this.fin = fin;
    }

    @Override
    public void run() {
        for (int i = debut; i < fin; i++) {
            somme += entiers[i];
        }
    }

    public int getSomme() {
        return somme;
    }
}
