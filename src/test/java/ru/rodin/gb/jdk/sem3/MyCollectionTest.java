package ru.rodin.gb.jdk.sem3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyCollectionTest {

    @Test
    public void testAdd() {
        MyCollection<Integer> myCollection = new MyCollection<>();
        myCollection.add(1);
        assertEquals(1, myCollection.get(0).intValue());
    }

    @Test
    public void testGet() {

    }

    @Test
    public void testGetElementIndex() {

    }

    @Test
    public void testRemove() {

    }

    @Test
    public void testRemoveAt() {

    }
}
