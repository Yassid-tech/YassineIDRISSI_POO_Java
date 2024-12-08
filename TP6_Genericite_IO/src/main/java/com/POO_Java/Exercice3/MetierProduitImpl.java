package com.POO_Java.Exercice3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit>{

    private List<Produit> produits = new ArrayList<>();
    private final String fileName;

    public MetierProduitImpl(String fileName) {
        this.fileName = fileName;
        this.produits = getAll();
    }

    @Override
    public Produit add(Produit produit) {
        produits.add(produit);
        return produit;
    }

    @Override
    public List<Produit> getAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Produit>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Produit findByNom(String nom) {
        return produits.stream()
                .filter(p -> p.getNom().equalsIgnoreCase(nom))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(String nom) {
        produits.removeIf(p -> p.getNom().equalsIgnoreCase(nom));
    }

    @Override
    public void saveAll() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(produits);
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des produits.");
        }
    }
}
