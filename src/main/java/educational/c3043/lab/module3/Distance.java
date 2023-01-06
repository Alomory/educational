package educational.c3043.lab.module3;

import educational.lib.NumberGetter;

public class Distance {
    private double miles;
    private double km;

    public Distance() {
    }

    public Distance(double miles) {
        this.miles = miles;
        calculateKm();
    }

    private void calculateKm() {
        km = miles * 1.609344;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }

    public double getKm() {
        return km;
    }

    public void overview() {
        System.out.println("The distance in miles is " + miles);
        System.out.println("The distance in kilometers is " + getKm() + "\n");
    }

    public static void main(String[] args) {
        NumberGetter scanner = new NumberGetter();
        double miles = scanner.get("Enter the distance in miles: ").doubleValue();
        Distance distance = new Distance(miles);
        distance.overview();
        miles = scanner.get("Enter the distance in miles: ").doubleValue();
        distance.setMiles(miles);
        distance.overview();
    }
}
