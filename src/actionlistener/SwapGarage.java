package actionlistener;

import gui.Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static parkhaus.Parkhaus.parkhausListe;

public class SwapGarage extends Gui implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {

        indexParkhaus++;

        if(indexParkhaus == parkhausListe.size()) {

            indexParkhaus = 0;

        }

    }
}
