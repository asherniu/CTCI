package com.asher.stacks;


/**
 * MinStack. 
 */
public class MinStack{

    public class MinNode {
        MinNode prev;
        int val; 
        MinNode next; 
        int min; 

        public MinNode(MinNode prev, int val, MinNode next, int min) {
            this.prev = prev;
            this.val = val;
            this.next = next;
            this.min = min; 
        }
    }

    public MinNode node; 

    public MinStack() {
    }

    public void push(int ele) {
        MinNode newNode = new MinNode(node, ele, null, ele < min() ?  ele : min());
        if (node != null) {
            node.next = newNode;
        }
        node = newNode;

    }

    public int pop() {
        if (!isEmpty()) {
            int val = node.val;
            node = node.prev; 
            if (node != null )
                node.next = null ;
            return val; 
        } else {
            return Integer.MAX_VALUE;
        }
    }
    public int peek() {
        if (!isEmpty()) {
            return node.val;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public boolean isEmpty() {
        return node == null;
    }

    public int min() {
        if (node != null) {
            return node.min;
        } else {
            return Integer.MAX_VALUE;
        }
    }
    
}