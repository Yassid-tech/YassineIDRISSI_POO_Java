package com.POO_Java.Exercice3;

public class StringManupulator {

    private final String chaine;

    public StringManupulator(String chaine){
        this.chaine = chaine;
    }

    public String getChaine() {
        return chaine;
    }

    public String inverserChaine(){
        String chaineInverse="";
        for(int i=0; i<chaine.length(); i++){
            chaineInverse = chaine.charAt(i) + chaineInverse;
        }
        return chaineInverse;
    }

    public int calculerNombreMots(){
        String regex = "[,\\.\\s]+";
        String[] listeDesMots = chaine.split(regex);
        int longeur = listeDesMots.length;
        return  longeur;
    }
}
