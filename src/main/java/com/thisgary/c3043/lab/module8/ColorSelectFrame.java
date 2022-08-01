package com.thisgary.c3043.lab.module8;

import javax.swing.*;
import java.awt.*;

public class ColorSelectFrame extends JFrame {
    JButton ok, cancel;
    JCheckBox foreground, background;
    JComboBox<String> color;
    JPanel p1, p2;

    public ColorSelectFrame() {
        super("I don't know what is this");
        setLayout(new BorderLayout());

        color = new JComboBox();
        color.addItem("RED");
        add(color, BorderLayout.NORTH);

        p1 = new JPanel();
        foreground = new JCheckBox("Foreground");
        background = new JCheckBox("Background");
        p1.add(foreground);
        p1.add(background);
        add(p1, BorderLayout.CENTER);

        p2 = new JPanel();
        ok = new JButton("Ok");
        cancel = new JButton("Cancel");
        p2.add(ok);
        p2.add(cancel);
        add(p2, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        ColorSelectFrame csf = new ColorSelectFrame();
        csf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        csf.setSize(300, 140);
        csf.setVisible(true);
    }
}
