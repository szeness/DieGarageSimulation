package actionlistener;

import gui.Gui;
import parkhaus.Parkhaus;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SearchSlot extends Gui implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            for (Parkhaus p : Parkhaus.parkhausListe) {

                p.positionFahrzeugAbfrage(p.kfZzumKennzeichenAbfrage(Gui.nummernschilText.getText()));

            }


        } catch (NullPointerException ne) {
        }
    }
}
