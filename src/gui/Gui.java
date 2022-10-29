package gui;



import actionlistener.*;
import parkhaus.Parkhaus;

import javax.swing.*;


import java.awt.*;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static parkhaus.Parkhaus.parkhausListe;


public class Gui extends JFrame {

    public Color buttonColor = new Color(36, 26, 42, 255);
    public Color buttonTextColor = new Color(173, 123, 127, 255);

    public static int ixcarOut = -100;
    public static int ixcarInrIn = 640;
    public static int indexParkhaus;
    public static JLabel checkBoxLab = new JLabel();


    public static JButton rushHourBtn = new JButton("Rush Hour");

    public static Gui framzz;
    public static ImageIcon icon = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/zueblinparkhaus_parkhausdeck_kachel_gross_0.jpg")));
    public static ImageIcon icon1 = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/das-wrack-des-abgestuerzten.jpg")));
    public static ImageIcon icon2 = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/20190906koeln021.jpg")));
    public static ImageIcon icon3 = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/w1900_h1266_x1170_y1066_Meckenheim_Parkpalette_Neuer_Markt_Rathaus_Jungholzhalle_Campus-1-3-427912132-44eef47e63b64987.jpg")));
    public static ImageIcon carOut = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/carOut.png")));
    public static ImageIcon carIn = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/carIn.png")));

    protected List<ImageIcon> wallpapers = Arrays.asList(icon, icon2, icon3, icon1);

    public static JButton timeWarpButton = new JButton();
    public static JButton swapGarage = new JButton("Parkhaus");
    public static        JButton pkwSuchenButton = new JButton("Suchen");
    public static       JButton startButton = new JButton("Start");
    public static JCheckBox checkMains = new JCheckBox();

    public static JLabel carOutLabel = new JLabel();
    public static JLabel carInLabel = new JLabel();

    public static JTextArea textAreaZeit1;
    public static JTextArea textAreaZeit;
    public static JTextArea textAreaZeitReal;
    public static JLabel wp1;
    public static JTextArea textPaneStats = new JTextArea();
    public static JScrollPane js = new JScrollPane(textPaneStats);
    public static JTextArea nummernschilTextA = new JTextArea();
    public static JTextField nummernschilText = new JTextField();
    public static JLabel autosAnzahlTxt = new JLabel("Nummernschild");
    public static JTextField autosAnzahlField = new JTextField();
    public static JLabel phAnzahlLabel = new JLabel("Nummernschild");
    public static JTextField phAnzahlFeld = new JTextField();


    public static JComboBox<Parkhaus> parkhausDropList = new JComboBox<Parkhaus>(new DefaultComboBoxModel<Parkhaus>(parkhausListe.toArray(new Parkhaus[0])));;


