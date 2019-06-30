package com.asher.stacks;

import java.util.ArrayList;

/**
 * SetOfStacks.
 * Assume threshold won't be 0. 
 */
public class SetOfStacks {
    int threshold; 
    ArrayList<Stack> stacks = new ArrayList<>(); 
    
    public class Stack {
        int[] elementData;
        int size; 

        public Stack(int threshold) {
            if (threshold == 0)
                threshold = 10;
            this.size = 0;
            this.elementData = new int[threshold];
        }

        public boolean push(int val){
            // Full
            if (size == threshold) {
                return false;
            } else {
                elementData[size++] = val; 
                return true; 
            }
        }

        public int peek() {
            return elementData[size-1]; 
        }

        public int pop() {
            int val = peek(); 
            size--;
            return val; 
        }

        public boolean isEmpty() {
            return size == 0; 
        }
    }

    public SetOfStacks(int threshold) {
        this.threshold = threshold; 
    }

    public boolean isEmpty() {
        return stacks.size() == 0;
    }

    public void push(int val) {
        if (size() != 0) {
            Stack lastStack = stacks.get(size() - 1);
            if (!lastStack.push(val)) {
                stacks.add(new Stack(this.threshold));
            }
            stacks.get(size() - 1).push(val);
        } else {
            stacks.add(new Stack(this.threshold));
            stacks.get(0).push(val);
        }
    }

    public int peek() {
        if (size() != 0) {
            Stack lastStack = stacks.get(size() - 1);
            return lastStack.peek();
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public int pop() {
        if (size() != 0) {
            Stack lastStack = stacks.get(size() - 1);
            int val = lastStack.pop(); 
            if (lastStack.isEmpty()) {
                stacks.remove(size() - 1);
            }
            return val;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public int size() {
        return stacks.size();
    }


    // Rollover from other stacks
    public int popAt(int index){
        Stack stackAt = stacks.get(index);
        int val = stackAt.pop();
        // Rollover
        for (int start = index; start < size() - 1; start++) {
            Stack thisStack = stacks.get(start); 
            Stack nextStack = stacks.get(start + 1);
            thisStack.push(nextStack.pop());
        }
        if (stacks.get(size() - 1).isEmpty()) {
            stacks.remove(size() - 1);
        }
        return val;
    }
}