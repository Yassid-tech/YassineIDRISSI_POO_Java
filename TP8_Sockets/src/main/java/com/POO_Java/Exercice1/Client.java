package com.POO_Java.Exercice1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 9191;

        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(
                     socket.getOutputStream(), true);
             BufferedReader userInput = new BufferedReader(
                     new InputStreamReader(System.in))) {

            System.out.println("Connecté au serveur du jeu !");
            String serverMessage;

            while ((serverMessage = in.readLine()) != null) {
                System.out.println("Serveur: " + serverMessage);

                if (serverMessage.contains("Félicitations")) {
                    break;
                }

                System.out.print("Votre réponse: ");
                String userGuess = userInput.readLine();
                out.println(userGuess);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
