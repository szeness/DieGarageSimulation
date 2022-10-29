package actionlistener;

import gui.Gui;
import threads.AusparkSimulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeWarp extends Gui implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {


        AusparkSimulator.timeFast = true;

        if(!AusparkSimulator.timeACtual) {
            AusparkSimulator.timeACtual = true;

            timeWarpButton.setText("speed -");
        }else if(AusparkSimulator.timeACtual){
            AusparkSimulator.timeACtual = false;
            timeWarpButton.setText("speed +");

        }

        AusparkSimulator.timeFast = false;



    }
}
