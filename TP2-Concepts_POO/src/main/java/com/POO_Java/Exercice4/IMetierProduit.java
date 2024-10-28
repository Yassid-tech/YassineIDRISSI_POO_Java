package com.POO_Java.Exercice4;

import java.util.List;

public interface IMetierProduit {

    // cette methode nous permet d'ajouter un produit à la liste.
    public Produit add(Produit p);

    // La methode suivante permet de retourner les produits sous forme d'une liste.
    public List<Produit> getAll();

    // Permet de retourner une liste de produits,
    // dont le nom contient le mot clé passé en paramètre.
    public List<Produit> findByNom(String motCle);

    // cette methode permet de retourner un produit par son id.
    public Produit findById(long id);

    // la methode "delete(id)" permet de supprimer un produit en utilisant son id.
    public void delete(long id);


}
