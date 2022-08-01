package com.thisgary.c3043.project.s62079.core;

import com.thisgary.c3043.project.s62079.exception.LazyException;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Access {
    private final static List<String> facilities = Arrays.stream(
            new String[] {"Basketball Court", "Football Field", "Gymnasium", "Swimming Pool"}
    ).collect(Collectors.toList());
    private final Customer customer;
    private final String facility;
    private final Date date;

    public Access(Customer customer, String facility) {
        this.customer = customer;
        this.facility = facility;
        this.date = new Date();
    }

    public static List<String> getFacilities() {
        return facilities;
    }

    public static void addFacilities(String facility) throws LazyException {
        if (facility.equals("")) throw new LazyException("What is this?");
        if (facilities.contains(facility)) throw new LazyException("Facility already exists");
        facilities.add(facility);
    }

    public static void removeFacilities(int index) {
        facilities.remove(index);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void delete() {
        this.customer.removeAccess(this);
    }

    public String toString() {
        return String.format("%s - %s accessed %s",
                new SimpleDateFormat("HH:mm dd/MM/yy").format(date), customer.getName(), facility);
    }
}
