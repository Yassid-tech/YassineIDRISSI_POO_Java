package com.POO_Java.Exercice3;

import java.io.Serializable;

public class Produit implements Serializable {
    private String nom;
    private String marque;
    private double prix;
    private String description;
    private int nombreEnStock;

    public Produit(String nom, String marque, double prix, String description, int nombreEnStock) {
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nombreEnStock = nombreEnStock;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return String.format("Produit[nom=%s, marque=%s, prix=%.2f, description=%s, stock=%d]",
                nom, marque, prix, description, nombreEnStock);
    }
}
