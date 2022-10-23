package com.garylkz.c3043.project.s62079.frame;

import com.garylkz.c3043.project.s62079.core.Access;
import com.garylkz.c3043.project.s62079.core.Customer;
import com.garylkz.c3043.project.s62079.exception.LazyException;

import javax.swing.*;

public class Menu extends AppPanel {
    JComboBox<Object> facilities;
    JPanel checkin;
    JButton add, info, access, report, back;

    public Menu() {
        JLabel header = new JLabel("Good day, " + session.getUsername());

        JLabel checkinHeader = new JLabel("Access Facility");
        facilities = new JComboBox<>(Access.getFacilities().toArray());
        add = new JButton("Check In");

        GroupLayout checkinLayout = new GroupLayout(checkin = new JPanel());
        checkin.setLayout(checkinLayout);
        checkinLayout.setAutoCreateGaps(true);
        checkinLayout.setHorizontalGroup(checkinLayout.createSequentialGroup()
                .addGroup(checkinLayout.createParallelGroup()
                        .addComponent(checkinHeader)
                        .addComponent(facilities)
                        .addComponent(add))
        );
        checkinLayout.setVerticalGroup(checkinLayout.createSequentialGroup()
                .addGap(20)
                .addComponent(checkinHeader)
                .addComponent(facilities)
                .addComponent(add)
                .addGap(20)
        );

        if (session instanceof Customer) {
            add.addActionListener(ae -> {
                Customer dummy = (Customer) session;

                try {
                    String facility = (String) facilities.getSelectedItem();
                    if (facility == null) throw new LazyException("Well, this place has no facility... Wait, what?");
                    dummy.addAccess(facility);

                    successDialog("Access added.");
                } catch (LazyException e) {
                    errorDialog(e);
                }
            });
        } else checkin.setVisible(false);

        info = new JButton("Manage Account");
        info.addActionListener(ae -> AccountInfo.setPanel());
        access = new JButton("Manage Access");
        access.addActionListener(ae -> AccessInfo.setPanel());
        report = new JButton("Manage Report");
        report.addActionListener(ae -> ReportInfo.setPanel());
        back = new JButton("Sign Out");
        back.addActionListener(ae -> {
            app.setSession(null);
            Login.setPanel();
        });

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(header)
                        .addComponent(checkin)
                        .addComponent(info)
                        .addComponent(access)
                        .addComponent(report)
                        .addComponent(back))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(header)
                .addComponent(checkin)
                .addComponent(info)
                .addComponent(access)
                .addComponent(report)
                .addComponent(back)
        );
    }

    public static void setPanel() {
        app.setPanel(new Menu());
    }
}
