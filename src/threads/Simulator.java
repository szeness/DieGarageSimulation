package threads;

import fahrzeuge.Fahrzeug;
import gui.Gui;

import java.util.Random;

import static parkhaus.Parkhaus.parkhausListe;


public class Simulator extends Thread{

    public int xi;
    public static int chance = 120000;
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
                    sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (!Politesse.timeACtual) {
                    duratSec = new Random().nextInt(10, 60);
                } else {
                    duratSec = new Random().nextInt(3, 18);

                }
                int r = new Random().nextInt(0, Fahrzeug.kfz.size());
                int rP = new Random().nextInt(0, parkhausListe.size());


                parkhausListe.get(rP).parkeFahrzeug(Fahrzeug.kfz.get(r));

                parkhausListe.get(Gui.indexParkhaus).getStatsParkhausTextArea();

                parkhausListe.get(Gui.indexParkhaus).getStatsParkhausTextArea();

             //   new StatsTextArea().run();

            }else{

                xi++;
                if(xi == 195){
                    System.out.println("-");
                    xi=0;
                }else
                    System.out.print("-");


            }
        }

    }
}

