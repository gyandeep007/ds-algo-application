package com.gyan.demo.ds.tree.binarysearchtree.generic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
public class Person implements Comparable<Person>{

    String name;
    int age;

    @Override
    public int compareTo(Person otherPerson) {
        return this.age - otherPerson.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
