package com.POO_Java.Exercice1;

public class TropViteException extends Exception{

    public TropViteException(int message) {
        super("C'est une exception de type TropViteException. Vitesse en cause : " + message);
    }
}
