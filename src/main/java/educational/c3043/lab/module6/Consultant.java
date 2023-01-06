package educational.c3043.lab.module6;

/*
Activity 2
----------
The Consultant class has the following requirements:
- Consultant name, company and age.
- A method to display details of consultant.
  This method consists of two (2) different implementation:
    First implementation – will display consultant name and company.
    Second implementation – will display consultant name, company and age.
                            The value of age is obtained through parameter passing.
- Has an abstract method for calculate and displaying salary.
  The salary is based on MYR800.00 per working day.
 */

public abstract class Consultant {
    private String name, company;
    private int age;

    public Consultant(String name, String company, int age) {
        System.out.println("Consultant constructor called.");
        this.name = name;
        this.company = company;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getCompany() {
        return company;
    }

    public String getName() {
        return name;
    }

    public abstract double getSalary();

    public void setCompany(String company) {
        this.company = company;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Name: " + name + ", Company: " + company + ", Age: " + age;
    }
}
