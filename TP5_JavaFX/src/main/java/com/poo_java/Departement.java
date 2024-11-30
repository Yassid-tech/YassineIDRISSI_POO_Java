package com.poo_java;

public class Departement {
    private int idDepart;
    private String nomDepart;

    public Departement(int idDepart, String nomDepart) {
        this.idDepart = idDepart;
        this.nomDepart = nomDepart;
    }
    public Departement(){}

    public int getIdDepart() {
        return idDepart;
    }

    public void setIdDepart(int idDepart) {
        this.idDepart = idDepart;
    }

    public String getNomDepart() {
        return nomDepart;
    }

    public void setNomDepart(String nomDepart) {
        this.nomDepart = nomDepart;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "idDepart=" + idDepart +
                ", nomDepart='" + nomDepart + '\'' +
                '}';
    }
}
