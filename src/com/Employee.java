package com;

import java.util.List;

public class Employee {
    protected int employeeID;
    protected Person person;
    protected String emailAddress;
    protected Salary salary;
    protected List<Tax> taxList;

    private static int nextEmployeeID = 1;

    public Employee(String firstName, String lastName, Gender gender, String dateOfBirth,
                    double totalEarnings, List<Tax> taxList) {
        this.employeeID = nextEmployeeID;
        nextEmployeeID += 1;
        this.person = new Person(firstName, lastName, gender, dateOfBirth);
        this.emailAddress = firstName + lastName + "@workmail.com";
        this.salary = new Salary(totalEarnings);
        this.taxList = taxList;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public List<Tax> getTaxList() {
        return taxList;
    }

    public void setTaxList(List<Tax> taxList) {
        this.taxList = taxList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", person=" + person +
                ", emailAddress='" + emailAddress + '\'' +
                ", salary=" + salary +
                ", taxList=" + taxList +
                '}';
    }

    public void computeTax() {
        for (Tax tax : this.taxList) {
            double deductions = tax.getTaxPercentage() / (double)100 * this.salary.getTotalEarnings();
            this.salary.setDeductions(deductions);
        }
    }


}
