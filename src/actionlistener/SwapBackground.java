package actionlistener;

import gui.Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwapBackground extends Gui implements ActionListener {

    int i = 1;

    @Override
    public void actionPerformed(ActionEvent e) {

            Runnable r = new Runnable() {
                @Override
                public void run() {

                    wp1.setIcon(wallpapers.get(i++));

                    if(i == wallpapers.size()) {
                        i = 0;
                    }
                }
            };
            r.run();
        }
}
