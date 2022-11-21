package main;

import fahrzeuge.Fahrzeug;
import threads.CarIn;
import gui.Gui;
import parkhaus.Parkhaus;
import threads.Politesse;
import threads.Simulator;

import java.util.Arrays;

import static parkhaus.Parkhaus.*;

public class Main {

    public static void main(String...args) {


        new Gui().run();

    }




    public static void starteSimulation() {


        CarIn ci = new CarIn();
        ci.setDaemon(true);
        ci.start();

        new Simulator().setDaemon(true);
        new Simulator().start();
        new Politesse().setDaemon(true);
        new Politesse().start();


    }

    public static void dummyParkhausEroeffnung(int stück) {


        parkhausListe.clear();
        Gui.parkhausDropList.removeAllItems();
        Gui.indexParkhaus = 0;

        if(Gui.checkMains.isSelected()) {
            new Parkhaus("citylot", 3, 40);
            s2ph("citylot").baueAufEtage(0, 15);

            new Parkhaus("parkmatt", 2, 15);
            new Parkhaus("parkorama", 2, 10);
            new Parkhaus("justpark", 2, 20);
            new Parkhaus("mopark", 3, 20);
            new Parkhaus("ofthelots", 2, 15);
            new Parkhaus("Puidling", 2, 35);
        }

        for (int i = 0; i < stück; i++) {
            new Parkhaus("DummyP" + i, 3, 20);
        }
    }

    public static void  registriereKfz(int stück){

        Fahrzeug.kfz.clear();
        Fahrzeug.fahrzeugRegister.clear();


        for (Parkhaus p : parkhausListe) {

            for (int i = 0; i < p.parkhaus.length; i++) {
                Arrays.fill(p.parkhaus[i], null);
            }
            p.parkplatzCounter();
            p.getStatsParkhausTextArea();
            p.belegteParkplaetze = 0;
        }

        for (int i = 0; i < stück; i++) {

            Fahrzeug.kfzEintragung(true, "K:SL " + (i), "Auto");
        }

    }

}
