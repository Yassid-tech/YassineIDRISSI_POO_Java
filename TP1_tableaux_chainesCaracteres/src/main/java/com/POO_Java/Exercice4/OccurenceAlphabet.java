package com.POO_Java.Exercice4;


public class OccurenceAlphabet {
    private String ch;
    public OccurenceAlphabet(String ch) {
        this.ch = ch;
    }
    public void calculerOccurencesLettres() {
        ch = ch.toLowerCase();
        // Créer un tableau pour mémoriser les occurrences des lettres (26 lettres de l'alphabet)
        int[] nb_occurrences = new int[26];
        // Parcourir chaque caractère de la chaîne
        for (int i = 0; i < ch.length(); i++) {
            char caractere = ch.charAt(i);
            // Vérifier si le caractère est une lettre (entre 'a' et 'z')
            if (caractere >= 'a' && caractere <= 'z') {
                // Calculer l'indice correspondant dans le tableau (0 pour 'a', 1 pour 'b', etc.)
                int index = caractere - 'a';
                // Incrémenter le compteur d'occurrences pour cette lettre
                nb_occurrences[index]++;
            }
        }
        System.out.println("La chaîne \"" + ch + "\" contient :");
        // Parcourir le tableau pour afficher les lettres qui apparaissent au moins une fois
        for (int i = 0; i < nb_occurrences.length; i++) {
            if (nb_occurrences[i] > 0) {
                // Convertir l'indice en lettre correspondante (par ex. 0 -> 'a')
                char lettre = (char) (i + 'a');
                // Afficher le nombre d'occurrences
                System.out.println(nb_occurrences[i] + " fois la lettre '"
                        + Character.toUpperCase(lettre) + "'");
            }
        }
    }
}
