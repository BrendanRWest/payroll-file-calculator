package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class PayrollFileCalculator {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("employees.csv"));

            bufferedReader.readLine();

            String csvLine;
            while ((csvLine = bufferedReader.readLine()) != null) {
                String[] tokens = csvLine.split("\\|");
                String employeeId = tokens[0];
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);

                System.out.printf("%s, %s: %.2f %n",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay(hoursWorked, payRate));
            }

            bufferedReader.close();

        } catch (Exception ex) {
            System.out.println("Something went wrong!");
        }
    }
}
