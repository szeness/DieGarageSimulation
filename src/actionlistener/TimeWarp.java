package actionlistener;

import gui.Gui;
import threads.Politesse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeWarp extends Gui implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {




        if(!Politesse.timeACtual) {
            Politesse.timeACtual = true;

            timeWarpButton.setText("speed -");
        }else if(Politesse.timeACtual){
            Politesse.timeACtual = false;
            timeWarpButton.setText("speed +");

        }





    }
}
