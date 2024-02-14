package com.astier;

import jssc.SerialPortException;

import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        Application ap=new Application();
        
        ap.listerLesPorts().forEach(leCom-> System.out.println(leCom));

        try {
            ap.initialisation("com3");
        } catch (SerialPortException e) {
            System.out.println("port non disponible");;
        }
        while (true){
            System.out.println("votre message:");
            ap.ecrire(In.readString().getBytes(StandardCharsets.UTF_8));
            ap.ecrire("\n".getBytes());
        }
    }
}


