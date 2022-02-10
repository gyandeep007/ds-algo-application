package com.gyan.demo.ds.hashtable;

public class HashTable {
    private HashNode[] bucket;
    // store the number of node in hashtable
    private int size;

    public HashTable(int capacity) {
        this.bucket = new HashNode[capacity];
        this.size = 0;
    }

    public String put(Integer key,String value){
        int index = hashcode(key);
        if(bucket[index] == null){
            bucket[index] = new HashNode(key, value);
            size++;
            return null;
        }

        HashNode head = bucket[index];
        while (head != null && head.getKey() != key){
            head = head.getNext();
        }

        if(head != null){
            String oldValue = head.getValue();
            head.setValue(value);
            return oldValue;
        }
        HashNode node = new HashNode(key, value);
        node.setNext(bucket[index]);
        bucket[index] = node;
        size++;
        return null;
    }

    public String get(Integer key){
        int index = hashcode(key);

        HashNode head = bucket[index];
        while (head != null && head.getKey() != key){
            head = head.getNext();
        }
        return head == null ? null : head.getValue();
    }

    public int hashcode(Integer key){
        return Math.abs(key.intValue())% bucket.length;
    }

    public String remove(Integer key){
        int index = hashcode(key);

        HashNode head = bucket[index];
        HashNode prev = null;
        while (head != null && (head.getKey().intValue() != key.intValue())){
            prev = head;
            head = head.getNext();
        }
        if(head == null)
            return null;
        else{
            if(prev == null) {
                bucket[index] = head.getNext();
                head.setNext(null);
                size--;
                return head.getValue();
            } else{
                prev.setNext(head.getNext());
                head.setNext(null);
                size--;
                return head.getValue();
            }
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
   }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bucket.length ; i++) {
            HashNode current = bucket[i];
            while (current != null){
                sb.append(current+",");
                current = current.getNext();
            }
        }
        return sb.toString();
    }
}
