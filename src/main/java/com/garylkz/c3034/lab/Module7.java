package com.garylkz.c3034.lab;

import com.garylkz.library.Dumpster;
import com.garylkz.library.GetNumber;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.function.Function;

public class Module7 {
    public static void activity1() {
        // Lab Module 6, sigh
        {
            int i, p, n, j;
            p = n = j = 0;
//            while (true) {
            do {
                i = GetNumber.scanInt("Next int: ");
                if (i > 0) {
                    p += 1;
                } else if (i < 0) {
                    n += 1;
                } else {
                    break;
                }
                j += i;
//            }
            } while (true);
            System.out.println("Positive count: " + p);
            System.out.println("Negative count: " + n);
            System.out.println("Sum: " + j);
        } // Activity 1
        {
            System.out.println("Kilogram    Pounds");
            int kg = 1;
//            while (kg < 200) {
            do {
                int s = 12 - String.valueOf(kg).length();
                StringBuilder space = new StringBuilder();
                while (s > 0) {
                    space.append(" ");
                    s--;
                }
                DecimalFormat df = new DecimalFormat("0.0");
                System.out.println(kg + space.toString() + df.format(kg * 2.2));
                kg += 2;
//            }
            } while (kg < 200);
        } // Activity 2
        {
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
//            while (i <= j) {
            do {
                if (i % 2 == 0) {
                    even.add(i++);
                } else {
                    odd.add(i++);
                }
//            }
            } while (i <= j);

            System.out.print("Odd list: ");
            for (Object o : odd) System.out.print(o + " ");
            System.out.println();

            System.out.print("Even list: ");
            for (Object e : even) System.out.print(e + " ");
            System.out.println();
        } // Activity 3
        {
            double fee = 4000;
            double rate = 1.05;
            int i = 0; // year 0 - original fee
            DecimalFormat rm = new DecimalFormat("0.00");
            do {
                System.out.println("Year " + i + " fee: RM" + rm.format(fee * Math.pow(rate, i++)));
            } while (i <= 10);
        } // Activity 4
        {
            final String[] months = {
                    "January", "February", "March", "April", "May", "June", "July",
                    "August", "September", "October", "November", "December"
            };
            int _a, a, u, m; // *, 20, 15, 12
            _a = a = 1;
            StringBuilder sb = new StringBuilder();
            do {
                sb.append("-");
                _a++;
            } while (_a <= 134);
            final String ___ = sb.toString();
            final String template = sb
                    .append(___ + "\n")
                    .append("Payment Coupon for %s\n")
                    .append("Building No: %s    Unit No: %s\n\n")
                    .append("Amount of Rent: RM 800.00\n")
                    .append("Rent Due: %s/%s/2021").toString();
            do {
                u = 1;
                do {
                    m = 1;
                    do {
                        System.out.println(String.format(template, months[m - 1], a, u, Dumpster.dayInMonth(m, 2021), m++));
                    } while (m <= 12);
                    u++;
                } while (u <= 15);
                a++;
            } while (a <= 20);
        } // Activity 5
    }

    public static void activity2() {
        int i = Math.abs(GetNumber.scanInt("Give an int (more than 1 digit pls): "));
        for (char c : String.valueOf(i).toCharArray()) System.out.print(c + " ");
    }

    public static void activity3() {
        int i = Math.abs(GetNumber.scanInt("Give an int (less than 1 digit pls): "));

        String a, b;
        a = b = "";

        String[] as = new String[i];
        String[] bs = new String[i];

        for (int j = 0; j < i; j++) {
            as[j] = a = a + (j + 1) + " ";
            bs[j] = b = " " + (j + 1) + b;
        }

        final String c = a;
        final String PAD = Dumpster.repeatSpace(Dumpster.intLength(i) + 2);

        Function<Integer, String> fill = (l) -> Dumpster.repeatSpace(c.substring(as[l].length()).length());

        for (int j = 0; j < i; j++) {
            int k = i - 1 - j;

            System.out.print(as[j]);
            System.out.print(fill.apply(j));

            System.out.print(PAD);

            System.out.print(as[k]);
            System.out.print(fill.apply(k));

            System.out.print(PAD);

            System.out.print(fill.apply(j));
            System.out.print(bs[j]);

            System.out.print(PAD);

            System.out.print(fill.apply(k));
            System.out.println(as[k]);
        }
    }
}
