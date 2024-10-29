package com.POO_Java.Exercice2;

public class Manager extends Employe{

    private String service;

    public Manager(String nom, String prenom, String email, String tel, double salaire, String service) {
        super(nom, prenom, email, tel, salaire);
        this.service = service;
    }


    public String getService() {
        return service;
    }

    @Override
    public double calculerSalaire() {
        return getSalaire() * 1.20;
    }

    @Override
    public void afficherInfo() {
        super.afficherInfo();
        System.out.println("Service: " + service);
    }
}
