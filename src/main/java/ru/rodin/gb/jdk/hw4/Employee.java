package ru.rodin.gb.jdk.hw4;

/**
 * сотрудник должен иметь следующие атрибуты:
 * - Табельный номер
 * - Номер телефона
 * - Имя
 * - Стаж
 */
public class Employee {

    private final String personnalNumber;
    private final String name;
    private String phoneNumber;
    private int experience;

    public Employee(String personnalNumber, String name, String phoneNumber, int experience) {
        this.personnalNumber = personnalNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.experience = experience;
    }

    public String getPersonnalNumber() {
        return personnalNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "personnalNumber='" + personnalNumber + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", experience=" + experience +
                '}';
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;
        Employee employee = (Employee) other;
        return personnalNumber.equals(employee.personnalNumber);
    }
}
