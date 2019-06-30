package com.asher.stacks;

import java.util.Stack;

/**
 * Queue, implemented via stacks
 */
public class Queue {
    Stack<Object> newEle = new Stack<>();
    Stack<Object> oldEle = new Stack<>(); 

    public boolean isEmpty(){
        return newEle.size() == 0 && oldEle.size() == 0;
    }

    public void add(Object e){
        newEle.push(e);
    }

    public Object remove() {
        if (oldEle.empty()) {
            shuffle();
        }
        return oldEle.pop();
    }

    public Object peek() {
        if (oldEle.empty()) {
            shuffle();
        }
        return oldEle.peek();
    }
    
    private void shuffle(){
        while( newEle.size() != 0) {
            oldEle.push(newEle.pop());
        }

    }
}