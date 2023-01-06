package educational.c3043.project.s62079.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Report {
    private Customer customer;
    private Date date;
    private String title;
    private String details;

    public Report(Customer customer, String title, String details) {
        this.customer = customer;
        this.date = new Date();
        this.title = title;
        this.details = details;
    }

    public void delete() {
        this.customer.removeReport(this);
    }

    public String toString() {
        return String.format("%s - %s", new SimpleDateFormat("dd/MM/yy").format(date), title);
    }

    public String deepToString() {
        return String.format("User: %s\nDate: %s\nTitle: %s\n%s",
                customer.getUsername(), date, title, details);
    }
}
