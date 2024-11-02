package com.POO_Java.Exercice2;

public abstract class Employe {
    private String nom;
    private String prenom;
    private String email;
    private String tel;
    private double salaire;

    public Employe(String nom, String prenom, String email, String tel, double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.salaire = salaire;
    }
    public Employe() {
    }
    public abstract double calculerSalaire();

    public void afficherInfo() {
        System.out.println("Nom: " + nom);
        System.out.println("Prenom: " + prenom);
        System.out.println("Salaire: " + calculerSalaire());
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getEmail() {
        return email;
    }
    public String getTel() {
        return tel;
    }
    public double getSalaire() {
        return salaire;
    }
}
