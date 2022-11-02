package com.garylkz.c3034.lab;

import com.garylkz.library.Dumpster;
import com.garylkz.library.GetNumber;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Module6 {
    public static void activity1() {
        int i, p, n, j;
        p = n = j = 0;
        while (true) {
            i = GetNumber.scanInt("Next int: ");
            if (i > 0) {
                p += 1;
            } else if (i < 0) {
                n += 1;
            } else {
                break;
            }
            j += i;
        }
        System.out.println("Positive count: " + p);
        System.out.println("Negative count: " + n);
        System.out.println("Sum: " + j);
    }

    public static void activity2() {
        System.out.println("Kilogram    Pounds");
        int kg = 1;
        while (kg < 200) {
            int s = 12 - String.valueOf(kg).length();
            StringBuilder space = new StringBuilder();
            while (s > 0) {
                space.append(" ");
                s--;
            }
            DecimalFormat df = new DecimalFormat("0.0");
            System.out.println(kg + space.toString() + df.format(kg * 2.2));
            kg += 2;
        }
    }

    public static void activity3() {
        int i, j;
        boolean c;
        do {
            i = GetNumber.scanInt("First int: ");
            j = GetNumber.scanInt("Second int: ");
            c = (i > j);
            if (c) {
                System.out.println("First integer must be smaller than the second one\n");
            }
        } while (c);

        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        while (i <= j) {
            if (i % 2 == 0) {
                even.add(i++);
            } else {
                odd.add(i++);
            }
        }

        System.out.print("Odd list: ");
        for (Object o : odd) System.out.print(o + " ");
        System.out.println();

        System.out.print("Even list: ");
        for (Object e : even) System.out.print(e + " ");
        System.out.println();
    }

    public static void activity4() {
        double fee = 4000;
        double rate = 1.05;
        int i = 0; // year 0 - original fee
        DecimalFormat rm = new DecimalFormat("0.00");
        while (i <= 10) System.out.println("Year " + i + " fee: RM" + rm.format(fee * Math.pow(rate, i++)));
    }

    public static void activity5() {
        final String[] months = {
                "January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"
        };
        int _a, a, u, m; // *, 20, 15, 12
        _a = a = 1;
        StringBuilder sb = new StringBuilder();
        while (_a <= 134) {
            sb.append("-");
            _a++;
        }
        final String ___ = sb.toString();
        final String template = sb
                .append(___ + "\n")
                .append("Payment Coupon for %s\n")
                .append("Building No: %s    Unit No: %s\n\n")
                .append("Amount of Rent: RM 800.00\n")
                .append("Rent Due: %s/%s/2021").toString();
        while (a <= 20) {
            u = 1;
            while (u <= 15) {
                m = 1;
                while (m <= 12) {
                    System.out.println(String.format(template, months[m - 1], a, u, Dumpster.dayInMonth(m, 2021), m++));
                }
                u++;
            }
            a++;
        }
    }
}
