package com.garylkz.c3043.lecture.class6;

public class Test {
    public static void main(String[] args) {
        SalariedEmployee salariedEmployee = new SalariedEmployee("Smith", "111-11-1111", 800.00);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Price", "222-22-2222", 16.75, 40);
        CommissionEmployee commissionEmployee = new CommissionEmployee(
                "Jones", "333-33-3333", 10000, 6);
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee(
                "Lewis", "444-44-4444", 5000, 4, 300);

        // create four-element Employee array
        Employee[] employees = new Employee[4];
        // initialize array with Employees
        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = basePlusCommissionEmployee;

        System.out.println("Employees processed polymorphic-ally: \n");
        // generically process each element in array employees
        for (Employee currentEmployee : employees) {
            System.out.println(currentEmployee); // invokes toString

            // determine whether it is a BasePlusCommission Employee
            if (currentEmployee instanceof BasePlusCommissionEmployee) {
                // downcast Employee reference to
                // BasePlusCommissionEmployee reference
                BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;
                employee.setBaseSalary(1.10 * employee.getBaseSalary());
                System.out.printf("new base salary with 10% increase is: $%,.2f\n", employee.getBaseSalary());
            } // end if
            System.out.printf("earned $%,.2f\n\n", currentEmployee.earnings());

            // get type name of each object in employees array
            for (int j = 0; j < employees.length; j++)
                System.out.printf("Employee %d is a %s\n", j, employees[j].getClass().getName());
        } // end for
    }
}
