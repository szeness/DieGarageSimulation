package fahrzeuge;

import gui.Gui;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

abstract public class Fahrzeug {



    public String fahrZeugTyp;
    public String kennzeichen;
    public boolean geparkt;
    public int parkZeit;

    public static ArrayList<String> fahrzeugRegister = new ArrayList<>();
    public static ArrayList<Fahrzeug> kfz = new ArrayList<>();

    public Fahrzeug(String kz,String kfzTyp){

        this.kennzeichen = kz;
        this.fahrZeugTyp = kfzTyp;

    }



    public Fahrzeug(){


    }
    public static int stat;
    public static int counterSecs;
    public static int seczZeit;
    public int secToStay;


    public int parkTimeGetStart(int dur) {

        LocalDateTime date = LocalDateTime.now();
        int startS = date.toLocalTime().toSecondOfDay();
        this.secToStay = startS + dur;
        System.out.println(this.toString() +   this.secToStay);

        return  this.secToStay;
    }


    public static void kfzEintragung(boolean konsolenausgabe, String Nummernschild, String kfzTyp) {

        if(!fahrzeugRegister.contains(Nummernschild)) {

            fahrzeugRegister.add(Nummernschild);

            if(konsolenausgabe)
                System.out.println("\nDas Kennzeichen "+Nummernschild+" wurde eingetragen");


            if(kfzTyp.equals("Auto"))
                kfz.add(new Auto(Nummernschild,kfzTyp));
            else if(kfzTyp.equals("Motorrad"))
                kfz.add(new Motorrad(Nummernschild,kfzTyp));


        }else{
            System.out.println("\nKennzeichen bereits vergeben");

        }


    }


    public String toString() {

        return this.kennzeichen;
    }


}
