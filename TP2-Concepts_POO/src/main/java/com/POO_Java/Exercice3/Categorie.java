package com.POO_Java.Exercice3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Categorie {

    private String nom;
    private String description;
    private List<Ordinateur> ordinateurList;

    public Categorie(String nom, String description) {
        this.nom = nom;
        this.description = description;
        this.ordinateurList = new ArrayList<>();
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Ordinateur> getOrdinateurList() {
        return ordinateurList;
    }
    public void setOrdinateurList(List<Ordinateur> ordinateurList) {
        this.ordinateurList = ordinateurList;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", ordinateurList=" + ordinateurList +
                '}';
    }

    public void ajouterOrdinateur(Ordinateur ordinateur){
        boolean existe=false;
        for (Ordinateur ord:ordinateurList){
            if (Objects.equals(ordinateur.getNom(), ord.getNom())) {
                existe = true;
                break;
            }
        }
        if (!existe){
            ordinateurList.add(ordinateur);
        } else {
            System.out.println("L'ordinateur que vous voulez ajouter existe deja");
        }
    }
    public void supprimerOrdinateur(String nom){
        int index = -1;
        for (Ordinateur ordinateur:ordinateurList){
            if (Objects.equals(ordinateur.getNom(), nom)){
                index = ordinateurList.indexOf(ordinateur);
                break;
            }
        }
        if (index != -1){
            ordinateurList.remove(index);
        }else {
            System.out.println("L'ordinateur que vous voulez supprimer n'existe pas dans la liste");
        }
    }
    public List<Ordinateur> rechercherParPrix(float prix){
        List<Ordinateur> ordinateursRechercher = new ArrayList<>();
        for (Ordinateur ordinateur:ordinateurList){
            if (ordinateur.getPrix() <= prix){
                ordinateursRechercher.add(ordinateur);
            }
        }
        if (!ordinateursRechercher.isEmpty()){
            return ordinateursRechercher;
        } else {
            System.out.println("Il n'y a aucun ordinateur avec ce prix");
            return null;
        }
    }
}
