package educational.c3043.lab.module7;

import javax.swing.*;

import educational.lib.NumberGetter;

public class Division {
    int dividend;
    int divisor;

    public Division(int dividend, int divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public int getQuotient() {
        return dividend / divisor;
    }

    public int getRemainder() {
        return dividend % divisor;
    }

    public String toString() {
        return "Division: " + dividend + " / " + divisor + " = " +
                getQuotient() + " with remainder " + getRemainder();
    }

    public static void main(String[] args) {
        // Activity 1
//        int x = NumberScanner.jopInt("Enter a number: ", "Input");
//        int y = NumberScanner.jopInt("Enter another number: ", "Input");
//        Division d = new Division(x, y);
//        JOptionPane.showMessageDialog(null, d, "Division", JOptionPane.PLAIN_MESSAGE);

        // Activity 2
        boolean tryThis = true;
        int i = 0;
        while (tryThis) {
            int x = NumberGetter.jopInt("Enter a number: ", "Input");
            int y = NumberGetter.jopInt("Enter another number: ", "Input");
            Division d = new Division(x, y);
            try {
                JOptionPane.showMessageDialog(
                        null, d, "Try 0", JOptionPane.DEFAULT_OPTION);
                if (++i > 3)
                    JOptionPane.showMessageDialog(
                            null, "DO WHAT TITLE TOLD YOU OR I TRAP YOU IN LOOP, thank you.",
                            "Try 0", JOptionPane.DEFAULT_OPTION
                    );
            } catch (ArithmeticException e) {
                tryThis = false;
                JOptionPane.showMessageDialog(
                        null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                if (i > 3)
                    JOptionPane.showMessageDialog(
                            null, "", "Good Job", JOptionPane.ERROR_MESSAGE,
                            new ImageIcon("assets/img/heh.jpg"));
            }
        }
    }
}
