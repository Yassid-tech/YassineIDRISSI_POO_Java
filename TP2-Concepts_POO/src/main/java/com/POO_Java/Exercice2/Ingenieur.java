package com.POO_Java.Exercice2;

public class Ingenieur extends Employe{

    private String specialite;

    public Ingenieur(String nom, String prenom, String email, String tel, double salaire, String specialite) {
        super(nom, prenom, email, tel, salaire);
        this.specialite = specialite;
    }

    public String getSpecialite() {
        return specialite;
    }

    @Override
    public double calculerSalaire() {
        return getSalaire() * 1.15;
    }

    @Override
    public void afficherInfo() {
        super.afficherInfo();
        System.out.println("Specialite: " + specialite);
    }
}
