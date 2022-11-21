package actionlistener;

import gui.Gui;
import threads.Simulator;

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
                        Simulator.chance = 10;
                        Gui.rushHourBtn.setText("Regular");
                    }else{
                        Simulator.chance = 200000;
                        Gui.rushHourBtn.setText("Rush Hour");
                    }
                    click=!click;
                }
            };
            r.run();
    }
}
