package com.garylkz.c3043.lab.module8;

import javax.swing.*;
import java.awt.*;

public class TriangleRectangle extends JFrame {
    JComboBox<String> shape = new JComboBox<>(new String[]{"Triangle", "Rectangle"});
    JTextField height = new JTextField(5), width = new JTextField(5), output = new JTextField(20);
    JButton ok = new JButton("Kek"), cancel = new JButton("No U");
    JPanel panel1 = new JPanel(), panel2 = new JPanel();

    public TriangleRectangle() {
        super("Why cat step on my laptop bag");

        add(shape, BorderLayout.NORTH);

        panel1.add(new JLabel("Height"));
        panel1.add(height);
        panel1.add(new JLabel("Width"));
        panel1.add(width);
        output.setEditable(false);
        panel1.add(new JLabel("Output"));
        panel1.add(output);
        add(panel1, BorderLayout.CENTER);

        ok.addActionListener(ae -> {
            try {
                int h = Integer.parseInt(height.getText());
                int w = Integer.parseInt(width.getText());

                double p = h + w;
                if (shape.getSelectedItem() == "Rectangle") p *= 2;
                else p += Math.sqrt(h * h + w * w);
                double a = h * w;
                if (shape.getSelectedItem() == "Triangle") a /= 2;

                output.setText(String.format("Perimeter is %.2f, Area is %.2f", p, a));
            } catch (NumberFormatException e) {
                String message = (e instanceof NumberFormatException) ? "Integer please" : "Developer lazy";
                JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel2.add(ok);
        cancel.addActionListener(ae -> {
            height.setText("");
            width.setText("");
            output.setText("");
        });
        panel2.add(cancel);
        add(panel2, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        TriangleRectangle tr = new TriangleRectangle();
        tr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tr.setSize(300, 160);
        tr.setVisible(true);
    }
}
