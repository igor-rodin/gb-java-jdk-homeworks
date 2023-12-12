package ru.rodin.gb.jdk.hw4;

import java.util.List;

public class EmployeeApp {
    public static void main(String[] args) {
        EmployeeDirectory employeeDirectory = new EmployeeDirectory();
        employeeDirectory.addEmployee(new Employee("A1-00002", "Ivan", "8987654321", 5));
        employeeDirectory.addEmployee(new Employee("A1-00003", "Petr", "8987654322", 10));
        employeeDirectory.addEmployee(new Employee("B1-00001", "Elena", "8977654321", 15));
        employeeDirectory.addEmployee(new Employee("A2-00004", "Ivan", "8917654321", 3));

        List<Employee> employeesWithExperience10 = employeeDirectory.findEmployeesByExperience(10);
        System.out.println(employeesWithExperience10);

        List<Employee> employeesWithExperience20 = employeeDirectory.findEmployeesByExperience(20);
        System.out.println(employeesWithExperience20);

        List<Employee> employeesWithExperienceBitween5And15Employees = employeeDirectory.findEmployeesByExperience(5,
                15);
        System.out.println(employeesWithExperienceBitween5And15Employees);

        List<String> phoneNumbers = employeeDirectory.findPhoneByName("Ivan");
        System.out.println(phoneNumbers);

        List<String> phoneNumbersElena = employeeDirectory.findPhoneByName("Elena");
        System.out.println(phoneNumbersElena);

        Employee employeeByNumber = employeeDirectory.findEmployeeByPersonnalNumber("A1-00003");
        System.out.println(employeeByNumber);

    }
}
