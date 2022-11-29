package com.garylkz.c3034.lab;

import com.garylkz.library.Dumpster;
import com.garylkz.library.NumberGetter;

import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;
import java.util.regex.Pattern;

public class Module4 {
    public static void activity1() {
        Function<Integer, Integer> p = (i) -> (int) Math.pow(i, 2); //i*i;

        int i1 = NumberGetter.scanInt("First number: ");
        int i2 = NumberGetter.scanInt("Second number: ");
        final String sqr = "Square of %s: %s%n";
        int p1 = p.apply(i1);
        int p2 = p.apply(i2);

        System.out.printf(sqr, i1, p1);
        System.out.printf(sqr, i2, p2);
        System.out.printf("Sum of squares: %s%n", p1 + p2);
        System.out.printf("Difference of squares: %s%n", Math.abs(p1 - p2));
    }

    public static void activity2() {
        double r = NumberGetter.jop(
                "Radius?",
                "Activity 2",
                "Float only"
        ).floatValue();
        final double pi = 3.14159;
        double[] j = {2 * r, 2 * pi * r, pi * r * r};
        String[] k = {"Diameter", "Circumference", "Area"};
        for (int i = 0; i < 3; i++) {
            JOptionPane.showMessageDialog(
                    null,
                    String.format("%s: %s", k[i], j[i]),
                    "Activity 2",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    public static void activity3() {
        Runnable fakeIcDetected = () -> JOptionPane.showMessageDialog(
                null,
                "'Whoever possess fake identity card will face punishment listed under the Security Offences (Special Measures) Act 2012 (Sosma).'",
                "Fake IC Detected",
                JOptionPane.WARNING_MESSAGE
        );
        String ic = JOptionPane.showInputDialog(
                null,
                "IC please.",
                "Activity 3",
                JOptionPane.QUESTION_MESSAGE
        );
        final String p = "([0-9]{6}-[0-9]{2}-[0-9]{4}|[0-9]{12})";
        if (Pattern.matches(p, ic)) {
            String date = ic.substring(0, 6);
            if (!Dumpster.isDate(date)) {
                fakeIcDetected.run();
                return;
            }
            int dcd = Integer.parseInt(date.substring(0, 2));
            String yNow = new SimpleDateFormat("yyyy").format(new Date());
            int dNow = Integer.parseInt(yNow.substring(0, 2));
            int age = dNow - dcd;
            if (dcd > dNow) {
                age += 100; // assume humon ded at 100
                // System.out.println("DEBUG: 19th century");
            } else {
                // System.out.println("DEBUG: 20th century");
            }
            JOptionPane.showMessageDialog(
                    null,
                    "Your age is (probably) " + age,
                    "Activity 3",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else fakeIcDetected.run();
    }

    public static void activity4() {
        String input = JOptionPane.showInputDialog(
                null,
                "Input?",
                "Activity 4",
                JOptionPane.QUESTION_MESSAGE
        );
        JOptionPane.showMessageDialog(
                null,
                input.toUpperCase(),
                "Activity 4",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void activity5() {
        final String a5 = "Activity 5";
        double d = NumberGetter.jopInt("Distance in meter(s)", a5);
        double h = NumberGetter.jopInt("Hour(s)", a5);
        double m = NumberGetter.jopInt("Minute(s)", a5);
        double s = NumberGetter.jopInt("Second(s)", a5);
        double S = h * 60 * 60 + m * 60 + s;
        double mps = d / S;
        double km = d / 1000;
        double H = h + m / 60 + (s / 60) / 60;
        double kmph = km / H;
        double mi = d / 1609;
        double mph = mi / H;
        JOptionPane.showMessageDialog(
                null,
                mps + "m/s\n"
                        + kmph + "km/h\n"
                        + mph + "mi/h",
                a5,
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void activity6() {
        double[] xs = new double[3];
        double sum = 0, mean = 0, variance = 0, deviation = 0;
        for (int i = 0; i < 3; i++) {
            xs[i] = NumberGetter.scanDouble("Number " + (i + 1) + ": ");
            sum += xs[i];
        }
        mean = sum / 3;
        for (double x : xs) {
            variance += Math.pow(x - mean, 2);
        }
        variance /= 3;
        deviation = Math.sqrt(variance);
        System.out.println("Mean: " + mean);
        System.out.println("Variance: " + variance);
        System.out.println("Standard Deviation: " + deviation);
    }
}
