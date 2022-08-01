package com.thisgary.library;

import java.util.Random;

public class Roast {
    public String context, burn;
    int count = 0;
    double luck;

    public Roast(String context) {
        this.context = context;
        this.burn = "Seriously, is it this hard to understand instructions?";
        this.luck = 0.8;
    }

    public Roast(String context, String burn, double luck) {
        this.context = context;
        this.burn = burn;
        this.luck = luck;
    }

    private boolean roll() {
        Random r = new Random();
        luck += Math.pow(2, -count++);
        return (r.nextFloat() > luck);
    }

    public void reset() {
        this.count = 0;
    }

    public String get() {
        if (roll()) {
            reset();
            return burn;
        } else {
            return context;
        }
    }

    public void print() {
        System.out.println(get());
    }

    public void print(String shadow) {
        this.context = shadow;
        System.out.println(get());
    }
}
