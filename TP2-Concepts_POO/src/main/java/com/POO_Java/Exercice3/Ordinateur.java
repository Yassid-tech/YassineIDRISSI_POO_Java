package com.POO_Java.Exercice3;

public class Ordinateur {

    private String nom;
    private String marque;
    private double prix;
    private String description;
    private int nbrStock;

    public Ordinateur(String nom, String marque, double prix, String description, int nbrStock) {
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nbrStock = nbrStock;
    }

    public void setNbrStock(int nbrStock) {
        this.nbrStock = nbrStock;
    }
    public String getNom() {
        return nom;
    }
    public String getMarque() {
        return marque;
    }
    public double getPrix() {
        return prix;
    }
    public String getDescription() {
        return description;
    }
    public int getNbrStock() {
        return nbrStock;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Ordinateur{" +
                "nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", nbrStock=" + nbrStock +
                '}';
    }
}
