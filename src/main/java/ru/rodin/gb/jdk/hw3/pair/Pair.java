package ru.rodin.gb.jdk.hw3.pair;

import java.text.MessageFormat;

/*
 * Напишите обобщенный класс Pair, который представляет собой пару значений разного типа. 
    Класс должен иметь методы getFirst(), getSecond() для получения значений пары, 
    а также переопределение метода toString(), возвращающее строковое представление пары.
 */

public class Pair<F, S> {
    private F first;
    private S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Pair({0}, {1})", first, second);
    }
}
