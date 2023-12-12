package ru.rodin.gb.jdk.hw4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Создать класс справочник сотрудников, который
 * содержит внутри коллекцию сотрудников
 * - Добавить метод, который ищет сотрудника по стажу (может быть список)
 * - Добавить метод, который выводит номер телефона сотрудника по имени (может
 * быть список)
 * - Добавить метод, который ищет сотрудника по табельному номеру
 * - Добавить метод добавление нового сотрудника в справочник
 */
public class EmployeeDirectory {
    /**
     * Для быстрого поиска по табельному номеру
     */
    private final Map<String, Employee> employeesByNumber;
    /**
     * Для быстрого поиска по имени
     */
    private final Map<String, List<Employee>> employeesByName;

    public EmployeeDirectory() {
        employeesByNumber = new HashMap<>();
        employeesByName = new HashMap<>();
    }

    /**
     * Добавляет сотрудника employee в справочник
     * 
     * @param employee
     */
    public void addEmployee(Employee employee) {
        employeesByNumber.put(employee.getPersonnalNumber(), employee);
        employeesByName.computeIfAbsent(employee.getName(), name -> new ArrayList<>()).add(employee);
    }

    /**
     * Ищет сотрудников по по определенному стажу
     * 
     * @param experience стаж в годах
     * @return список сотрудников с определенным стажем experience
     */
    public List<Employee> findEmployeesByExperience(int experience) {
        return employeesByNumber.values().stream()
                .filter(employee -> employee.getExperience() == experience)
                .toList();
    }

    /**
     * Находит сотрудников по стажу в заданном диапазоне от experienceFrom до
     * experienceTo
     * 
     * @param experienceFrom нижняя граница диапазона стажа в годах
     * @param experienceTo   верхняя граница диапазона стажа в годах
     * @return список сотрудников со стажом в заданном диапазоне
     */
    public List<Employee> findEmployeesByExperience(int experienceFrom, int experienceTo) {
        return employeesByNumber.values().stream()
                .filter(employee -> employee.getExperience() >= experienceFrom
                        && employee.getExperience() <= experienceTo)
                .toList();
    }

    /**
     * Ищет сотрудника по табельному номеру
     * 
     * @param personnalNumber табельный номер
     * @return сотрудник с табельным номером personnalNumber или null, если
     *         сотрудник не был найден
     */
    public Employee findEmployeeByPersonnalNumber(String personnalNumber) {
        return employeesByNumber.get(personnalNumber);
    }

    /**
     * Ищет номер телефона сотрудника по имени
     * 
     * @param name имя сотрудника
     * @return список номеров телефонов
     */
    public List<String> findPhoneByName(String name) {
        return employeesByName.get(name).stream()
                .map(Employee::getPhoneNumber)
                .toList();
    }
}
