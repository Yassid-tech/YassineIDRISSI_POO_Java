package com.POO_Java.Exercice1;

public class Talkative implements Runnable{

    private final int num;

    public Talkative(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.println(num);
        }
    }
}
