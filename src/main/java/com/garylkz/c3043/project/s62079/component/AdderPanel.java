package com.garylkz.c3043.project.s62079.component;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class AdderPanel extends ComponentPanel {
    JLabel fieldLabel = new JLabel(), areaLabel = new JLabel();
    JTextField field = new JTextField(20);
    JButton add = new JButton("Add");
    JTextArea area = new JTextArea();

    public AdderPanel() {
        fieldLabel.setVisible(false);
        areaLabel.setVisible(false);

        layout.setHorizontalGroup(layout.createParallelGroup()
                .addComponent(header)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup()
                                .addComponent(fieldLabel)
                                .addComponent(areaLabel))
                        .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(field)
                                        .addComponent(add))
                                .addComponent(area)))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(header)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldLabel)
                        .addComponent(field)
                        .addComponent(add))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(areaLabel)
                        .addComponent(area))
        );
    }

    public void setLabels(String field, String area) {
        fieldLabel.setText(field);
        areaLabel.setText(area);
        fieldLabel.setVisible(true);
        areaLabel.setVisible(true);
    }

    public String getField() {
        return field.getText();
    }

    public String getArea() {
        return area.getText();
    }

    public void addAddEvent(ActionListener e) {
        add.addActionListener(e);
    }

    public void addAreaEvent(KeyListener e) {
        area.addKeyListener(e);
    }

    public void showArea(boolean flag) {
        area.setVisible(flag);
    }
}
