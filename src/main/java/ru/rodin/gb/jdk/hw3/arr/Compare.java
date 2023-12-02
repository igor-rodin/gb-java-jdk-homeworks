package ru.rodin.gb.jdk.hw3.arr;

import java.util.Arrays;

/*
 * Напишите обобщенный метод compareArrays(), который принимает два массива и
    возвращает true, если они одинаковые, и false в противном случае. Массивы могут быть
    любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.
 */

public class Compare {
    public static <E> boolean compareArrays(E[] arr1, E[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < arr2.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] arr1 = { "da", "b", "cc" };
        String[] arr2 = { "b", "da", "cc" };

        System.out.println(Compare.compareArrays(arr1, arr2));
    }

}
