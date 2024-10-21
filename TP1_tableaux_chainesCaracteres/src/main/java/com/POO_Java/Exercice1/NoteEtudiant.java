package com.POO_Java.Exercice1;

import java.util.ArrayList;
import java.util.Arrays;

public class NoteEtudiant {

    private float[] notes;
    private int currentSize = 0;

    public NoteEtudiant(int size) {
        notes = new float[size];
    }

    public float[] getNotes() {
        return notes;
    }

    // Ajouter une note au tableau
    public void ajouterNote(float note) {
        if (currentSize < notes.length) {
            notes[currentSize] = note;  // Add the note to the array
            currentSize++;  // Increment the size counter
        } else {
            System.out.println("La liste est pleine, vous ne pouvez plus ajouter de notes.");
        }
    }

    //Trier et Afficher la liste des notes
    public void trierListe(){
        Arrays.sort(notes);
        System.out.println("Notes apres tri: " + Arrays.toString(notes));
    }


    // Calculer la moyenne
    public float calculerMoyenne() {
        float sommeNotes = 0;
        float moyenne;
        for (float note : notes) {
            sommeNotes += note;
        }
        moyenne = sommeNotes/notes.length;
        return moyenne;
    }


    // Calculer le max et min
    public void maxEtMinNotes(){
        float max,min;
        max = notes[0];
        min = notes[0];
        for (float note : notes) {
            max = Math.max(max, note); // ou max = (max<note) ? note : max
            min = Math.min(min, note); // ou min = (min>note) ? note : min
        }
        System.out.println("La note maximale est: " + max);
        System.out.println("La note minimale est: " + min);
    }



    // Trouver l'occurence d'une note
    public int occurenceNote(float noteChercher){
        int compteur = 0;
        for (float note : notes) {
            compteur = (note==noteChercher)? compteur+1 : compteur;
        }
        return compteur;
    }

}
