package com.thisgary.c3043.lab;

import com.thisgary.library.ModuleTester;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

class Test extends ModuleTester {
    public Test() {
        String path = System.getProperty("user.dir") + "/src/main/java/com/thisgary/c3043/lab/";
        String[] modules = new File(path).list((dir, name) -> new File(dir, name).isDirectory());
        if (modules == null) modules = new String[0];

        moduleBox.setModel(new DefaultComboBoxModel<>(modules));
        moduleBox.addActionListener(ae -> {
            String module = (String) moduleBox.getSelectedItem();
            String[] classes = new File(path + module).list();
            if (classes == null) classes = new String[0];
            String[] cls = Arrays.stream(classes).filter(s -> {
                try { // check if class have main method
                    Class<?> c = Class.forName(
                            "com.thisgary.c3043.lab." + module + "." + s.substring(0, s.length() - 5));
                    c.getMethod("main", String[].class);
                    return true;
                } catch (ClassNotFoundException | NoSuchMethodException | NullPointerException e) {
                    return false;
                }
            }).map(s -> s.substring(0, s.length() - 5)).sorted().toArray(String[]::new);
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(cls);
            activityBox.setModel(model);
        });

        activityBox.addActionListener(ae -> {
            String module = (String) moduleBox.getSelectedItem();
            String test = (String) activityBox.getSelectedItem();
            try {
                Class<?> c = Class.forName("com.thisgary.c3043.lab." + module + "." + test);
                c.getMethod("main", String[].class).invoke(null, (Object) null);
            } catch (ClassNotFoundException | NoSuchMethodException | NullPointerException | IllegalAccessException |
                     InvocationTargetException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        Test application = new Test();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
