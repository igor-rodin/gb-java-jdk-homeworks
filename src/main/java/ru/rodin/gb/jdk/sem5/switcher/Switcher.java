package ru.rodin.gb.jdk.sem5.switcher;

/**
 * В рамках выполнения задачи необходимо:
 * - Создайте два потока A и B.
 * - Поток A меняет значение Boolean переменной switcher с задержкой 1000
 * миллисекунд (true в состояние false и наоборот).
 * - Поток B ожидает состояния true переменной switcher и выводит на консоль
 * обратный отсчет от 100
 * с задержкой 100 миллисекунд и приостанавливает свое действие, как только
 * поток A переключит switcher в состояние false.
 * - Условием завершения работы потоков является достижение отсчета нулевой
 * отметки.
 * - Можно воспользоваться синхронизацией для управления значения переменной или
 * volatile
 */
public class Switcher {

    public static void main(String[] args) {
        new Switcher().start();
    }

    private void start() {
        SwitchState switcherState = new SwitchState();
        Thread threadA = new Thread(new ThreadA(switcherState));
        Thread threadB = new Thread(new ThreadB(switcherState));
        threadA.start();
        threadB.start();
    }
}
