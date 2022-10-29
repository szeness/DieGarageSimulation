package actionlistener;

import gui.Gui;
import main.Main;
import threads.AusparkSimulator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartSimulation extends Gui implements ActionListener {
        boolean toggle;

    @Override
    public void actionPerformed(ActionEvent e) throws IllegalThreadStateException{


        new Runnable() {
            @Override
            public void run() {

                if(!toggle) {

                    Gui.checkMains.setVisible(false);
                    Gui.autosAnzahlField.setVisible(false);
                    Gui.autosAnzahlTxt.setVisible(false);
                    Gui.checkBoxLab.setVisible(false);
                    Gui.phAnzahlLabel.setVisible(false);
                    Gui.phAnzahlFeld.setVisible(false);


                    AusparkSimulator.timeFast = false;

                    Main.registriereKfz(Integer.parseInt(autosAnzahlField.getText()));

                    Main.dummyParkhausEroeffnung(Integer.parseInt(phAnzahlFeld.getText()));

                    Main.starteSimulation();

                    Gui.startButton.setText("stop");
                }else{
                    Gui.checkMains.setVisible(true);
                    Gui.autosAnzahlField.setVisible(true);
                    Gui.autosAnzahlTxt.setVisible(true);
                    Gui.checkBoxLab.setVisible(true);
                    Gui.phAnzahlLabel.setVisible(true);
                    Gui.phAnzahlFeld.setVisible(true);

                    AusparkSimulator.timeFast = true;
                    Gui.startButton.setText("start");

                }
                toggle = !toggle;

            }
        }.run();


    }


}


