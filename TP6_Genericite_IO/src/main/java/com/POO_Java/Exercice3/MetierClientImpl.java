package com.POO_Java.Exercice3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierClientImpl implements IMetier<Client>{
    private List<Client> clients = new ArrayList<>();
    private final String fileName;

    public MetierClientImpl(String fileName) {
        this.fileName = fileName;
        this.clients = getAll();
    }

    @Override
    public Client add(Client client) {
        clients.add(client);
        return client;
    }

    @Override
    public List<Client> getAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Client>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Client findByNom(String nom) {
        return clients.stream()
                .filter(c -> c.getNom().equalsIgnoreCase(nom))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(String nom) {
        clients.removeIf(c -> c.getNom().equalsIgnoreCase(nom));
    }

    @Override
    public void saveAll() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(clients);
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des clients.");
        }
    }
}
