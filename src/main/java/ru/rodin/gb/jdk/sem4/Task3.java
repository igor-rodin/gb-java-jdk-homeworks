package ru.rodin.gb.jdk.sem4;

import java.util.HashMap;
import java.util.Map;

/**
 * В рамках выполнения задачи необходимо:
 * Создайте телефонный справочник с помощью Map - телефон это ключ, а имя
 * значение
 * Найдите человека с самым маленьким номером телефона
 * Найдите номер телефона человека чье имя самое большое в алфавитном порядке
 */
public class Task3 {
    private static Map<String, String> phones = new HashMap<>();

    public static void main(String[] args) {
        phones.put("89251144968", "Igor");
        phones.put("87774567657", "Alexey");
        phones.put("8113111111", "Lena");

        String minPhone = phones.keySet().stream().min((s1, s2) -> s1.compareTo(s2)).get();
        System.out.println(phones.get(minPhone));

        String maxName = "";
        String phone = "";
        for (var entry : phones.entrySet()) {
            if (entry.getValue().length() > maxName.length()) {
                maxName = entry.getValue();
                phone = entry.getKey();
            }
        }
        System.out.println(phone);
    }
}
