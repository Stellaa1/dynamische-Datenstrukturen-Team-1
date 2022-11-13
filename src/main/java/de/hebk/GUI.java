package de.hebk;

import javax.swing.*;
import java.awt.*;

public class GUI {

    JFrame frame;
    JPanel panel1, panel2;
    public GUI() {
        frame = new JFrame();

        // Setzt das Fenster immer auf Fullscreen
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // Entfernt den oberen Rahmen
        frame.setUndecorated(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panel1 = new JPanel();
        panel1.setBounds(0, 200, 350, 100);
        panel1.setBackground(Color.black);

        frame.add(panel1);
    }
}
