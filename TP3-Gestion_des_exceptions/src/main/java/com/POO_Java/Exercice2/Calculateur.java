package com.POO_Java.Exercice2;

import com.POO_Java.Exercice1.TropViteException;
import com.POO_Java.Exercice1.Vehicule;

public class Calculateur {
    public Calculateur() {
    }

    public void testRacineCarree(int nombre) throws RacineCarreeException {
        if (nombre < 0) throw new RacineCarreeException(nombre);
    }

    public static void main(String[] args) {
        Calculateur calculateur = new Calculateur();
        try {
            calculateur.testRacineCarree(25);
            calculateur.testRacineCarree(-5);
        } catch (RacineCarreeException e){
            System.out.println(e.getMessage());
        }
    }
}
