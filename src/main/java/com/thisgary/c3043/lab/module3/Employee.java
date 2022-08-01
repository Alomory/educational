package com.thisgary.c3043.lab.module3;

/*
Activity 1
----------
1. Given the employee composed of the class called Date, employeeid, name and hiredate.
2. The class Date is given below:
3. Copy the class Date and implement a class Employee. Finally, use main program to display the
   employee id, name and hire date using format day/month/year.
 */

public class Employee {
    private String name;
    private String employeeId;
    private Date hireDate;

    public Employee(String name, String employeeId, Date hireDate) {
        this.name = name;
        this.employeeId = employeeId;
        this.hireDate = hireDate;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String toString() {
        return "Employee[name=" + name + ", employeeId=" + employeeId + ", hireDate=" + hireDate + "]";
    }

    public static void main(String[] args) {
        Date date = new Date(31, 12, 2019);
        Employee employee = new Employee("John", "CSF3043", date);
        System.out.println(employee + "\n");
    }
}
