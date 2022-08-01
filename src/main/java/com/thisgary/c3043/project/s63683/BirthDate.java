package com.thisgary.c3043.project.s63683;

public class BirthDate {
    private String ic;

    public BirthDate(String ic) {
        setIc(ic);
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public String toString() {
        String monthS = getIc().substring(2, 4);
        String dayS = getIc().substring(4, 6);

        return String.format("%s / %s / %d", dayS, monthS, getYear());
    }

    public int getYear() {
        int year = Integer.parseInt(getIc().substring(0, 2));

        if ((year > 0) && (year < 22)) {
            year += 2000;
        } else
            year += 1900;

        return year;
    }
}
