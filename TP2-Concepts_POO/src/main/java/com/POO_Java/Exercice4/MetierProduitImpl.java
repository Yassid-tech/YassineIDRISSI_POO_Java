package com.POO_Java.Exercice4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MetierProduitImpl implements IMetierProduit{

    private final List<Produit> produits;

    public MetierProduitImpl() {
        this.produits = new ArrayList<>();
    }

    @Override
    public Produit add(Produit p) {
        // 'produitAjouter' est un boolean
        // qui permet de stocker si le produit a ete ajouter ou non
        boolean prouduitAjouter = produits.add(p);
        if (prouduitAjouter){
            return produits.get(produits.size()-1);
        } else {
            throw new RuntimeException("Echec d'ajout du produit");
        }

    }

    @Override
    public List<Produit> getAll() {
        if(!this.produits.isEmpty()){
            return produits;
        } else{
            System.out.println("La liste des produits est vide, veuillez ajouter un nouveau produit.");
            return null;
        }
    }

    @Override
    public List<Produit> findByNom(String motCle) {
        List<Produit> produitsList = new ArrayList<>();
        for (Produit p:produits){
            if (p.getNom().contains(motCle)){
                produitsList.add(p);
            }
        }
        if (!produitsList.isEmpty()){
            return produitsList;
        } else {
            System.out.println("Aucun produit ne contient ce mot clé.");
            return null;
        }
    }

    @Override
    public Produit findById(long id) {
        Produit produitChercher = null;
        for (Produit p:produits){
            if (p.getId() == id){
                produitChercher=p;
            }
        }

        if (produitChercher != null){
            return produitChercher;
        } else {
            System.out.println("La liste ne contient aucun produit avec cet id.");
            return null;
        }
    }

    @Override
    public void delete(long id) {
        Iterator<Produit> iterator = produits.iterator();
        boolean produitSupprime = false;

        while (iterator.hasNext()) {
            Produit p = iterator.next();
            if (p.getId() == id) {
                iterator.remove();
                produitSupprime = true;
                System.out.println("Produit avec ID " + id + " supprimé avec succès.");
                break;
            }
        }

        if (!produitSupprime) {
            System.out.println("Aucun produit trouvé avec l'ID " + id);
        }
    }
}
