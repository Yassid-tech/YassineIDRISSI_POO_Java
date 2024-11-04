package com.POO_Java.Exercice3;

import com.POO_Java.Exercice2.Calculateur;
import com.POO_Java.Exercice2.RacineCarreeException;

public class Evaluateur {

    public Evaluateur() {
    }

    public void verifierNote(int note) throws NoteInvalideException {
        if (note<0 || note>20) throw new NoteInvalideException(note);
    }

    public static void main(String[] args) {
        Evaluateur evaluateur = new Evaluateur();
        try {
            evaluateur.verifierNote(25);
            evaluateur.verifierNote(15);
        } catch (NoteInvalideException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Sortie du programme");
    }
}
