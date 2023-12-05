package ru.rodin.gb.jdk.hw3.calc;

/*
 * Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы: sum(), multiply(), divide(), subtract().
    Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция. 
 */

public class Calculator {
    public static <A1 extends Number, A2 extends Number> double sum(A1 arg1, A2 arg2) {
        return arg1.doubleValue() + arg2.doubleValue();
    }

    public static <A1 extends Number, A2 extends Number> double subtract(A1 arg1, A2 arg2) {
        return arg1.doubleValue() - arg2.doubleValue();
    }

    public static <A1 extends Number, A2 extends Number> double multiply(A1 arg1, A2 arg2) {
        return arg1.doubleValue() * arg2.doubleValue();
    }

    public static <A1 extends Number, A2 extends Number> double divide(A1 arg1, A2 arg2) {
        if (arg2.doubleValue() == 0) {
            throw new IllegalArgumentException("Делить на ноль нельзя!");
        }
        return arg1.doubleValue() / arg2.doubleValue();
    }
}
