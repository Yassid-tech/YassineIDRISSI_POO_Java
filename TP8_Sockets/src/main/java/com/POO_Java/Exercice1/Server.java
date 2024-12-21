package com.POO_Java.Exercice1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 9191;
        int magicNumber = (int) (Math.random() * 101);

        System.out.println("Le serveur écoute sur le port " + port);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                System.out.println("En attente d'un joueur...");

                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(
                             clientSocket.getOutputStream(), true)) {

                    System.out.println("Un joueur s'est connecté.");
                    out.println("Bienvenue dans le jeu !" +
                            " Devinez le nombre magique entre 0 et 100.");

                    String inputLine;
                    boolean gameWon = false;

                    while (!gameWon && (inputLine = in.readLine()) != null) {
                        try {
                            int guess = Integer.parseInt(inputLine);
                            if (guess < magicNumber) {
                                out.println("Trop petit ! Essayez encore.");
                            } else if (guess > magicNumber) {
                                out.println("Trop grand ! Essayez encore.");
                            } else {
                                out.println("Félicitations ! Vous avez trouvé le nombre magique !");
                                System.out.println("Le joueur a trouvé le nombre magique !");
                                gameWon = true;
                            }
                        } catch (NumberFormatException e) {
                            out.println("Veuillez entrer un nombre valide.");
                        }
                    }

                    System.out.println("Le joueur a quitté la partie.");
                } catch (IOException e) {
                    System.out.println("Erreur avec le client : " + e.getMessage());
                }

                System.out.println("Prêt pour un nouveau joueur...");
                magicNumber = (int) (Math.random() * 101);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}