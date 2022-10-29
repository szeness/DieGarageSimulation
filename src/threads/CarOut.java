package threads;

import gui.Gui;

public class CarOut extends Thread {

    public static boolean carRunning;

    public void run() {

        if(!carRunning) {
            carRunning = true;
            int x = 0;
            for (int j = 0; j < 200; j++) {
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Gui.carOutLabel.setLocation(Gui.ixcarOut += 3, 380);
                Gui.carOutLabel.setSize(j + 60, j + 20);

            }

            Gui.ixcarOut = -100;

            Gui.carOutLabel.setLocation(Gui.ixcarOut,380);

            carRunning = false;


        }
    }

}
