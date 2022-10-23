package com.garylkz.c3043.project.s62079.component;

import javax.swing.*;

public class LoginPanel extends ComponentPanel {
    JLabel usernameLabel, passwordLabel;
    JTextField username, password;

    public LoginPanel() {
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        username = new JTextField(20);
        password = new JTextField();

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(header)
                        .addComponent(usernameLabel)
                        .addComponent(passwordLabel))
                .addGroup(layout.createParallelGroup()
                        .addComponent(username)
                        .addComponent(password))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(header)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(usernameLabel)
                        .addComponent(username))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(passwordLabel)
                        .addComponent(password))
        );
    }

    public String getUsername() {
        return username.getText();
    }

    public void setUsername(String t) {
        username.setText(t);
    }

    public String getPassword() {
        return password.getText();
    }

    public void setPassword(String t) {
        password.setText(t);
    }

    public void clear() {
        setUsername("");
        setPassword("");
    }
}
