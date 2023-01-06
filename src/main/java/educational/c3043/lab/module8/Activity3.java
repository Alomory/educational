package educational.c3043.lab.module8;

import javax.swing.*;
import java.awt.*;

public class Activity3 extends JFrame {
    JPanel panel1 = new JPanel(), panel2 = new JPanel();
    JTextField input, output;

    public Activity3() {
        super("Activity 3");

        panel1.add(new JLabel("Farenheit"));
        input = new JTextField(5);
        input.addActionListener(ae -> {
            try {
                int f = Integer.parseInt(input.getText());
                int c = (f - 32) * 5 / 9;
                output.setText(Integer.toString(c));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null, "Oi, numba only!", "Error", JOptionPane.ERROR_MESSAGE);
                input.setText("");
                output.setText("");
            }
        });
        panel1.add(input);
        add(panel1, BorderLayout.NORTH);

        panel2.add(new JLabel("Celsius"));
        output = new JTextField(5);
        output.setEditable(false);
        panel2.add(output);
        add(panel2, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Activity3 a = new Activity3();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setSize(300, 120);
        a.setVisible(true);
    }
}
