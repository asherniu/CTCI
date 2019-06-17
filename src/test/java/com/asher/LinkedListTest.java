package com.asher;

import org.testng.annotations.*;

import static org.testng.Assert.*;
import static com.asher.LinkedList.*;
import com.asher.Node;

/**
 * LinkedListTest
 */
public class LinkedListTest {

    public boolean compareNodes(Node n1, Node n2){
        if (n1 != null && n2 != null) 
            return n1.val == n2.val;
        return false; 
    }

    public boolean compareLists(Node n1, Node n2){
        while (n1!= null && n2 != null){
            if (n1.val != n2.val) 
                return false; 
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1 == null && n2 == null; 
    }

    // 2.1
    @Test
    public void removeDupsTest(){ 
        Node node1 = Node.getLists(new int[]{1,1,2,3,4,5,6,7,4,3,2});
        Node node1After = Node.getLists(new int[]{1,2,3,4,5,6,7});
        Node node2 = Node.getLists(new int[]{1,1,2,3,4,5,6,7,4,3,2});
        Node node2After = Node.getLists(new int[]{1,2,3,4,5,6,7});


        removeDupsWithSet(node1);
        assertTrue(compareLists(node1, node1After));
        removeDupsNoBuffer(node2);
        assertTrue(compareLists(node2, node2After));
    }

    // 2.2
    @Test
    public void returnKthElementTest(){ 
        Node node = Node.getLists(new int[]{1,1,2,2,3,4,5,6,7,8});

        Node nullNode = returnKthElementToLast(node, 1000);
        assertNull(nullNode);

        Node first = returnKthElementToLast(node, 1);
        assertTrue(compareNodes(first, new Node(7)));

        Node ninth = returnKthElementToLast(node, 9);
        assertTrue(compareNodes(ninth, new Node(1)));

    }

    // 2.3
    @Test
    public void deleteMiddleNodeTest(){
        Node node = Node.getLists(new int[]{1,1,1,2,1,1,1});
        Node nodeAfter = Node.getLists(new int[]{1,1,1,1,1,1});

        Node middle = node.next.next.next; 
        deleteMiddleNode(middle);
        assertTrue(compareLists(node, nodeAfter));
    }
    
    // 2.4 
    @Test
    public void partitionTest(){
        Node node = Node.getLists(new int[]{3,5,8,5,10,2,1});
        Node nodeAfter = Node.getLists(new int[]{3,2,1,5,8,5,10});
        Node nodePart = partitionStable(node, 5);
        assertTrue(compareLists(nodePart, nodeAfter));
    }

    //2.5
    @Test
    public void sumListReversedTest() {
        Node node1A = Node.getLists(new int[]{7,1,6});
        Node node1B = Node.getLists(new int[]{5,9,2});
        Node node1RS = Node.getLists(new int[]{2,1,9});
        Node node1S = Node.getLists(new int[]{1,3,0,8});

        Node node2A = Node.getLists(new int[]{9,5});
        Node node2B = Node.getLists(new int[]{1,1});
        Node node2RS = Node.getLists(new int[]{0,7});
        Node node2S = Node.getLists(new int[]{1,0,6});

        Node node3A = Node.getLists(new int[]{5,9});
        Node node3B = Node.getLists(new int[]{5});
        Node node3RS = Node.getLists(new int[]{0,0,1});
        Node node3S = Node.getLists(new int[]{6,4});
        assertTrue(compareLists(sumListReversed(node1A, node1B),node1RS));
        assertTrue(compareLists(sumListReversed(node2A, node2B),node2RS));
        assertTrue(compareLists(sumListReversed(node3A, node3B),node3RS));

        assertTrue(compareLists(sumList(node1A, node1B),node1S));
        assertTrue(compareLists(sumList(node2A, node2B),node2S));
        assertTrue(compareLists(sumList(node3A, node3B),node3S));

    }

    // 2.6
    @Test
    public void isPalindromeTest(){ 
        Node node1 = Node.getLists(new int[]{1,2,3,4,3,2,1});
        Node node2 = Node.getLists(new int[]{1,2,3,4,4,3,2,1});
        Node node3 = Node.getLists(new int[]{1,2,3,4,2,1});
        Node node4 = Node.getLists(new int[]{1});

        assertTrue(isPalindromeRunner(node1));
        assertTrue(isPalindromeRunner(node2));
        assertFalse(isPalindromeRunner(node3));
        assertTrue(isPalindromeRunner(node4));

        assertTrue(isPalindromeStack(node1));
        assertTrue(isPalindromeStack(node2));
        assertFalse(isPalindromeStack(node3));
        assertTrue(isPalindromeStack(node4));

        assertTrue(isPalindromeRecursive(node1));
        assertTrue(isPalindromeRecursive(node2));
        assertFalse(isPalindromeRecursive(node3));
        assertTrue(isPalindromeRecursive(node4));
    }

    // 2.7
    @Test
    public void intersectTest(){
        Node node1 = Node.getLists(new int[]{1,2,3,4,3,2,1});
        Node node2 = Node.getLists(new int[]{1,2,3,4,3,2,1});
        Node node3 = Node.getLists(new int[]{1,8,9,1,2});
        Node node4 = Node.getLists(new int[]{1,23,1,3,4});
        Node node5 = Node.getLists(new int[]{1,2,3,4,5,1});
        node3.append(node5);
        node4.append(node5);

        assertNull(intersect(node1, node2));
        assertTrue(compareNodes(node5, intersect(node3, node4)));
        assertTrue(compareNodes(node5, intersect(node3, node5)));
    }

    // 2.8. Cannot write the tests bc stackOverflow caused by the loop
    @Test
    public void loopDetectionTest(){

    }
}