package com;

import java.io.File;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    /**
     * Main method to read input data of employees, compute and print tax details for them
     */
    public static void main(String[] args) {
	// write your code here
        Scanner scanner;
        HashMap<String, Gender> genderHashMap = new HashMap<>();
        HashMap<Integer, Tax> taxMap = new HashMap<>();
        List<Employee2> employeeList = new ArrayList<>();
        HashMap<EmployeeType, List<Tax>> taxTypesForEmployeeType = new HashMap<>();

        try {
            // Read reference data from input file
            scanner = new Scanner(new File("G:\\My Drive\\Code\\Scaler\\Employee\\src\\com\\employee_input.csv"));
            scanner.useDelimiter(Pattern.compile("(\\n)|,"));

            loadGenders(scanner, genderHashMap);

            loadTaxTypes(scanner, taxMap);

            loadTaxTypesForEmployeeType(scanner,
                    taxTypesForEmployeeType,
                    taxMap);

            loadEmployees(scanner,
                    genderHashMap,
                    taxTypesForEmployeeType,
                    employeeList);

            computeAndDisplayTaxes(employeeList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadTaxTypesForEmployeeType(
            Scanner scanner, HashMap<EmployeeType,
            List<Tax>> taxTypesForEmployeeType,
            HashMap<Integer, Tax> taxMap) {

        int numberOfMappings = Integer.parseInt(scanner.next().strip());

        for (int i = 0; i < numberOfMappings; i++) {

            String employeeType = scanner.next().strip();
            int taxID = Integer.parseInt(scanner.next().strip());
            EmployeeType employeeTypeEnum = EmployeeType.valueOf(employeeType);
            Tax taxObject = taxMap.get(taxID);

            if (taxTypesForEmployeeType.containsKey(employeeTypeEnum)) {
                taxTypesForEmployeeType.get(employeeTypeEnum).add(taxObject);
            } else {
                List<Tax> taxList = new ArrayList<>();
                taxList.add(taxObject);
                taxTypesForEmployeeType.put(employeeTypeEnum, taxList);
            }

        }
    }

    private static void computeAndDisplayTaxes(List<Employee2> employeeList) {
        for (Employee employee : employeeList) {
            employee.computeTax();
            System.out.println(employee);
        }
    }

    private static void loadEmployees(Scanner scanner,
                                      HashMap<String, Gender> genderHashMap,
                                      HashMap<EmployeeType, List<Tax>> taxTypesForEmployeeType,
                                      List<Employee2> employeeList) {
        try {
            int numberOfEmployees = Integer.parseInt(scanner.next().strip());
            for (int i = 0; i < numberOfEmployees; i++) {
                String firstName = scanner.next().strip();
                String lastName = scanner.next().strip();
                String gender = scanner.next().strip();
                String dateOfBirth = scanner.next().strip();
                double totalEarnings = Double.parseDouble(scanner.next().strip());
                String employeeType = scanner.next().strip();
                EmployeeType employeeTypeEnum = EmployeeType.valueOf(employeeType);
                List<Tax> taxList = taxTypesForEmployeeType.get(employeeTypeEnum);

                Employee2 employee = new Employee2(firstName,
                        lastName,
                        genderHashMap.get(gender),
                        dateOfBirth,
                        totalEarnings,
                        taxList,
                        employeeTypeEnum);
                employeeList.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadTaxTypes(Scanner scanner, HashMap<Integer, Tax> taxMap) {
        try {
            int numberOfTaxTypes = Integer.parseInt(scanner.next().strip());
            for (int i = 0; i < numberOfTaxTypes; i++) {
                int taxID = Integer.parseInt(scanner.next().strip());
                String taxType = scanner.next().strip();
                int taxPercentage = Integer.parseInt(scanner.next().strip());
                Tax taxObject = new Tax(taxID, taxType, taxPercentage);
                taxMap.put(taxID, taxObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadGenders(Scanner scanner, HashMap<String, Gender> genderHashMap) {
        try {
            int numberOfGenders = Integer.parseInt(scanner.next().strip());
            for (int i = 0; i < numberOfGenders; i++) {
                int genderID = Integer.parseInt(scanner.next().strip());
                String gender = scanner.next().strip();
                Gender genderObject = new Gender(genderID, gender);
                genderHashMap.put(gender, genderObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
