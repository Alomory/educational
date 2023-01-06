package educational.c3034.lab;

import java.util.Scanner;

import educational.lib.NumberGetter;
import educational.lib.Roast;

public class Module2 {
    public static void activity2() {
        System.out.println("[confidential]");
        System.out.println("Faculty of Ocean Engineering Technology and Informatics");
        System.out.println("Mobile Computing");
    }

    public static void activity5() {
        double sum = 0;
        for (int i = 0; i < 3; i++) {
            double score;
            do {
                score = NumberGetter.scanDouble("Score " + (i + 1) + ": ");
                if (score > 100 || score < 0) {
                    System.out.println("Not valid score.");
                } else {
                    sum += score;
                }
            } while (score > 100);
        }
        double average = sum / 3;
        final boolean ss = average > 95;
        String o = (ss) ?
                "You are being congratulated enthusiastically." :
                "Oh well, you tried.";
        String b = (ss) ?
                "Not really, it is supposed to be your responsibility." :
                "Get good next time.";
        Roast r = new Roast(o, b, 0.5);
        r.print();
    }

//    public static void Activity6() { // Modify pseudocode in Module 2 (Activity 6)
    public static void calculate_kilometre() { // Write a method called calculate_kilometre()
        boolean engineStarted = true;
        double mph0 = 0, mph, dMph, kmh;
        while (engineStarted) {
            mph = NumberGetter.scanDouble("M/H (below 130)? ");
            if (mph > 0) {
                dMph = Math.abs(mph - mph0);
                boolean inc10 = (dMph >= 10), b130 = (mph <= 130);
                if (inc10 && b130) {
                    mph0 = mph;
                    kmh = mph / 0.6214;
                    System.out.println(kmh + "KM/H");
                }
            } else {
                System.out.print("Engine still up (true/false)? ");
                Scanner t = new Scanner(System.in);
                engineStarted = Boolean.parseBoolean(t.nextLine());
                t.close();
            }
        }
        System.out.println("Car stopped.");
    }
}