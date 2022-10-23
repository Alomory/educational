package com.garylkz.c3043.lecture.class8;

import javax.swing.*;
import java.awt.*;

public class DefaultFrame extends JFrame {
    private final int WIDTH = 300, HEIGHT = 200, X = 150, Y = 100;
    public DefaultFrame() {
        super("My First Subclass");

        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        container.setBackground(Color.BLUE);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocation(X, Y);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DefaultFrame();
    }
}
