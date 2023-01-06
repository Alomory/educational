package educational.c3043.project.s63683;

import java.util.Calendar;

public class Age {
    private int age;

    public Age(int birthYear) {
        this.age = calculateAge(birthYear);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int birthYear) {
        calculateAge(birthYear);
    }

    private static int calculateAge(int birthYear) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - birthYear;
    }

    public String toString() {
        return String.valueOf(age);
    }
}
