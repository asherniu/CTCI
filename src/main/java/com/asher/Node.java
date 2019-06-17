package com.asher;

/**
 * Node
 */
public class Node {
    int val;
    Node next; 
    public Node(){
    }

    public Node(int val){
        this.val = val;
    }
    public Node(Node node){
        this.val = node.val;
        this.next = node.next;
    }
    public Node(int val, Node next){
        this.val = val;
        this.next = next;
    }
    public static Node getLists(int[] nodes) {
        Node dummy = new Node();
        dummy.next = new Node();
        Node head = dummy.next; 
        for (int i : nodes){
            head.next = new Node(i);
            head = head.next; 
        }
        return dummy.next.next;
    }

    @Override
    public String toString(){
        String ret = this.val + "-";
        Node probe = next;
        while (probe != null ){
            ret += probe.val + "-";
            probe = probe.next; 
        }
        return ret;
    }

    public int size() {
        int size = 1;
        Node probe = next; 
        while (probe != null) {
            size++;
            probe = probe.next;
        }
        return size;
    }

    public void append(Node node){
        Node probe = next; 
        while (probe.next != null) {
            probe = probe.next;
        }
        probe.next = node; 
    }
}
