package com.gyan.demo.ds.hashtable;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HashTableTest {

    HashTable entries;

    @BeforeAll
    public  void before(){
        entries = new HashTable(10);

    }

    @Test
    void put() {

        entries.put(10,"Hindi");
        entries.put(20,"English");
        entries.put(30,"Math");
        entries.put(40,"Physics");
        entries.put(50,"Chemistry");
        entries.put(10 ,"Social");
        System.out.println(entries.getSize());
        System.out.println(entries);

        System.out.println(entries.get(200));
    }

    @Test
    void testPut() {
    }

    @Test
    void remove() {
        entries.put(10,"A");
        entries.put(100,"B");
        entries.put(1000,"C");
        System.out.println(entries);
        System.out.println(entries.remove(1000));
        System.out.println(entries);
    }
}
