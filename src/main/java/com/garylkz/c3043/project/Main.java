package com.garylkz.c3043.project;

import com.garylkz.c3043.project.s62079.core.Account;
import com.garylkz.c3043.project.s62079.core.Admin;
import com.garylkz.c3043.project.s62079.core.Customer;
import com.garylkz.c3043.project.s62079.frame.Login;
import com.garylkz.c3043.project.s62079.frame.AppPanel;

import javax.swing.*;

public class Main extends JFrame {
    final boolean admin;
    Account session;
    JPanel panel = new JPanel();

    public Main(boolean admin) {
        super("MySport");
        this.admin = admin;

        AppPanel.setApp(this);
        Login.setPanel();

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Main() {
        this(false);
    }

    public void flush() {
        revalidate();
        repaint();
        pack();
        setLocationRelativeTo(null);
    }

    public void setPanel(AppPanel p) {
        remove(panel);
        panel = p;
        add(panel);
        flush();
    }

    public boolean getAdmin() {
        return admin;
    }

    public Account getSession() {
        return session;
    }

    public void setSession(Account session) {
        this.session = session;
    }

    public static void demo() {
        Admin.getGenius();
        Customer dummy = Customer.getDummy();
        dummy.addAccess("Somewhere");
        dummy.addAccess("Someplace");
        dummy.addAccess("Someone");
        dummy.addReport("Teammate not doing anything",
                "I tried to contact my teammate but they don't want to respond to me.");
        dummy.addReport("I have to do everything myself",
                "Due to teammate not responding to me, I have to do every single sh*t by myself");
    }

    public static void main(String[] args) {
        demo();
        new Main(true);
    }
}
