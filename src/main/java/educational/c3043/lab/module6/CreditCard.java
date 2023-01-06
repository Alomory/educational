package educational.c3043.lab.module6;

/*
Activity 4
----------
Write a program to demonstrate the use of interface via class CreditCard(). Credit card has credit card
number, transaction date, transaction description and transaction amount. The interface Payment()
has a method to calculate the current payment amount of credit card that has to be paid for a month.
Your output should display a credit card statement for a month in which consists of credit card number,
several transaction details, total of transaction amounts and the current payment amount.

Credit card has credit card number, transaction date, transaction description and transaction amount.
 */
public class CreditCard implements Payment {
    private final String creditCardNumber;
    private final String transactionDate;
    private final String transactionDescription;
    private final double transactionAmount;
    static int currentMonth = 0;
    static double totalAmount = 0;

    public CreditCard(String creditCardNumber, String transactionDate, String transactionDescription, double transactionAmount) {
        this.creditCardNumber = creditCardNumber;
        this.transactionDate = transactionDate;
        this.transactionDescription = transactionDescription;
        this.transactionAmount = transactionAmount;

        int k = transactionDate.indexOf("/") + 1;
        int thisMonth = Integer.parseInt(transactionDate.substring(k, k + 2));
        if (currentMonth != thisMonth) {
            currentMonth = thisMonth;
            totalAmount = transactionAmount;
        } else
            totalAmount += transactionAmount;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    @Override
    public double calculatePayment() {
        return totalAmount;
    }

    public String toString() {
        return "Number: " + creditCardNumber +
                ", Date: " + transactionDate +
                ", Description: " + transactionDescription +
                ", Amount: " + transactionAmount +
                ", Month Total: " + totalAmount;
    }

    public static void main(String[] args) {
        CreditCard transaction1 = new CreditCard(
                "123456789", "01/01/2020", "Lmao", 100);
        System.out.println(transaction1);
        CreditCard transaction2 = new CreditCard(
                "123456789", "02/01/2020", "Kek", 200);
        System.out.println(transaction2);
        CreditCard transaction3 = new CreditCard(
                "123456789", "01/02/2020", "Lol", 100);
        System.out.println(transaction3);
    }
}
