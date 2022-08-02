package com.thisgary.c3034.lab;

import com.thisgary.library.Dumpster;
import com.thisgary.library.ModuleTester;

import javax.swing.*;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

class Test extends ModuleTester {
    public Test() {
        // List all modules
        String path = System.getProperty("user.dir") + "/src/main/java/com/thisgary/c3034/lab/";
        String[] modules = new File(path).list((dir, name) -> name.matches("Module[0-9]+.java"));
        String[] ms = (modules == null)
                ? new String[0]
                : Arrays.stream(modules)
                        .map(s -> s.substring(6, s.length() - 5))
                        .toArray(String[]::new);

        // Update module box
        moduleBox.setModel(new DefaultComboBoxModel<>(ms));
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

                // Update activity box
                DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(activities);
                activityBox.setModel(model);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        activityBox.addActionListener(ae -> {
            String m = (String) moduleBox.getSelectedItem();
            String t = (String) activityBox.getSelectedItem();
            try {
                Dumpster.psvInvoker("com.thisgary.c3034.lab.Module" + m, "activity" + t);
            } catch (Throwable e) {
                JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        Test application = new Test();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