    public void run() {


    framzz = new Gui();
    framzz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    framzz.setSize(640, 480);
    framzz.setLayout(null);
    framzz.setBackground(new Color(96, 23, 23));
    framzz.setVisible(true);
    framzz.setLayout(null);
    framzz.toFront();
    framzz.setLocationRelativeTo(null);
    framzz.setState(Frame.NORMAL);

        textAreaZeitReal = new JTextArea();
        textAreaZeitReal.setSize(350, 29);
        textAreaZeitReal.setBackground(new Color(112, 56, 56, 0));
        textAreaZeitReal.setLocation(282, 27);
        textAreaZeitReal.setForeground(new Color(0, 0, 0, 255));
        textAreaZeitReal.setFont(new Font("Arial", Font.PLAIN, 25));
        textAreaZeitReal.setFocusable(false);
        textAreaZeitReal.setVisible(true);
        textAreaZeitReal.requestFocus(false);
        framzz.add(textAreaZeitReal);

        textAreaZeit = new JTextArea();
        textAreaZeit.setSize(147, 135);
        textAreaZeit.setBackground(new Color(21, 71, 145, 255));
        textAreaZeit.setLocation(106, 75);
        textAreaZeit.setForeground(new Color(202, 255, 213));
        textAreaZeit.setFont(new Font("Arial", Font.PLAIN, 17));
        textAreaZeit.setFocusable(false);
        textAreaZeit.setVisible(true);
        textAreaZeit.requestFocus(false);
        framzz.add(textAreaZeit);

        textAreaZeit1 = new JTextArea();
        textAreaZeit1.setSize(100, 50);
        textAreaZeit1.setBackground(new Color(21, 71, 145, 0));
        textAreaZeit1.setLocation(5, 5);
        textAreaZeit1.setForeground(new Color(18, 252, 65));
        textAreaZeit1.setFont(new Font("Arial", Font.PLAIN, 12));
        textAreaZeit1.setFocusable(false);
        textAreaZeit1.setVisible(true);
        textAreaZeit1.requestFocus(false);
        framzz.add(textAreaZeit1);

        textPaneStats.setBounds(265,70,320,300);
        textPaneStats.setVisible(true);
        textPaneStats.setBackground(new Color(4, 32, 45, 255));
        textPaneStats.setForeground(buttonTextColor);
        textPaneStats.setFocusable(true);

        js.setBounds(300,70,320,320);
        js.setVisible(false);
        js.setBackground(new Color(4, 32, 45, 255));
        js.setForeground(buttonTextColor);
        js.setFocusable(false);
        js.setOpaque(false);
        js.getViewport().setOpaque(false);
        js.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                e.getAdjustable().setValue(e.getAdjustable().getMaximum());
            }
        });
        framzz.add(js);
        js.setVisible(true);

            parkhausDropList.setBounds(125, 210, 108, 20);
            parkhausDropList.setVisible(true);
            parkhausDropList.addActionListener(new DropdownGaragen());
            framzz.add(parkhausDropList);

                swapGarage.setSize(117,20);
                swapGarage.setLocation(121,55);
                swapGarage.setFont(new Font("Arial", Font.BOLD, 12));
                swapGarage.setForeground(buttonTextColor);
                swapGarage.setFocusable(true);
                swapGarage.setVisible(true);
                swapGarage.requestFocus(true);
                swapGarage.addActionListener(new SwapGarage());
                framzz.add(swapGarage);


                pkwSuchenButton.setSize(100,21);
                pkwSuchenButton.setLocation(45,282);
                pkwSuchenButton.setFont(new Font("Arial", Font.BOLD, 12));
                pkwSuchenButton.setForeground(new Color(205, 131, 80, 255));
                pkwSuchenButton.setFocusable(true);
                pkwSuchenButton.setVisible(true);
                pkwSuchenButton.setFocusable(true);
                pkwSuchenButton.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "COPY");
                pkwSuchenButton.addActionListener(new SearchSlot());
                framzz.add(pkwSuchenButton);

        nummernschilTextA.setLocation(11,303);
        nummernschilTextA.setSize(175,19);
        nummernschilTextA.setFont(new Font("TimesNewRoman", Font.PLAIN,14));
        nummernschilTextA.setBackground(buttonColor);
        nummernschilTextA.setBackground(new Color(77, 44, 26, 255));
        nummernschilTextA.setForeground(new Color(220, 34, 34));
        nummernschilTextA.setFocusable(false);
        nummernschilTextA.setVisible(true);
        framzz.add(nummernschilTextA);

        nummernschilText.setLocation(45,259);
        nummernschilText.setSize(100, 25);
        nummernschilText.setVisible(true);
        framzz.add(nummernschilText);



                startButton.setSize(180,20);
                startButton.setLocation(316,418);
                startButton.setFont(new Font("Arial", Font.BOLD, 12));
                startButton.setBackground(new Color(124, 12, 25));
                startButton.setForeground(buttonTextColor);
                startButton.setFocusable(true);
                startButton.setVisible(true);
                startButton.addActionListener(new StartSimulation());
                framzz.add(startButton);




        autosAnzahlTxt.setLocation(393,396);
        autosAnzahlTxt.setSize(60,22);
        autosAnzahlTxt.setBackground(Color.BLACK);
        autosAnzahlTxt.setText("Autos");
        autosAnzahlTxt.setForeground(Color.WHITE);
        autosAnzahlTxt.setVisible(true);
        framzz.add(autosAnzahlTxt);

        autosAnzahlField.setLocation(432,398);
        autosAnzahlField.setSize(60, 18);
        autosAnzahlField.setVisible(true);
        autosAnzahlField.setText("2000");
        framzz.add(autosAnzahlField);


        phAnzahlLabel.setLocation(225,396);
        phAnzahlLabel.setSize(90,22);
        phAnzahlLabel.setBackground(Color.BLACK);
        phAnzahlLabel.setText("Dummy Parkh.:");
        phAnzahlLabel.setForeground(Color.WHITE);
        phAnzahlLabel.setVisible(true);
        framzz.add(phAnzahlLabel);

        phAnzahlFeld.setLocation(320,398);
        phAnzahlFeld.setSize(60, 18);
        phAnzahlFeld.setVisible(true);
        phAnzahlFeld.setText("2");
        framzz.add(phAnzahlFeld);

        Container cont = framzz.getContentPane();
        JRootPane jrf = framzz.getRootPane();

        cont.add(pkwSuchenButton);
        jrf.setDefaultButton(pkwSuchenButton);


                rushHourBtn.setSize(120,20);
                rushHourBtn.setLocation(500,392);
                rushHourBtn.setFont(new Font("Arial", Font.BOLD, 12));
                rushHourBtn.setBackground(buttonColor);
                rushHourBtn.setForeground(buttonTextColor);
                rushHourBtn.setFocusable(true);
                rushHourBtn.setVisible(true);
                rushHourBtn.addActionListener(new TriggerRushHour());
                framzz.add(rushHourBtn);



        checkBoxLab.setLocation(190,415);
        checkBoxLab.setSize(120,22);
        checkBoxLab.setBackground(Color.BLACK);
        checkBoxLab.setText("Main Garages(6)");
        checkBoxLab.setForeground(Color.WHITE);
        checkBoxLab.setVisible(true);
        framzz.add(checkBoxLab);


                checkMains.setLocation(285,418);
                checkMains.setSize(20,15);
                checkMains.setBackground(Color.BLACK);
                checkMains.setSelected(true);
                checkMains.setVisible(true);
                framzz.add(checkMains);


                JButton backgroundButton = new JButton("Background");
                backgroundButton.setSize(110,20);
                backgroundButton.setLocation(528,0);
                backgroundButton.setFont(new Font("Arial", Font.BOLD, 12));
                backgroundButton.setForeground(buttonTextColor);
                backgroundButton.setFocusable(true);
                backgroundButton.setVisible(true);
                backgroundButton.addActionListener(new SwapBackground());
                framzz.add(backgroundButton);




        carOutLabel.setLocation(ixcarOut,400);
        carOutLabel.setSize(82,60);
        carOutLabel.setIcon(carOut);
        framzz.add(carOutLabel);
        carOutLabel.setVisible(true);

        carInLabel.setLocation(ixcarInrIn,500);
        carInLabel.setSize(117,87);
        carInLabel.setIcon(carIn);
        framzz.add(carInLabel);
        carInLabel.setVisible(true);

                timeWarpButton.setSize(120,20);
                timeWarpButton.setLocation(500,418);
                timeWarpButton.setFont(new Font("Arial", Font.BOLD, 12));
                timeWarpButton.setBackground(buttonColor);
                timeWarpButton.setForeground(buttonTextColor);
                timeWarpButton.setText("speed +");
                timeWarpButton.setVisible(true);
                timeWarpButton.addActionListener(new TimeWarp());
                framzz.add(timeWarpButton);


                        wp1 = new JLabel();
                        wp1.setBounds(0, 0, 640, 480);
                        wp1.setBackground(new Color(96, 23, 23));
                        wp1.setIcon(icon);
                        framzz.add(wp1);
                        wp1.setVisible(true);
                        wp1.setVisible(false);
                        wp1.setVisible(true);

            }

        }
