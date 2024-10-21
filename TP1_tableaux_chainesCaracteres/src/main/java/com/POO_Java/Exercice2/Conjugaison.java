package com.POO_Java.Exercice2;

public class Conjugaison {

    private String verbe;

    public Conjugaison(String verbe) {
        this.verbe = verbe;
    }

    public String[] conjuguerAuPresent(){
        String[] pronoms = {"je", "tu", "il", "nous", "vous", "ils"};
        String[] terminaisons = {"e", "es", "e", "ons", "ez", "ent"};
        // cet indice permet d'identifier la position de la terminaison "er",
        // si il retourne -1 donc la terminaison est introuvable
        int index = verbe.lastIndexOf("er");

        String[] verbeConjugue = new String[pronoms.length];

        if (index != -1){
            // extraire le radical du verbe
            String radical =verbe.substring(0,index);
            for (int i=0; i< verbeConjugue.length; i++){
                verbeConjugue[i]=pronoms[i] + " " + radical + terminaisons[i];
            }
        } else {
            return new String[]{"Le verbe saisie n'est pas du premier groupe"};
        }


        return verbeConjugue;
    }
}
