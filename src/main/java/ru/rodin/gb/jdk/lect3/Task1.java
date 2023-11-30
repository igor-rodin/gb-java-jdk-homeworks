package ru.rodin.gb.jdk.lect3;

import java.util.Arrays;
import java.util.Objects;

public class Task1 {

    public static void main(String[] args) {
        Integer[] arrInt = { 1, 2, 3, 4, 5 };
        String[] arrStr = { "a", "b", "c", "d", "e" };
        Double[] arrDoubles = { 1.0, 2.0, 3.0, 4.0, 5.0 };

        swap(arrInt, 1, 3);
        swap(arrStr, 0, 3);
        swap(arrDoubles, 2, 4);

        System.out.println(Arrays.toString(arrInt));
        System.out.println(Arrays.toString(arrStr));
        System.out.println(Arrays.toString(arrDoubles));
    }

    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
