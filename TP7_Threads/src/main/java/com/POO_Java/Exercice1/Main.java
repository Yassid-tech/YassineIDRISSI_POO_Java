package com.POO_Java.Exercice1;

public class Main {
    public static void main(String[] args) {

        Thread th1 = new Thread(new Talkative(1));
        Thread th2 = new Thread(new Talkative(2));
        Thread th3 = new Thread(new Talkative(3));
        Thread th4 = new Thread(new Talkative(4));
        Thread th5 = new Thread(new Talkative(5));
        Thread th6 = new Thread(new Talkative(6));
        Thread th7 = new Thread(new Talkative(7));
        Thread th8 = new Thread(new Talkative(8));
        Thread th9 = new Thread(new Talkative(9));
        Thread th10 = new Thread(new Talkative(10));


        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        th6.start();
        th7.start();
        th8.start();
        th9.start();
        th10.start();
        System.out.println("Fin du programme");

    }
}