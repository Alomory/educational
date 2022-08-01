package com.thisgary.library;

import java.util.function.Function;

public interface NumberGetter {
    // Predefined values
    public static Function<Number, Boolean> NO_RULES = (Number n) -> true;

    String getString(String question);

    void onError(Exception e);

    default Number get(String question, Function<Number, Boolean> rules, boolean persistent) {
        while (persistent) {
            String s = getString(question); // Get string input
            try {
                Number n = Double.parseDouble(s);
                if (!rules.apply(n))
                    throw new NumberFormatException(); // If rules not met, throw exception
                return n;
            } catch (NumberFormatException e) {
                onError(e);
            }
        }
        return 0;
    }

    default Number get(String question, Function<Number, Boolean> rules) {
        return get(question, rules, true);
    }
}
