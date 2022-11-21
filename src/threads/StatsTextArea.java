package threads;

import fahrzeuge.Fahrzeug;
import gui.Gui;
import parkhaus.Parkhaus;

import static parkhaus.Parkhaus.parkhausListe;

public class StatsTextArea extends Thread {


    public int allSlots;
    public int usedSlots;
    public int freeSlots;

    public void run() {

        allSlots = 0;
        usedSlots = 0;


        for (Parkhaus p : parkhausListe) {

            allSlots += p.parkplatzZaehlung;
            usedSlots += p.belegteParkplaetze;
        }
        freeSlots = allSlots-usedSlots;

        int percentage =  ((usedSlots * 100) / allSlots);

        Gui.textAreaZeit1.setText("Slots: "+allSlots+"\nCars("+Fahrzeug.kfz.size()+")\nparking: "+usedSlots+"\n" +
                percentage + "%" );
        Gui.textAreaZeit1.setVisible(false);
        Gui.textAreaZeit1.setVisible(true);




    }



}
