package com.asher.stacks;

/**
 * ThreeInOneFixedStack
 */
public class ThreeInOneFixedStack<E> {
    int[] sizes = new int[]{0,0,0};  
    int size = 0;
    Object[] elementData;

    public ThreeInOneFixedStack() {
        super();
        this.elementData = new Object[10];
    }

    public E peek(int stackNumber) {
        if (!isEmpty(stackNumber)) {
            return (E) elementData[(getSize(stackNumber) -1 )* 3 + stackNumber];
        } else {
            return null;
        }
    }
    public E pop(int stackNumber) {
        if (!isEmpty(stackNumber)) {
            E data = peek(stackNumber);
            sizes[stackNumber] = sizes[stackNumber] - 1;
            return data;
        } else {
            return null;
        }
    }

    private void ensureCapacity(int stackNumber) {
        int cap = elementData.length;
        if ((getSize(stackNumber)*3 + stackNumber) > cap) {
            Object[] temp = new Object[cap * 3]; 
            for (int i = 0; i < cap; i++) {
                temp[i] = elementData[i];
            }
            elementData = temp; 
        }
    }
    public void push(int stackNumber, E ele) {
        ensureCapacity(stackNumber);
        elementData[getSize(stackNumber)*3 + stackNumber ] = ele;
        sizes[stackNumber] = sizes[stackNumber] + 1;
    }
    public boolean isEmpty(int stackNumber) {
        return sizes[stackNumber] == 0;
    }

    private int getSize(int stackNumber) {
        return sizes[stackNumber];
    }

}