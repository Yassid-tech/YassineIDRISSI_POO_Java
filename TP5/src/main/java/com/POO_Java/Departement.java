package com.POO_Java;

public class Departement {
    private int idDeprat;
    private String nom;

    public Departement(int idDeprat, String nom) {
        this.idDeprat = idDeprat;
        this.nom = nom;
    }

    public int getIdDeprat() {
        return idDeprat;
    }

    public void setIdDeprat(int idDeprat) {
        this.idDeprat = idDeprat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "idDeprat=" + idDeprat +
                ", nom='" + nom + '\'' +
                '}';
    }
}
