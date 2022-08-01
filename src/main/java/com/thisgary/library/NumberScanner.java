package com.thisgary.library;

import java.util.Scanner;
import java.util.function.Function;

// An object orientation of GetNumber.scan()
public class NumberScanner implements NumberGetter {
    private String onError;
    private Function<Number, Boolean> rules;
    private boolean persistent;

    // Constructors
    public NumberScanner(boolean persistent) {
        this.onError = "Invalid input!";
        this.rules = NO_RULES;
        this.persistent = persistent;
    }

    public NumberScanner() {
        this(true);
    }

    public NumberScanner(String onError, Function<Number, Boolean> rules) {
        this.onError = onError;
        this.rules = rules;
    }

    public NumberScanner(String onError, Function<Number, Boolean> rules, boolean persistent) {
        this(onError, rules);
        this.persistent = persistent;
    }

    // Setters
    public void setOnError(String onError) {
        this.onError = onError;
    }

    public void setRules(Function<Number, Boolean> rules) {
        this.rules = rules;
    }

    // Interface methods
    public String getString(String question) {
        System.out.print(question);
        return new Scanner(System.in).nextLine();
    }

    public void onError(Exception e) {
        System.out.println(onError);
    }

    public Number get(String question) {
        return get(question, this.rules);
    }

    // Extra methods
    public Integer getInt(String question) {
        Function<Number, Boolean> rules = (n) -> n.intValue() == n.doubleValue() && this.rules.apply(n);
        return get(question, rules).intValue();
    }
}