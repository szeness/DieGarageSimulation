package parkhaus;

import fahrzeuge.Fahrzeug;
import gui.Gui;
import java.util.ArrayList;
import java.util.Objects;

public class Parkhaus {


    public int anzahlParkplaetze;
    public int anzahlEtagen;
    public int belegteParkplaetze;
    public int parkplatzZaehlung;
    public Fahrzeug gesuchtes;
    public String name;
    public Fahrzeug[][] parkhaus;
    public static ArrayList<Parkhaus> parkhausListe = new ArrayList<>();

    public Parkhaus() {

    }

    public Parkhaus(String Name, int Etagen, int Parkplaetze){

        this.anzahlEtagen = Etagen;
        this.anzahlParkplaetze = Parkplaetze;
        this.name = Name;
        this.parkhaus = new Fahrzeug[this.anzahlEtagen][this.anzahlParkplaetze];


        parkhausListe.add(this);
        Gui.parkhausDropList.addItem(this);

        this.parkplatzCounter();

    }



    public void baueAufEtage(int etage, int parkPlaetze){

        this.parkhaus[etage] = new Fahrzeug[parkPlaetze];

        s2ph("citylot").parkplatzCounter();


    }

    public void positionFahrzeugAbfrage(Fahrzeug f) {

        if(f.geparkt) {
            try {

                for (int i = 0; i < this.parkhaus.length; i++) {
                    for (int j = 0; j < this.parkhaus[i].length; j++) {

                        if (this.parkhaus[i][j] == f) {
                            System.out.println("\n" + this + " * position of * " + f.kennzeichen + " *\n            P" + j + " E" + i);
                            Gui.nummernschilTextA.setText(" " + this + " * P" + j + " E" + i+" * ");
                            return;

                        }
                    }
                }

                System.out.println("\n" + this + " * position of * " + f.kennzeichen + "\n # Fahrzeug nicht gefunden # ");

            } catch (NullPointerException e) {
            }

        }else{
            System.out.println("Auto nicht geparkt");
            Gui.nummernschilTextA.setText("nicht geparkt");
        }
    }


    public Fahrzeug kfZzumKennzeichenAbfrage(String knz) {
        try {

            for (int i = 0; i < Fahrzeug.kfz.size(); i++) {
                if (Objects.equals(Fahrzeug.kfz.get(i).kennzeichen, knz.trim().toUpperCase())) {
                    gesuchtes = Fahrzeug.kfz.get(i);
                    return gesuchtes;
                }
            }

            System.out.println("\n"+this+" * position of * "+gesuchtes.kennzeichen+ "\n # Fahrzeug nicht gefunden # ");

        }catch(NullPointerException e) {
            Gui.nummernschilTextA.setText("N/A");}

        return null;
    }


    public boolean positionFahrzeug(Fahrzeug f) {

        try {
            for (int i = 0; i < this.parkhaus.length; i++) {
                for (int j = 0; j < this.parkhaus[i].length; j++) {

                    if (this.parkhaus[i][j] == f) {
                        return true;
                    }
                }
            }
        }catch(NullPointerException e) {}

    return false;
    }


    public void parkeFahrzeug(Fahrzeug f) {

        if(this.belegteParkplaetze < this.parkplatzZaehlung) {

            if (!f.geparkt) {

                    LOOP1:
                    for (int i = 0; i < this.parkhaus.length; i++) {
                        for (int j = 0; j < this.parkhaus[i].length; j++) {

                            if (this.parkhaus[i][j] == null) {

                                this.parkhaus[i][j] = f;

                                Gui.textAreaZeitReal.setText(f.kennzeichen + "  * parking *  P" + j + " E" + i);
                                Gui.textAreaZeitReal.setVisible(false);
                                Gui.textAreaZeitReal.setVisible(true);
                                Gui.textPaneStats.append("\n   -> " + this + " * parking *  " + f.kennzeichen + "          P" + j + " E" + i + "   ");
                                this.belegteParkplaetze++;
                                f.geparkt = true;
                                break LOOP1;


                            }
                        }
                    }

            } else {
                System.out.println("\n" + f + " ist geparkt");
            }
        }
    }

    public void entferneFahrzeug(Fahrzeug f) {

        if (positionFahrzeug(f)) {

        LOOP1:
        for (int i = 0; i < this.parkhaus.length; i++) {
            for (int j = 0; j < this.parkhaus[i].length; j++) {

                if (this.parkhaus[i][j] == f) {

                    this.parkhaus[i][j] = null;

                    Gui.textAreaZeitReal.setText("\n" +
                            "       "+f.kennzeichen + "  * leaving *   P" + j + " E" + i);
                    Gui.textAreaZeitReal.setVisible(false);
                    Gui.textAreaZeitReal.setVisible(true);
                    Gui.textPaneStats.append("\n<-    "+this+" * leaving *" +
                            "  "+f.kennzeichen + "           P" + j + " E" + i+"        ");
                    this.belegteParkplaetze--;
                    f.geparkt = false;
                    break LOOP1;
                }
            }
        }
        }
    }


    public int parkplatzCounter() {

        this.parkplatzZaehlung = 0;

        for (int i = 0; i < this.parkhaus.length; i++) {
            for (int j = 0; j < this.parkhaus[i].length; j++) {

                this.parkplatzZaehlung++;
            }
        }
    return this.parkplatzZaehlung;
    }


    public void getStatsParkhausTextArea() throws ArithmeticException{

        try {

            int kapazitaet = this.parkplatzCounter();
            int belegte = this.belegteParkplaetze;
            int freieSlots = kapazitaet - belegte;
            float auslastung = (float) ((belegte * 100) / kapazitaet);


            Gui.textAreaZeit.setText("°~~~~~~~~~~~~~°\n     " + this +
                    "  P\n           Frei: " + freieSlots +
                    "                \n        Belegt: " + (kapazitaet - freieSlots) +
                    "\n Auslastung: ");

            Gui.textAreaZeit.append(auslastung + "%\n~~~~~~~~~~~~~~~]\n");


        }catch(ArithmeticException e) {}


    }

        public static Parkhaus s2ph(String sp) throws NullPointerException{

            for (Parkhaus value : parkhausListe) {

                if (value.name.equals(sp)) {

                    return value;

                }

            }
            return null;
        }




    public String toString(){

    return this.name;

    }

}