package com.thisgary.c3034.lab;

import com.thisgary.library.Dumpster;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

class Test extends JFrame {
    JPanel modulePanel, activityPanel;
    JComboBox<String> moduleBox;
    JComboBox<String> activityBox;

    public Test() {
        // List all modules
        String path = System.getProperty("user.dir") + "/src/main/java/com/thisgary/c3034/lab/";
        String[] modules = new File(path).list((dir, name) -> name.matches("Module[0-9]+.java"));
        String[] ms = (modules == null)
                ? new String[0]
                : Arrays.stream(modules)
                        .map(s -> s.substring(6, s.length() - 5))
                        .toArray(String[]::new);

        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        modulePanel = new JPanel();
        modulePanel.add(new JLabel("Lab Module"));
        moduleBox = new JComboBox<>(ms);
        moduleBox.addActionListener(ae -> {
            String m = (String) moduleBox.getSelectedItem();
            try {
                // List all methods
                Class<?> classes = Class.forName("com.thisgary.c3034.lab.Module" + m);
                Method[] methods = classes.getDeclaredMethods();

                // List all activities
                String[] activities = Arrays.stream(methods)
                        .map(Method::getName) // get method name
                        .map(n -> n.startsWith("activity") ? n.substring(8) : null) // check if it is activity
                        .filter(Objects::nonNull) // filter unmatched (null)
                        .sorted()
                        .toArray(String[]::new);

                DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(activities);
                activityBox.setModel(model);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        modulePanel.add(moduleBox);
        container.add(modulePanel);

        activityPanel = new JPanel();
        activityPanel.add(new JLabel("Activity"));
        activityBox = new JComboBox<>();
        activityBox.addActionListener(ae -> {
            String m = (String) moduleBox.getSelectedItem();
            String t = (String) activityBox.getSelectedItem();
            try {
                Dumpster.psvInvoker("com.thisgary.c3034.lab.Module" + m, "activity" + t);
            } catch (Throwable e) {
                JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        activityPanel.add(activityBox);
        container.add(activityPanel);

        setSize(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        Test application = new Test();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
