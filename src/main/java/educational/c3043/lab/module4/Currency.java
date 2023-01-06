package educational.c3043.lab.module4;

import educational.lib.NumberGetter;

public class Currency {
    private double myr;
    private double pound;

    public Currency(double myr) {
        this.myr = myr;
        this.pound = myr / 4.320;
    }

    public double getMyr() {
        return myr;
    }

    public double getPound() {
        return pound;
    }

    public static void main(String[] args) {
        double myr = NumberGetter.scanDouble("MYR: ");
        Currency currency = new Currency(myr);
        System.out.println("Pound: " + currency.getPound() + "\n");
    }
}
