package com.thisgary.c3043.lab.module8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/* Exercise
Create b simple GUI to change the type of font when end user point of specific radio button.
 */

public class Exercise extends JFrame {
    JPanel p1, p2;
    JTextField t;
    JRadioButton a, b;

    public Exercise() {
        super("Why Someone Singing In Room");

        p1 = new JPanel();

        t = new JTextField("Lorem Ipsum");
        t.setEditable(false);
        p1.add(t);

        add(p1, BorderLayout.NORTH);

        p2 = new JPanel();

        a = new JRadioButton("Sans-serif");
        a.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                a.setSelected(true);
                t.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
            }
        });
        a.addActionListener(ae -> t.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12)));
        p2.add(a);

        b = new JRadioButton("Serif");
        b.setSelected(true);
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b.setSelected(true);
                t.setFont(new Font(Font.SERIF, Font.PLAIN, 12));
            }
        });
        b.addActionListener(ae -> t.setFont(new Font(Font.SERIF, Font.PLAIN, 12)));
        p2.add(b);

        add(p2, BorderLayout.SOUTH);

        ButtonGroup g = new ButtonGroup();
        g.add(a);
        g.add(b);
    }
    
    public static void main(String[] args) {
        Exercise e = new Exercise();
        e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        e.setSize(300, 120);
        e.setVisible(true);
    }
}
