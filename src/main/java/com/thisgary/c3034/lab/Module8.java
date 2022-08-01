package com.thisgary.c3034.lab;

import com.thisgary.library.Dumpster;
import com.thisgary.library.GetNumber;

import java.util.Arrays;

public class Module8 {
    public static void activity1() {
        int[] i = new int[5];
        for (int j = 0; j < 5; j++) i[j] = GetNumber.scanInt("Input " + (j + 1) + ": ");
        System.out.println(Arrays.toString(i));
        System.out.println("Max: " + Arrays.stream(i).max().getAsInt());
    }

    public static void activity2() {
        int i = GetNumber.scanInt("Number of students: ");
        int[] scores = new int[i];
        for (int k = 0; k < i; k++) scores[k] = GetNumber.scanInt("Student " + (k + 1) + " score: ");
        int[] scores_ = scores.clone();
        Arrays.sort(scores_);
        int best = scores_[scores.length - 1];
        char[] _grades = {'A', 'B', 'C', 'D', 'E', 'F'};
        char[] grades = new char[i];
        for (int k = 0; k < i; k++) {
            int l = 0;
            while (scores[k] < best - 10 * ++l && l < 6) ;
            grades[k] = _grades[l - 1];
        }
        int z = Math.max(7, Dumpster.intLength(scores.length));
        System.out.println("Student" + Dumpster.repeatSpace(z) + "  Score  Grade");
        for (int k = 0; k < i; k++) {
            System.out.print(k + 1 + Dumpster.repeatSpace(z + 2 - Dumpster.intLength(k)));
            System.out.print(scores[k] + Dumpster.repeatSpace(7 - Dumpster.intLength(scores[k])));
            System.out.println(grades[k]);
        }
    }

    public static void activity3() {
        double[] ds = new double[50];
        for (int i = 0; i < 50; i++) ds[i] = (i > 24) ? i * 3 : Math.pow(i, 2);
        int i = 1;
        for (double d : ds) System.out.print(d + ((i++ % 10 != 0) ? " " : "\n"));
    }

    public static void activity4() {
        int[][] i = {{78, 90, 40, 75}, {90, 83, 75, 68}, {40, 80, 53, 69}, {75, 80, 98, 95}, {64, 50, 41, 70}};
        int k = 1;
        // The program should be able to find and **display the total marks** for each student.
        for (int[] j : i) System.out.println("Student " + k++ + ": " + Arrays.stream(j).sum());
    }

    public static void activity5() {
        double[][] months = new double[2][12];
        for (int i = 0; i < 12; i++) {
            System.out.println("Month " + (i + 1));
            months[0][i] = GetNumber.scanDouble("Highest temperature: ");
            months[1][i] = GetNumber.scanDouble("Lowest temperature: ");
        }
        System.out.println("Hottest hot: " + Arrays.stream(months[0]).max() + "C");
        System.out.println("Coldest cold: " + Arrays.stream(months[1]).min() + "C");
        System.out.println("Avg. hottest: " + Arrays.stream(months[0]).average() + "C");
        System.out.println("Avg. coldest: " + Arrays.stream(months[1]).average() + "C");
    }
}
