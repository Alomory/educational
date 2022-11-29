package com.garylkz.c3034.lab;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

import com.garylkz.library.NumberGetter;

public class Module3 {
    public static void activity1() {
        int wage = NumberGetter.scanInt("Wage (per hour)? ");
        int hour = NumberGetter.scanInt("Working time (in hours)? ");
        int gross = hour * wage;
        JOptionPane.showMessageDialog(null, "Gross pay: RM" + gross);
    }

    public static void activity2() {
        System.out.println("*****************************************************");
        System.out.println("MY CELL PHONE OVERAGE FEE");
        System.out.println("*****************************************************");
        int callTime = NumberGetter.scanInt("ENTER THE NUMBER OF EXCESS MINUTES: ");
        double overcharge = (callTime > 700) ? (callTime - 700) * 0.35 : 0;
        DecimalFormat rm = new DecimalFormat("0.00");
        System.out.println("OVERAGE FEE = RM" + rm.format(overcharge));
        /*
        int callTime = Dumpster.guiInt(
                "How much your call time is? (in minutes)",
                "Activity 3"
        );
        double overcharge = (callTime > 700) ? (callTime - 700) * 0.35 : 0;
        JOptionPane.showMessageDialog(
                null,
                "Overcharge: RM" + rm.format(overcharge),
                "Activity 3",
                JOptionPane.INFORMATION_MESSAGE
        );
         */
    }

    public static void activity3() {
        double Celsius = (double) NumberGetter.jopDouble("Temperature in Celsius?", "Activity3");
        double Fahrenheit = 1.8 * Celsius + 32;
        JOptionPane.showMessageDialog(
                null,
                "Temperature in Fahrenheit: " + Fahrenheit,
                "Activity 3",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void activity4() {
        System.out.println("*****************************************************");
        System.out.println("MY SAVING FORECAST PROGRAM");
        System.out.println("*****************************************************");
        int F = NumberGetter.scanInt(
                "WHAT IS THE VALUE YOU WANT TO HAVE IN YOUR ACCOUNT? "
        );
        int n = NumberGetter.scanInt(
                "HOW MANY YEARS YOU WANT THE MONEY TO SIT IN YOUR ACCOUNT? "
        );
        float r = NumberGetter.scan(
                "WHAT IS THE ANNUAL INTEREST RATE (IN %)? ",
                "Float only"
        ).floatValue();
        double P = F / Math.pow(1 + r, n);
        DecimalFormat rm = new DecimalFormat("0.00");
        System.out.println("THE AMOUNT YOU NEED TO DEPOSIT TODAY IS RM" + rm.format(P));
    }

    public static void activity5() {
        double weight = NumberGetter.jopDouble("Your weight? (in kg) ", "Activity 5");
        double height = NumberGetter.jopDouble("Your height? (in m) ", "Activity 5");
        double bmi = weight / Math.pow(height, 2);
        JOptionPane.showMessageDialog(
                null,
                "Your BMI: " + bmi,
                "Activity 5",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void activity6() {
        double price = NumberGetter.jopDouble("Product price? (in RM)", "Activity 6");
        double cost = price * 1.06;
        DecimalFormat rm = new DecimalFormat("0.00");
        JOptionPane.showMessageDialog(
                null,
                "Total cost of product = RM" + rm.format(cost),
                "Activity 5",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
