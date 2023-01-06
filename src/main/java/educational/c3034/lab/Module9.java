package educational.c3034.lab;

import java.text.DecimalFormat;
import java.util.Arrays;

import educational.lib.Dumpster;
import educational.lib.NumberGetter;

public class Module9 {
    public static void activity1() {
        DecimalFormat df = new DecimalFormat("0.00");
        double[] sales = Dumpster.scanDoubleArray("Number of sales: ", "Sales ");
        System.out.println();

        String[][] table = new String[sales.length + 1][5];
        String[] legend = {"SALES", "CEIL", "FLOOR", "SQUARE ROOT", "RADIAN"};
        table[0] = legend;
        for (int i = 0; i < sales.length; ) {
            double d = sales[i++];
            table[i][0] = df.format(d);
            table[i][1] = df.format(Math.ceil(d));
            table[i][2] = df.format(Math.floor(d));
            table[i][3] = df.format(Math.sqrt(d));
            table[i][4] = df.format(Math.toRadians(d));
        }
        Dumpster.tablePrintEven(table, 15);
    }

    public static void activity2() {
        Module2.calculate_kilometre();
    }

    public static void activity3() {
        Module7.activity3();
    }

    // Activity 4 requirements
    private static double[] read_Input() {
        double[] scores = new double[5];
        for (int i = 0; i < 5; ) scores[i] = NumberGetter.scanDouble("Score " + ++i + ": ");
        return scores;
    }

    //    private static String[] identify_Grade(double[] scores) {
    private static String identify_Grade(double s) {
//        String[] grades = new String[scores.length];
//        int i = 0;
//        for (double s : scores)
//            grades[i++] = (s > 100 || s <= 0) ? "X" : (s >= 80) ? "A" : (s >= 70) ? "B" : (s >= 50) ? "C" : (s >= 40) ? "D" : "F"; // Short circuit logic
        return (s > 100 || s <= 0) ? "X" : (s >= 80) ? "A" : (s >= 70) ? "B" : (s >= 50) ? "C" : (s >= 40) ? "D" : "F";
    }

    private static double calculate_Average(double[] scores) {
        return Arrays.stream(scores).average().getAsDouble();
    }

    public static void activity4() {
        double[] scores = read_Input();
        System.out.println("\nSCORE, GRADE");
        for (double s : scores) System.out.println(String.format("%.2f, %s", s, identify_Grade(s)));
        System.out.println("\nAVERAGE");
        double average = calculate_Average(scores);
        System.out.println(String.format("%.2f, %s", average, identify_Grade(average)));
    }

    public static void activity5() {
        String[][] table = new String[202][5];
        String[] legend = {"Taxable Income", "Single", "Married Joint", "Married Separate", "Head of a House"};
        table[0] = legend;
        for (int i = 0; i < 201; ) {
            int j = 50000 + 50 * i++;
            table[i][0] = String.valueOf(j);
            table[i][1] = String.valueOf((int) (j * 0.17));
            table[i][2] = String.valueOf((int) (j * 0.15));
            table[i][3] = String.valueOf((int) (j * 0.18));
            table[i][4] = String.valueOf((int) (j * 0.16));
        }
        Dumpster.tablePrintEven(table, 20);
    }
}
