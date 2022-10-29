package threads;

import gui.Gui;

public class CarIn extends Thread {

    public void run() {


        for (int i = 0; true ; i++) {
            try {
                sleep(1000*10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            int x = 200;
            for (int j = 0; j < 250; j++) {
                try {
                    sleep(20);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Gui.carInLabel.setLocation(Gui.ixcarInrIn -= 3, 380);
                Gui.carInLabel.setSize(j + 60, (x -= 3));

            }
        Gui.ixcarInrIn = 640;
        Gui.carInLabel.setSize(120,87);
        Gui.carInLabel.setLocation(Gui.ixcarInrIn, 480);
        }

    }

}
