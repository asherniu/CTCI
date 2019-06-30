package com.asher;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import com.asher.stacks.MinStack;
import com.asher.stacks.Queue;
import com.asher.stacks.SetOfStacks;
import com.asher.stacks.ThreeInOneFixedStack;


/**
 * StackQueueTest
 */
public class StackQueueTest {

    // 3.1
    @Test
    public void threeInOneStackTest() {
        ThreeInOneFixedStack<Object> stack = new ThreeInOneFixedStack<>();
        stack.push(0,1);
        stack.push(0,2);
        stack.push(0,3);
        stack.push(1,"A");
        stack.push(1,"B"); 
        stack.push(1,"C");
        stack.push(2, "1"); 
        stack.push(2, "2"); 
        stack.push(2, "3");
        assertEquals(stack.pop(0), 3);
        assertEquals(stack.pop(0), 2);
        assertEquals(stack.peek(0), 1);
        assertFalse(stack.isEmpty(0));
        stack.pop(0);
        assertTrue(stack.isEmpty(0));
        
        assertEquals(stack.pop(1), "C");
        assertEquals(stack.pop(1), "B");
        assertEquals(stack.peek(1), "A");
        assertFalse(stack.isEmpty(1));
        stack.pop(1);
        assertTrue(stack.isEmpty(1));

        assertEquals(stack.pop(2), "3");
        assertEquals(stack.pop(2), "2");
        assertEquals(stack.peek(2), "1");
        assertFalse(stack.isEmpty(2));
        stack.pop(2);
        assertTrue(stack.isEmpty(2));
        
    }
 
    // 3.2
    @Test
    public void minStackTest() {
        MinStack stack = new MinStack();
        stack.push(100);
        assertEquals(stack.min(), 100);
        assertEquals(stack.pop(), 100);
        assertEquals(stack.min(), Integer.MAX_VALUE);
        stack.push(2); stack.push(5); stack.push(3); stack.push(1);
        assertEquals(stack.min(), 1);
        stack.pop();
        assertEquals(stack.min(), 2);
    }

    // 3.3
    @Test
    public void stackOfPlatesTests(){
        SetOfStacks sos = new SetOfStacks(2); 
        sos.push(0); sos.push(1); 
        sos.push(2); sos.push(3);
        sos.push(4); sos.push(5);
        sos.push(5); sos.push(6);
        assertEquals(sos.size(), 4);
        assertEquals(6, sos.pop());
        assertEquals(sos.size(), 4);
        assertFalse(sos.isEmpty());

        assertEquals(sos.popAt(0), 1);
        assertEquals(sos.popAt(0), 3);
        assertEquals(sos.size(), 3);
    }

    // 3.4
    @Test
    public void stackQueueTest() {
        Queue queue = new Queue();
        queue.add(1);
        queue.add("A");
        queue.add("ABC");
        assertEquals(queue.peek(), 1);
        assertEquals(queue.remove(), 1);
        assertEquals(queue.remove(), "A");
        assertEquals(queue.remove(), "ABC");
        assertTrue(queue.isEmpty());
    }

    // 3.5

    // 3.6
}