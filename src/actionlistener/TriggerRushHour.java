package actionlistener;

import gui.Gui;
import threads.EinparkSimulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TriggerRushHour extends Gui implements ActionListener {

    public boolean click;

    @Override
    public void actionPerformed(ActionEvent e) {

            Runnable r = new Runnable() {
                @Override
                public void run() {

                    if(!click){
                        EinparkSimulator.chance = 2;
                        Gui.rushHourBtn.setText("Regular");
                    }else{
                        EinparkSimulator.chance = 600;
                        Gui.rushHourBtn.setText("Rush Hour");
                    }
                    click=!click;


                }
            };
            r.run();



    }
}
