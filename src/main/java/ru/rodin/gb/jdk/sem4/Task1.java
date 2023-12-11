package ru.rodin.gb.jdk.sem4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * В рамках выполнения задачи необходимо:
 * Создайте коллекцию мужских и женских имен с помощью интерфейса List
 * Отсортируйте коллекцию в алфавитном порядке
 * Отсортируйте коллекцию по количеству букв в слове
 * Разверните коллекцию
 */
public class Task1 {
    private static List<String> names = new ArrayList<>();

    public static void main(String[] args) {
        names.add("Igor");
        names.add("Alexey");
        names.add("Petr");
        names.add("Vasya");
        names.add("Anna");
        names.add("Kate");
        names.add("Elena");
        names.add("Masha");
        System.out.println(names);
        Collections.sort(names);
        System.out.println(names);
        // names.sort((s1, s2) -> s1.length() - s2.length());
        names.sort(Comparator.comparingInt(String::length));
        System.out.println(names);
        var rev_names = names.reversed();
        System.out.println(rev_names);
    }
}
