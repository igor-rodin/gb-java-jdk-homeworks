package ru.rodin.gb.jdk.sem3;

/*
 * – Описать собственную коллекцию – список на основе массива. Коллекция должна иметь
    возможность хранить любые типы данных, иметь методы добавления и удаления элементов.

    – Написать итератор по массиву. Итератор – это объект, осуществляющий движение по коллекциям любого типа, содержащим любые типы данных. 
    Итераторы обычно имеют только два метода – проверка на наличие следующего элемента и переход к следующему элементу. 
    Но также, особенно в других языках программирования, возможно встретить итераторы, реализующие дополнительную логику.

    Напишите обобщенный класс Pair, который представляет собой пару значений разного типа. 
    Класс должен иметь методы getFirst(), getSecond() для получения значений пары, 
    а также переопределение метода toString(), возвращающее строковое представление пары.
 */

public class MyCollection<E> {
    private final int DEFAULT_CAPACITY = 10;
    private E[] arr;
    private int size;

    @SuppressWarnings("unchecked")
    public MyCollection() {
        arr = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    public void add(E e) {
        if (size == arr.length) {
            resize();
        }
        arr[size] = e;
        size++;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        size--;
    }

    public void remove(E e) {
        int index = getElementIndex(e);
        if (index == -1) {
            return;
        }
        removeAt(index);
    }

    public int getElementIndex(E e) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        E[] newArr = (E[]) new Object[arr.length * 2];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

    class MyIterator {

        private int index;

        public boolean hasNext() {
            return index < size;
        }

        public E next() {
            return arr[index++];
        }
    }

    MyIterator iterator() {
        return new MyIterator();
    }
}
