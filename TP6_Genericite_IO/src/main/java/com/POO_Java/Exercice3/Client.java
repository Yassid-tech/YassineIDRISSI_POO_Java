package com.POO_Java.Exercice3;

import java.io.Serializable;

public class Client implements Serializable {
    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private String email;

    public Client(String nom, String prenom, String adresse, String tel, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return String.format("Client[nom=%s, prenom=%s, adresse=%s, tel=%s, email=%s]",
                nom, prenom, adresse, tel, email);
    }
}
