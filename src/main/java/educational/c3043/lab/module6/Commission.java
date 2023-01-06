package educational.c3043.lab.module6;

/*
Activity 3
----------
Write a simple program by using final class and method to calculate the commission of selling the
magazine for company XYZ Sdn. Bhd. The commission rate is MYR2.50 per selling magazine. Your
output should include person name, number of magazine sold and the commission amount.
 */

public final class Commission {
    private final String name;
    private final int megazines;

    public Commission(String name, int megazines) {
        this.name = name;
        this.megazines = megazines;
    }

    public String getName() {
        return name;
    }

    public int getMegazines() {
        return megazines;
    }

    public double getCommission() {
        return megazines * 2.5;
    }

    public String toString() {
        return "Name: " + name + ", Commission: RM2.5 * " + megazines + " = RM" + getCommission();
    }

    public static void main(String[] args) {
        Commission commission = new Commission("Ali", 69);
        System.out.println(commission);
    }
}
