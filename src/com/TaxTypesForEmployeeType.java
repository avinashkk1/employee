package com;

import java.util.List;

public class TaxTypesForEmployeeType {
    private EmployeeType employeeType;
    private List<Tax> taxList;


    public TaxTypesForEmployeeType(EmployeeType employeeType, List<Tax> taxList) {
        this.employeeType = employeeType;
        this.taxList = taxList;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public List<Tax> getTaxList() {
        return taxList;
    }

    public void setTaxList(List<Tax> taxList) {
        this.taxList = taxList;
    }
}
