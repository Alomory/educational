package educational.c3043.project.s62079.core;

import educational.c3043.project.s62079.exception.LazyException;
import educational.c3043.project.s63683.Age;
import educational.c3043.project.s63683.BirthDate;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Account {
    private String ic;
    private String name;
    private String address;
    private String phone;
    private String email;

    protected List<Access> accesses = new ArrayList<>();
    protected List<Report> reports = new ArrayList<>();

    public Customer(String username, String password,
                    String ic, String name,
                    String address, String phone, String email) throws LazyException {
        super(username, password);
        try {
            setIC(ic);
            setName(name);
            setAddress(address);
            setPhone(phone);
            setEmail(email);
        } catch (LazyException e) { // Failed data check
            accounts.remove(this);
            throw e;
        }
    }

    public String getIC() {
        return ic;
    }

    public void setIC(String ic) throws LazyException {
        if (!ic.matches("\\d{12}")) throw new LazyException("Lazy invalid IC");
        if (accounts.stream().anyMatch(
                a -> a instanceof Customer && ((Customer) a).getIC() != null && ((Customer) a).getIC().equals(ic)
        )) throw new LazyException("IC already exists");
        this.ic = ic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Access> getAccesses() {
        return accesses;
    }

    public void addAccess(String facility) {
        Access access = new Access(this, facility);
        accesses.add(access);
    }

    public void removeAccess(Access access) {
        accesses.remove(access);
    }

    public List<Report> getReports() {
        return reports;
    }

    public void addReport(String title, String details) {
        Report report = new Report(this, title, details);
        reports.add(report);
    }

    public void removeReport(Report report) {
        reports.remove(report);
    }

    public BirthDate getBirthDate() {
        return new BirthDate(ic);
    }

    public Age getAge() {
        return new Age(getBirthDate().getYear());
    }

    public String toString() {
        return String.format("%s\nName: %s\nIC: %s\nAddress: %s\nPhone: %s\nEmail: %s\nBirth Date: %s\nAge: %s",
                super.toString(), name, ic, address, phone, email, getBirthDate(), getAge());
    }

    public static Customer getDummy() {
        try {
            return new Customer(
                    "customer", "customer", "111111111111",
                    "Name", "Address", "phone", "email");
        } catch (LazyException e) {
            return null;
        }
    }
}
