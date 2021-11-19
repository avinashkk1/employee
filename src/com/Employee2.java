package com;

import java.util.List;

public class Employee2 extends Employee {
    private EmployeeType employeeType;

    public Employee2(String firstName, String lastName, Gender gender, String dateOfBirth, double totalEarnings, List<Tax> taxList, EmployeeType employeeType) {
        super(firstName, lastName, gender, dateOfBirth, totalEarnings, taxList);
        this.employeeType = employeeType;
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "employeeID=" + employeeID +
                ", person=" + person +
                ", emailAddress='" + emailAddress + '\'' +
                ", salary=" + salary +
                ", taxList=" + taxList +
                ", employeeType=" + employeeType +
                '}';
    }
}
