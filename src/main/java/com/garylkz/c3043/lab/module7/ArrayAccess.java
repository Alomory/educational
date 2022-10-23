package com.garylkz.c3043.lab.module7;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
//import javax.swing.event.*;

public class ArrayAccess extends JFrame {
    private JTextField inputField, retrieveValueField, retrieveIndexField, outputField;
    private JPanel inputPanel, retrievePanel, outputPanel;
    private int num, index = 0, accessArray[];
    private String result;

    //setting up GUI
    public ArrayAccess() {
        super("Accessing Array values");
        accessArray = new int[10];

        //get content pane and set its layout
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        //set up input Panel
        inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter array elements here"));
        inputField = new JTextField(10);
        inputField.addActionListener(ae -> {
            try {
                /*
                write a try block in which the application reads the number entered
                the inputField and assigns it to the next index in the array, then
                increments instance variable index.
                */
                int num = Integer.parseInt(inputField.getText());
                for (int i : accessArray)
                    if (i == num) throw new DuplicateValueException();
                accessArray[index] = num;
                if (++index == accessArray.length) index = 0;
                result = Arrays.toString(accessArray);
                outputField.setText(result);
            } catch (NumberFormatException | DuplicateValueException e) {
                /*
                write a catch clauses that catch the two types of exceptions that the
                previous try block might throw (NumberFormatException and ArrayIndexOutOfBoundException),
                and display appropriate messages in error message dialogs.
                */
                exceptionHandler(e);
            }
            inputField.setText("");
        });

        inputPanel.add(inputField);
        container.add(inputPanel);

        //setting up retrieve Panel
        retrievePanel = new JPanel(new GridLayout(2, 2));
        retrievePanel.add(new JLabel("Enter number to retrieve"));
        retrieveValueField = new JTextField(10);
        retrieveValueField.addActionListener(ae -> {
            try {
                /*
                write code for a try block in which the application reads from
                retrieveValueField the number the user wants to find in the array,
                then searches the current array contents or the number.
                If the number is found, the outputField should display all the indices
                in which the number was found. If the number is not found,
                NumberNotFoundException should be thrown.
                */
                num = Integer.parseInt(retrieveValueField.getText());
                int index = -1;
                for (int i = 0; i < accessArray.length; i++)
                    if (accessArray[i] == num) {
                        index = i;
                        break;
                    }
                if (index < 0)
                    throw new NumberNotFoundException();
                outputField.setText(result + ", " + num + " is at index " + index);
            } catch (NumberFormatException | NumberNotFoundException e) {
                /*
                write a catch clauses that catch the two types of exceptions that the
                try block might throw (NumberFormatException and ArrayIndexOutOfBoundException),
                and display appropriate messages in error message dialogs.
                */
                exceptionHandler(e);
            }
            retrieveValueField.setText("");
        });

        retrievePanel.add(retrieveValueField);
        container.add(retrievePanel);

        //setting up output Panel
        outputPanel = new JPanel();
        outputPanel.add(new JLabel("Result"));
        outputField = new JTextField(30);
        outputField.setEditable(false);
        outputPanel.add(outputField);
        container.add(outputPanel);
        setSize(400, 200);
        setVisible(true);
    }

    public static void exceptionHandler(Exception e) {
        String message = (e instanceof NumberFormatException) ?
                "Numbers only." :
                (e instanceof DuplicateValueException ||
                        e instanceof NumberNotFoundException) ?
                                e.getMessage() : "Unknown.";
        JOptionPane.showMessageDialog(
                null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    //execute application
    public static void main(String args[]) {
        ArrayAccess application = new ArrayAccess();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
