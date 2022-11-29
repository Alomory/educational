package com.garylkz.library;

import java.lang.reflect.Method;

public class Dumpster {
    public static int dayInMonth(int m, int y) {
        return (
                (m == 2) ?
                        (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) ? 29 : 28 :
                        (m % 2 == 0) ^ (m > 7) ? 30 : 31 // XOR
        );
    }

    public static boolean isDate(String YMD) {
        int y = Integer.parseInt(YMD.substring(0, 2));
        int d = Integer.parseInt(YMD.substring(4, 6));
        int m = Integer.parseInt(YMD.substring(2, 4));
        if (m > 12 || m < 1) return false;
        int maxDay = dayInMonth(m, y);
        return d >= 1 && d <= maxDay;
    }

    // prototype public static void method invoker
    public static void psvInvoker(String packageClassName, String methodName) throws Throwable {
        Method m = Class.forName(packageClassName).getMethod(methodName, (Class<?>[]) null);
        m.invoke(null, (Object[]) null);
    }

    public static String repeat(int length, String that) {
        return new String(new char[Math.max(1, length)]).replace("\0", that);
    }

    public static String repeatSpace(int length) {
        return repeat(length, " ");
    }

    public static int intLength(int i) {
        return String.valueOf(i).length();
    }

    public static double[] scanDoubleArray(String question, String subQuestion) {
        int i = NumberGetter.scanInt(question), j = 0;
        double[] ds = new double[i];
        while (j < i) {
            ds[j] = NumberGetter.scanDouble(subQuestion + ++j + ": ");
        }
        return ds;
    }

    public static void tablePrintEven(String[][] table, int space) {
        for (String[] row : table) {
            for (String cell : row) System.out.print(cell + Dumpster.repeatSpace(space - cell.length()));
            System.out.println();
        }
    }
}
