package com.thisgary.c3043.project.s62079.frame;

import com.thisgary.c3043.project.Main;
import com.thisgary.c3043.project.s62079.core.Account;
import com.thisgary.c3043.project.s62079.exception.LazyException;

import javax.swing.*;

public abstract class AppPanel extends JPanel {
    static Main app;
    final boolean admin;
    Account session;
    GroupLayout layout;

    public AppPanel() {
        admin = app.getAdmin();
        session = app.getSession();

        layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
    }

    public static void successDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void errorDialog(LazyException e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void setApp(Main a) {
        app = a;
    }
}
