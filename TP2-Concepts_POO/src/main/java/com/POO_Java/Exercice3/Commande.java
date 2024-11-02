package com.POO_Java.Exercice3;

import java.util.Date;

public class Commande {

    private String reference;
    private Client client;
    private Date date;
    private String etatCommande;

    public Commande(String reference, Client client, Date date, String etatCommande) {
        this.reference = reference;
        this.client = client;
        this.date = date;
        this.etatCommande = etatCommande;
    }
    public String getReference() {
        return reference;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getEtatCommande() {
        return etatCommande;
    }
    public void setEtatCommande(String etatCommande) {
        this.etatCommande = etatCommande;
    }


    @Override
    public String toString() {
        return "Commande{" +
                "reference='" + reference + '\'' +
                ", client='" + client.getNom() + " " + client.getPrenom() + '\'' +
                ", date=" + date +
                ", etatCommande='" + etatCommande + '\'' +
                '}';
    }
}
