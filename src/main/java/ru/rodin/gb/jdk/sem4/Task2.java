package ru.rodin.gb.jdk.sem4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* В рамках выполнения задачи необходимо:
* Создайте коллекцию мужских и женских имен с помощью интерфейса List - добавьте повторяющиеся значения
* Получите уникальный список Set на основании List
* Определите наименьший элемент (алфавитный порядок)
* Определите наибольший элемент (по количеству букв в слове но в обратном порядке)
* Удалите все элементы содержащие букву ‘A’
*/

public class Task2 {
    private static List<String> names = new ArrayList<>();
    private static Set<String> namesSet = new HashSet<>();

    public static void main(String[] args) {
        names.add("Igor");
        names.add("Igor");
        names.add("Alexey");
        names.add("Petr");
        names.add("Petr");
        names.add("Iren");
        names.add("Vasya");
        names.add("Anna");
        names.add("Kate");
        names.add("Elena");
        names.add("Vladislav");
        names.add("Elena");
        names.add("Masha");

        namesSet.addAll(names);
        System.out.println(namesSet);

        // var minAlhpa = names.stream().min((s1, s2) -> s1.compareTo(s2)).get();
        var minAlhpa = names.stream().min(String::compareTo).get();
        System.out.println(minAlhpa);

        // String maxCount = names.stream().max((s1, s2) -> s1.length() -
        // s2.length()).get();
        String maxCount = names.stream().max(Comparator.comparingInt(String::length)).get();
        String reversedMax = new StringBuilder(maxCount).reverse().toString();
        System.out.println(maxCount);
        System.out.println(reversedMax);

        // var newSet = new HashSet<>(names.stream().filter(e ->
        // !e.contains("a")).toList());
        namesSet.removeIf(e -> e.contains("a"));
        System.out.println(namesSet);
    }
}
