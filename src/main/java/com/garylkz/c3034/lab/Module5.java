package com.garylkz.c3034.lab;

import com.garylkz.library.Dumpster;
import com.garylkz.library.GetNumber;
import com.garylkz.library.Roast;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.regex.Pattern;

public class Module5 {
    public static void activity1() throws Throwable {
        // I already did it in module 4, yes, with year identifying
        Dumpster.psvInvoker(
                "com.thisgary.lab.Module4",
                "Activity3"
        );
    }

    public static void activity2() {
        int s;
        do {
            s = GetNumber.scanInt("Sales: RM");
            if (s < 0) {
                System.out.println("Impossible.");
            }
        } while (s < 0);
        double r = s * ((s <= 10000) ? 0.1 : (s <= 15000) ? 0.15 : 0.2);
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Sales Commission: RM" + df.format(r));
    }

    public static void activity3() {
        Scanner s = new Scanner(System.in);
        Roast r = new Roast(null);

        int id;
        boolean c;
        double min, bal, nbal;
        String ph;
        char t;

        do { //TODO:Redundancy
            id = GetNumber.scanInt("Account number? ");
            c = id < 1;
            if (c) r.print("Invalid account number.");
        } while (c);

        do {
            do {
                System.out.print("Account type (S/C)? ");
                ph = s.nextLine();
                c = ph.length() < 1;
                if (c) r.print("Don't say lazy.");
            } while (c);
            t = ph.toUpperCase().charAt(0); // more forgiving
            c = !(t == 'S' || t == 'C');
            if (c) r.print("S or C ONLY");
        } while (c);

        do {
            min = GetNumber.scanInt("Minimum balance? RM");
            c = min < 1;
            if (c) r.print("The bank would go bankrupt.");
        } while (c);

        do {
            bal = GetNumber.scanInt("Current balance? RM");
            c = bal < 1;
            if (c) r.print("Impossible.");
        } while (c);

        // if saving, 0.04; else if bal < 5000, 0.05; else 0.03 (assume C)
        // cases where t is not C is theoretically impossible (refer line 55)
        nbal = bal * (1 + ((t == 'S') ? 0.04 : (bal < 5000) ? 0.05 : 0.03));
        DecimalFormat rm = new DecimalFormat("0.00");
        System.out.println("Account number: " + id);
        System.out.println(
                "Account type: " + ((t == 'S') ? "Saving" : "Checking")
        );
        System.out.println("\n-Account Info-");
        System.out.println("Minimum balance: RM" + rm.format(min));
        System.out.println("Account balance: RM" + rm.format(bal));
        System.out.println("Account balance (new): RM" + rm.format(nbal));
    }

    public static void activity4() {
        String date;
        String day = "", month = "", year = "";
        int d, m, y, h;
        do {
            String p = "([0-9]+/[0-9]+/[0-9]+|[0-9]+-[0-9]+-[0-9]+)";
            date = JOptionPane.showInputDialog(
                    null,
                    "Input date",
                    "Activity 4",
                    JOptionPane.QUESTION_MESSAGE
            );
            if (Pattern.matches(p, date)) {
                day = date.substring(0, 2);
                month = date.substring(3, 5);
                year = date.substring(8, 10);
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "DD/MM/YYYY or DD-MM-YYYY",
                        "Activity 4",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        } while (!(Dumpster.isDate(day + month + year))); //TODO: Update isDate(), anti-pattern
        y = Integer.parseInt(year);
        m = Integer.parseInt(month);
        d = Integer.parseInt(day);
        h = (d + (13 * (m + 1) / 5) + y + y / 4 - y / 100 + y / 400) & 7;
        String engurish = "???";
        switch (h) { // hilariously redundant
            case 1:
                engurish = "Sunday";
                break;
            case 2:
                engurish = "Monday";
                break;
            case 3:
                engurish = "Tuesday";
                break;
            case 4:
                engurish = "Wednesday";
                break;
            case 5:
                engurish = "Thursday";
                break;
            case 6:
                engurish = "Friday";
                break;
            case 0:
                engurish = "Saturday";
                break;
            default:
                System.out.println("Heimday");
                break;
        }
        JOptionPane.showMessageDialog(
                null,
                "Today is " + engurish,
                "Activity 4",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void activity5() {
        Scanner s = new Scanner(System.in);
        Roast r = new Roast(null);

        String name;
        int wood, length, color, price;

        Supplier<String> getName = () -> {
            System.out.print("Name? ");
            return s.nextLine();
        };

        Supplier<Integer> getWood = () -> {
            System.out.println("Wood type");
            System.out.println("1 - Oak");
            System.out.println("2 - Mahogany");
            return GetNumber.scanInt("Choice (by index)? ");
        };

        Supplier<Integer> getLength = () -> GetNumber.scanInt("Number of characters? ");

        Supplier<Integer> getColor = () -> {
            System.out.println("Color");
            System.out.println("1 - Black & White");
            System.out.println("2 - gold-leaf lettering");
            return GetNumber.scanInt("Choice (by index)? ");
        };

        name = getName.get();
        if (name.length() < 1) {
            name = "Anonymous";
        }

        wood = getWood.get();
        while (wood < 1 || wood > 2) {
            r.print("Your lucky number?.");
            wood = getWood.get();
        }

        length = getLength.get();
        while (length < 1) {
            r.print("Why are you even here?");
            length = getLength.get();
        }

        color = getColor.get();
        while (color < 1 || color > 2) {
            r.print("Not in list.");
            color = getColor.get();
        }

        price = 30 + ((wood == 1) ? 15 : 10) + ((length > 6) ? (length - 6) * 3 : 0) + ((color == 1) ? 0 : 15);
        System.out.println("Total charge for " + name + ": RM" + price);
    }
}
