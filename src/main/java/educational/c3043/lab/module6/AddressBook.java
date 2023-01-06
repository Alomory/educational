package educational.c3043.lab.module6;

import educational.c3043.lab.module3.Date;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
Exercise
--------
Using classes, design an online address book to keep track of the names, addresses, phone numbers,
and birthdays of family members, close friends, and certain business associates. Your program should
be able to handle a maximum of 500 entries.

The program should perform the following operations:
- Store the data according to the categories. (It contradicts with point 4.)
- Sort the address book by last name.
- Search for a person by last name.
- Search for a person by category
- Print the address, phone number, and date of birth (if available) of a given person.
 */

interface ForNoReason {
    ExtPerson getContactByName(String name);

    ExtPerson getContactByPhone(String phone);

    List<ExtPerson> getContactsByCategory(String category);

    void removeContactByName(String name);

    void removeContactByPhone(String phone);

    void sortByName();

    void sortByCategory();

    String toString();
}

public class AddressBook implements ForNoReason {
    private final List<ExtPerson> contacts = new ArrayList<>();

    public void addBusinessAssociate(String name, Address address, String phone, Date birthDate, String company, String position) {
        contacts.add(new BusinessAssociate(name, address, phone, birthDate, company, position));
    }

    public void addFamily(String name, Address address, String phone, Date birthDate, String relation) {
        contacts.add(new Family(name, address, phone, birthDate, relation));
    }

    public void addFriend(String name, Address address, String phone, Date birthDate, String note) {
        contacts.add(new Friend(name, address, phone, birthDate, note));
    }

    public List<ExtPerson> getContacts() {
        return contacts;
    }

    // TODO: compress these
    public ExtPerson getContactByName(String name) {
        return contacts.stream().filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }

    public ExtPerson getContactByPhone(String phone) {
        return contacts.stream().filter(p -> p.getPhone() == phone)
                .findFirst().orElse(null);
    }

    public void removeContactByName(String name) {
        contacts.remove(getContactByName(name));
    }
    // TODO: compress these

    public void removeContactByPhone(String phone) {
        contacts.remove(getContactByPhone(phone));
    }

    public List<ExtPerson> getContactsByCategory(String category) {
        return contacts.stream().filter(p -> p.getCategory().equals(category)).collect(Collectors.toList());
    }

    public void sortByName() {
        contacts.sort(Comparator.comparing(ExtPerson::getName));
    }

    public void sortByCategory() {
        contacts.sort(Comparator.comparing(ExtPerson::getCategory));
    }

    public String toString() {
        return "Cozy Address Book\n" +
                contacts.stream().map(ExtPerson::toString).reduce("", (a, b) -> a + "\n" + b);
    }

    public static void main(String[] args) {
        Date testDate = new Date(1, 1, 2000);
        Address testAddress = new Address("123 Main St", "San Francisco", "CA", "94105");
        AddressBook addressBook = new AddressBook();

        System.out.println("1. Test adding new entries");
        addressBook.addFamily("John", testAddress, "123-456-7890", testDate, "Father");
        System.out.println("\n" + addressBook);
        addressBook.addFamily("Mary", testAddress, "123-456-7890", testDate, "Mother");
        testAddress.setStreet("456 Main St");
        addressBook.addFriend("Bob", testAddress, "123-456-7890", testDate, "I hate this person");
        System.out.println("\n" + addressBook);
        System.out.println("See they are working\n");

        System.out.println("2. Test sorting entries");
        testAddress.setCity("Los Angeles");
        addressBook.addBusinessAssociate(
                "Ali", testAddress, "123-456-7890",
                testDate, "Google", "Software Engineer");
        System.out.println("\n" + addressBook);
        addressBook.sortByName();
        System.out.println(addressBook);
        System.out.println("Sorted this thing by name\n");
        addressBook.sortByCategory();
        System.out.println(addressBook);
        System.out.println("Sorted this thing by category\n");

        System.out.println("3. Test removing entries");
        addressBook.removeContactByName("John");
        System.out.println("\n" + addressBook);

        System.out.println("4. Category check");
        for (ExtPerson person : addressBook.getContacts())
            System.out.println(person.getName() + " is " + person.getCategory());
        System.out.println("\nPeople with category 'Family':\n");
        for (ExtPerson person : addressBook.getContactsByCategory("Family")) System.out.println(person);
    }
}
