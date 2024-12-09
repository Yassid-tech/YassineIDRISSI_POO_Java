package com.POO_Java.Exercice2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DossierContact {
    // Répertoire où les contacts sont stockés
    private final File directory;

    // Map pour stocker les contacts en mémoire
    private final Map<String, String> contacts;

    public DossierContact(String directoryPath) {
        this.directory = new File(directoryPath);
        this.contacts = new HashMap<>();

        // Charger les contacts depuis le répertoire
        loadContacts();
    }


    private void loadContacts() {
        if (!directory.exists()) {
            // Créer le répertoire si nécessaire
            directory.mkdirs();

        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String name = file.getName();
                    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                        String number = br.readLine();
                        contacts.put(name, number);
                    } catch (IOException e) {
                        System.out.println("Erreur lors du chargement du contact : " + name);
                    }
                }
            }
        }
    }


    private void saveContactToFile(String name, String number) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(directory, name)))) {
            bw.write(number);
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde du contact : " + name);
        }
    }


    private void deleteContactFile(String name) {
        File file = new File(directory, name);
        if (!file.delete()) {
            System.out.println("Erreur lors de la suppression du fichier du contact : " + name);
        }
    }


    public void addContact(String name, String number) {
        contacts.put(name, number);
        saveContactToFile(name, number);
    }


    public void removeContact(String name) {
        if (contacts.remove(name) != null) {
            deleteContactFile(name);
        } else {
            System.out.println("Le contact n'existe pas.");
        }
    }


    public String searchContact(String name) {
        return contacts.get(name);
    }


    public void updateContact(String name, String newNumber) {
        if (contacts.containsKey(name)) {
            contacts.put(name, newNumber);
            saveContactToFile(name, newNumber);
        } else {
            System.out.println("Le contact n'existe pas.");
        }
    }
}
