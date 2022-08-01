package com.thisgary.library;

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.function.Function;

import static com.thisgary.library.NumberGetter.NO_RULES;

public class GetNumber {
    // From console
    public static Number scan(String question, String onError, Function<Number, Boolean> rules) {
        Scanner s = new Scanner(System.in);
        NumberGetter ng = new NumberGetter() {
            public String getString(String question) {
                System.out.print(question);
                return s.nextLine();
            }

            public void onError(Exception e) {
                System.out.println(onError);
            }
        };
        return ng.get(question, rules);
    }

    public static Number scan(String question, String onError) {
        return scan(question, onError, NO_RULES);
    }

    public static int scanInt(String question, String onError, Function<Number, Boolean> rules) {
        return scan(question, onError, rules).intValue();
    }

    public static int scanInt(String question) {
        return scanInt(question, "Invalid integer", NO_RULES);
    }

    public static double scanDouble(String question, String onError, Function<Number, Boolean> rules) {
        return scan(question, onError, rules).doubleValue();
    }

    public static double scanDouble(String question) {
        return scanDouble(question, "Invalid double", NO_RULES);
    }

    // From JOptionPane
    public static Number jop(
            String question,
            String title,
            String onError,
            Function<Number, Boolean> rules
    ) {
        NumberGetter ng = new NumberGetter() {
            public String getString(String question) {
                String input = JOptionPane.showInputDialog(
                        null,
                        question,
                        title,
                        JOptionPane.QUESTION_MESSAGE
                );
                if (input == null)
                    System.exit(0);
                return input;
            }

            public void onError(Exception e) {
                JOptionPane.showMessageDialog(
                        null,
                        onError,
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        };
        return ng.get(question, rules);
    }

    public static Number jop(String question, String title, String onError) {
        return jop(question, title, onError, NO_RULES);
    }

    public static int jopInt(String question, String title, String onError, Function<Number, Boolean> rules) {
        return jop(question, title, onError, rules).intValue();
    }

    public static int jopInt(String question, String title) {
        return jopInt(question, title, "Invalid integer", NO_RULES);
    }

    public static double jopDouble(String question, String title, String onError, Function<Number, Boolean> rules) {
        return jop(question, title, onError, rules).doubleValue();
    }

    public static double jopDouble(String question, String title) {
        return jopDouble(question, title, "Invalid double", NO_RULES);
    }
}
