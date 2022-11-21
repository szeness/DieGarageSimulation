package threads;

import fahrzeuge.Fahrzeug;
import gui.Gui;

import java.util.Random;

import static parkhaus.Parkhaus.parkhausListe;


public class Simulator extends Thread{

    public int xi;
    public static int chance = 90000;
    public static int duratSec;


    public static boolean chanceHumanNeedsAParking(int c){

        if(new Random().nextInt(1,c) == 1)
            return true;

     return false;
    }

    public void run() throws IllegalArgumentException {

        while (!Politesse.runzz) {
            if (chanceHumanNeedsAParking(chance)) {
                try {


                if (!Politesse.timeACtual) {
                    duratSec = new Random().nextInt(10, 60);
                    sleep(100);
                } else {
                    duratSec = new Random().nextInt(2, 15);
                    sleep(20);
                }
                int r = new Random().nextInt(0, Fahrzeug.kfz.size());
                int rP = new Random().nextInt(0, parkhausListe.size());


                parkhausListe.get(rP).parkeFahrzeug(Fahrzeug.kfz.get(r));

                parkhausListe.get(Gui.indexParkhaus).getStatsParkhausTextArea();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }

    }
}

