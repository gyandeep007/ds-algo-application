package com.gyan.demo.ds.hashtable;

public class HashNode {
    private Integer key;
    private String value;
    private HashNode next;

    public HashNode(Integer key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public HashNode getNext() {
        return next;
    }

    public void setNext(HashNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HashNode{" +
                "key=" + key +
                ", value='" + value + '\'' +
                '}';
    }
}
