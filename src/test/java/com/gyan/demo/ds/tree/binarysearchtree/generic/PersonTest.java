package com.gyan.demo.ds.tree.binarysearchtree.generic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void test(){

        BinarySearchTree<Person> persons = new BinarySearchTree<>();
        Person p1= new Person("Gyandeep",29);
        Person p2= new Person("Rahul",30);
        Person p3= new Person("Gyandeep",31);
        Person p4= new Person("Kohli",12);
        Person p5= new Person("Bumrah",10);
        persons.insert(p1);
        persons.insert(p2);
        persons.insert(p3);
        persons.insert(p4);
      //  persons.insert(p5);
        persons.traversal();
        System.out.println();
        System.out.println("is "+p5.getName()+" is in the list "+persons.search(p5));
    }
}
