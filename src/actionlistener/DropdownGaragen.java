package actionlistener;

import gui.Gui;
import parkhaus.Parkhaus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static parkhaus.Parkhaus.parkhausListe;

public class DropdownGaragen extends Gui implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) throws  NullPointerException{
        try {
            indexParkhaus = parkhausListe.indexOf(Parkhaus.s2ph(parkhausDropList.getSelectedItem().toString()));
        }catch(NullPointerException enn){}
    }
}
