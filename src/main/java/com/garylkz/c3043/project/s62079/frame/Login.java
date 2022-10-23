package com.garylkz.c3043.project.s62079.frame;

import com.garylkz.c3043.project.s62079.core.Account;
import com.garylkz.c3043.project.s62079.core.Admin;
import com.garylkz.c3043.project.s62079.core.Customer;
import com.garylkz.c3043.project.s62079.exception.LazyException;
import com.garylkz.c3043.project.s62079.component.LoginPanel;
import com.garylkz.c3043.project.s62079.component.RegisterPanel;

import javax.swing.*;

public class Login extends AppPanel {
    final String
            SIGNIN = "Sign In",
            SIGNUP = "Sign Up",
            TO_SIGNUP = "Create Account";
    boolean isSignup = false;

    LoginPanel login;
    RegisterPanel register;
    JCheckBox adminBox;
    JButton signin, signup, change;

    public Login() {
        login = new LoginPanel();

        adminBox = new JCheckBox("Admin");
        adminBox.setVisible(false);
        adminBox.addActionListener(ae -> setMode());

        register = new RegisterPanel();
        register.showBirthdate(false);
        
        signin = new JButton(SIGNIN);
        signin.addActionListener(ae -> { // Sign In sign Up logic handling
            String username = login.getUsername(), password = login.getPassword();
            try {
                Account a = Account.getAccount(username);
                if (a == null)
                    throw new LazyException("User does not exist");
                if (!a.getPassword().equals(password))
                    throw new LazyException("Invalid password");
                app.setSession(a);
                Menu.setPanel();
            } catch (LazyException e) {
                errorDialog(e);
            }
        });

        signup = new JButton(SIGNUP);
        signup.addActionListener(ae -> {
            String
                    username = login.getUsername(),
                    password = login.getPassword(),
                    ic = register.getIC(),
                    name = register.getName(),
                    address = register.getAddress(),
                    phone = register.getPhone(),
                    email = register.getEmail();
            try {
                if (adminBox.isSelected()) new Admin(username, password);
                else new Customer(username, password, ic, name, address, phone, email);
                // Post creation cleanup
                login.setUsername("");
                login.setPassword("");
                setMode();
                // Notify
                successDialog("User " + username + " is created.");
            } catch (LazyException e) {
                errorDialog(e);
            }
        });

        change = new JButton(TO_SIGNUP);
        change.addActionListener(ae -> {
            isSignup = !isSignup;
            setMode();
        });

        JPanel action = new JPanel();
        GroupLayout actionLayout = new GroupLayout(action);
        action.setLayout(actionLayout);
        actionLayout.setAutoCreateGaps(true);
        actionLayout.setHorizontalGroup(actionLayout.createSequentialGroup()
                .addGroup(actionLayout.createParallelGroup()
                        .addComponent(signin)
                        .addComponent(signup))
                .addComponent(change)
        );
        actionLayout.setVerticalGroup(actionLayout.createSequentialGroup()
                .addGroup(actionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(signin)
                        .addComponent(signup)
                        .addComponent(change))
        );

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(login)
                        .addComponent(adminBox)
                        .addComponent(register)
                        .addComponent(action))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(login)
                .addComponent(adminBox)
                .addComponent(register)
                .addComponent(action)
        );

        setMode();
    }

    protected void setMode() {
        login.setHeader(isSignup ? SIGNUP : SIGNIN);
        login.clear();
        adminBox.setVisible(isSignup && admin);
        register.setVisible(isSignup && !adminBox.isSelected());
        register.clear();
        signin.setVisible(!isSignup);
        signup.setVisible(isSignup);
        change.setText(isSignup ? SIGNIN : TO_SIGNUP);

        app.flush();
    }

    public static void setPanel() {
        app.setPanel(new Login());
    }
}
