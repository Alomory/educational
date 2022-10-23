package com.garylkz.c3043.project.s62079.component;

import javax.swing.*;

public abstract class ComponentPanel extends JPanel {
    GroupLayout layout;
    JLabel header;

    public ComponentPanel() {
        layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateGaps(true);

        header = new JLabel();
    }

    public void setHeader(String t) {
        header.setText(t);
    }
}
