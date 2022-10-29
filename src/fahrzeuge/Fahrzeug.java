package fahrzeuge;

import gui.Gui;

import java.util.ArrayList;
import java.util.Objects;

abstract public class Fahrzeug {

    public String fahrZeugTyp;
    public String kennzeichen;
    public boolean geparkt;

    public static ArrayList<String> fahrzeugRegister = new ArrayList<>();
    public static ArrayList<Fahrzeug> kfz = new ArrayList<>();

    public Fahrzeug(String kz,String kfzTyp){

        this.kennzeichen = kz;
        this.fahrZeugTyp = kfzTyp;

    }


    public Fahrzeug(){


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
