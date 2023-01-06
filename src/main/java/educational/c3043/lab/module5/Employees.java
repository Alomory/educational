package educational.c3043.lab.module5;

/*
Activity 2
----------
The ABC company consists of two (2) of employees; permanent and contract employee. Both employees
consist of common attributes such as employee number, employee name and type of employee. The
calculation of salary is different and based on the following formula:
- Permanent employee – Basic salary + allowance (RM300.00)
- Contract employee – no of hours x RM30.00 per hour

Draw an UML diagram to show the relationship between the classes. Based on your UML diagram, write
a program to display employee number, name, type of employee and the salary.
 */

import java.util.ArrayList;

public class Employees {
    private static ArrayList<Integer> ids = new ArrayList<>();

    public static final int MINIMUM_WAGE = 1500;

    private int id;
    private String name;
    private String type;
    private double salary;


    public Employees(int id, String name, String type, double salary) {
        assert !ids.contains(id) : "Employee ID must be unique";
        ids.add(id);

        this.id = id;
        this.name = name;
        this.type = type;
        this.salary = calculateEmpSalary(salary);
    }

    protected double calculateEmpSalary(double salary) {
        return salary;
    }

    public String toString() {
        return String.format("%d - %s: %s, %.2f", id, name, type, salary);
    }

    public static void main(String[] args) {
        ContractEmployee john = new ContractEmployee(1, "John", 69);
        PermanentEmployee cena = new PermanentEmployee(2, "Cena");
        System.out.println(john);
        System.out.println(cena);
    }
}

/*
Activity 3
----------
Copy your solution in Activity 2 and paste into CSF3043 -> Lab – Chapter 5 -> Activity 3. Based on the
solution you wrote in Activity 2, modify the common method double calculateEmpSalary() to calculate
the salary as below:

    Employee salary = basic salary

In your Permanent Employee and Contract Employee’s class, rename the method to calculate salary as
double calculateEmpSalary(). Create a main program as EmployeeTest and override the implementation
of calculating salary at permanent and contract employee
*/

class PermanentEmployee extends Employees {
    public PermanentEmployee(int id, String name) {
        super(id, name, "Permanent", 300);
    }

    @Override
    protected double calculateEmpSalary(double allowance) {
        return MINIMUM_WAGE + allowance;
    }
}

class ContractEmployee extends Employees {
    public ContractEmployee(int id, String name, int workingHours) {
        super(id, name, "Contract", workingHours);
    }

    @Override
    protected double calculateEmpSalary(double workingHours) {
        return (int) workingHours * 30;
    }
}
