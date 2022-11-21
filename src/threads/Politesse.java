package threads;

import fahrzeuge.Fahrzeug;
import parkhaus.Parkhaus;

import java.time.LocalDateTime;

import static parkhaus.Parkhaus.parkhausListe;

public class Politesse extends Thread {


    public static boolean runzz;
    public static boolean timeACtual;

    public static int rlTimecheck() {

        LocalDateTime date = LocalDateTime.now();
        int nowSec = date.toLocalTime().toSecondOfDay();

        return nowSec;
    }

    public void run() {

        while (!runzz) { try {

            for (int i = 0; i < Fahrzeug.kfz.size(); i++) {

                if (Fahrzeug.kfz.get(i).secToStay <= rlTimecheck())
                {
                    for (Parkhaus p: parkhausListe) {
                        p.entferneFahrzeug(Fahrzeug.kfz.get(i));
                    }

                }
            }

            sleep(1);

            new StatsTextArea().run();
            } catch (InterruptedException e) {throw new RuntimeException(e);}


        }




    /*public Politesse(Parkhaus p) {

        this.phSimulation = p;

    }


        int xi = 0;

        while (!timeFast) {

            if (chanceHumanNeedsAParking(chance)) {
                try {
                    sleep(699);
                    for (int i = 0; i < 1; i++) {
                        if (!timeACtual) {
                            try {
                                sleep(new Random().nextInt(2000, 10000));
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            try {
                                sleep(new Random().nextInt(20, 1000));
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }

                        CarOut co = new CarOut();
                        co.setDaemon(true);

                        int r = new Random().nextInt(0, Fahrzeug.kfz.size() - 1);

                        while (!this.phSimulation.positionFahrzeug(Fahrzeug.kfz.get(r))) {

                            r = new Random().nextInt(0, Fahrzeug.kfz.size() - 1);
                        }


                        co.start();

                        this.phSimulation.entferneFahrzeug(Fahrzeug.kfz.get(r));

                        parkhausListe.get(Gui.indexParkhaus).getStatsParkhausTextArea();
                        new StatsTextArea().run();

                    }

                } catch (IllegalArgumentException e) {


                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }catch (IndexOutOfBoundsException ei){

                }
            } else {

                xi++;
                if(xi == 20){
                    System.out.println("-");
                    xi=0;
                }else
                    System.out.print("-");


                try {
                    sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
*/

    }
}


