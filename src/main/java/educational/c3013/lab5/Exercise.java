package educational.c3013.lab5;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Exercise {
  public static void main(String[] args) {
    Deque<PhoneBook> deque = new ArrayDeque<>();
    deque.addFirst(new PhoneBook(1, "Register", "096684342"));
    deque.addLast(new PhoneBook(2, "Academy", "096684219"));
    deque.add(new PhoneBook(3, "Faculty", "096683220"));
    for (PhoneBook pb : deque) {
      System.out.println("Name: " + pb.getName());
      System.out.println("Phone number: " + pb.getPhoneNumber());
    }

    Scanner scanner = new Scanner(System.in);
    System.out.print("\nSearch name: ");
    String searchName = scanner.nextLine();
    boolean found = false;
    for (PhoneBook pb : deque)
      if (found = pb.getName().equals(searchName)) {
        System.out.println("Phone number: " + pb.getPhoneNumber());
        break;
      }
    if (!found) System.out.println("No record found for the given name.");
    scanner.close();
  }
}

class PhoneBook {
  private int id;
  private String name;
  private String phoneNumber;

  public PhoneBook(int id, String name, String phoneNumber) {
    this.id = id;
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}
