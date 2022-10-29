package threads;

import fahrzeuge.Fahrzeug;
import gui.Gui;
import parkhaus.Parkhaus;
import java.util.Random;

import static parkhaus.Parkhaus.parkhausListe;


public class EinparkSimulator extends Thread{

    public int xi;
    public static int chance = 50;

    Parkhaus phSimulation;

    public EinparkSimulator(Parkhaus p) {

        this.phSimulation = p;
    }

    public static boolean chanceHumanNeedsAParking(int c){

        if(new Random().nextInt(1,c) == 1)
            return true;

    return false;
    }


    public void run() throws IllegalArgumentException {


        while (!AusparkSimulator.timeFast) {


            if (chanceHumanNeedsAParking(chance)) {
                try {
                    for (int i = 0; i < 1; i++) {
                        if (!AusparkSimulator.timeACtual) {
                            try {

                                Thread.sleep(new Random().nextInt(1500, 9000));
                            } catch (InterruptedException e) {
                            }

                        } else {
                            try {
                                sleep(new Random().nextInt(15, 900));
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                        int r;

                        r = new Random().nextInt(0, Fahrzeug.kfz.size());


                        this.phSimulation.parkeFahrzeug(Fahrzeug.kfz.get(r));

                        parkhausListe.get(Gui.indexParkhaus).getStatsParkhausTextArea();

                    }

                } catch (IllegalArgumentException e) {
                }catch (IndexOutOfBoundsException e) {}
            }else{
                 xi++;
                    if(xi == 20){
                        System.out.println("-");
                        xi=0;
                    }else
                        System.out.print("-");


                try {
                    sleep(20);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}

