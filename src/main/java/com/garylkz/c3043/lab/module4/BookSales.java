package com.garylkz.c3043.lab.module4;

/*
Exercise
--------
Customer who buying the books will entitle for specified discount. Customer, who has a membership,
will receive 15% discount. There are two (2) types of a book. For beginner level, the price is RM50.00
and RM100.00 for advanced level.
The program must have three (3) constructors, including default constructor. The second constructor is
used to find the price per book based on the type of book key-in by the user.
The third constructor is used to calculate the total amount customer needs to pay after he/she key-in
the information such as membership (Y/N), type of book (A-advanced, B-beginner) and quantity of a
book bought.
You need to write the program called BookSales.java and using the main class to display the price for each
type of the book and display the quantity of the book customer bought and total amount customer needed
to pay
 */

public class BookSales {
    private double price;
    private boolean membership;
    private int quantity;

    public BookSales() {
        System.out.println("Not sure why this exists, but whatever");
    }

    public BookSales(char bookType) {
        switch (bookType) {
            case 'A':
                price = 100.00;
                break;
            case 'B':
                price = 50.00;
                break;
            default:
                price = 0.00;
                System.out.println("Invalid book type");
                break;
        }
    }

    public BookSales(char bookType, boolean membership, int quantity) {
        this(bookType);
        this.membership = membership;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public boolean getMembership() {
        return membership;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return price * quantity;
    }

    public double getDiscount() {
        if (membership) {
            return getTotal() * 0.15;
        } else {
            return 0.00;
        }
    }

    public double getNetTotal() {
        return getTotal() - getDiscount();
    }

    public void overview() {
        System.out.println("Price per book: " + getPrice());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Total: " + getTotal());
        System.out.println("Discount: " + getDiscount());
        System.out.println("Net Total: " + getNetTotal());
    }

    public static void main(String[] args) {
        BookSales bookSales = new BookSales('A', true, 69);
        bookSales.overview();
        System.out.println("");
    }
}
