package com.asher;

import java.util.HashSet;
import java.util.Stack;

import com.asher.Node;

/**
 * LinkedList
 */
public class LinkedList {
    // 2.1
    public static void removeDupsWithSet(Node head){
        HashSet<Integer> set = new HashSet<>();
        Node prev = null;
        while (head != null ){
            if (!set.add(head.val)){
                prev.next = head.next; 
            } else {
                prev = head; 
            }
        head = head.next;         
        }
    }

    public static void removeDupsNoBuffer(Node head){
        Node slow = head; 
        Node fast = slow;
        while(slow != null) {
            fast = slow;
            while(fast.next != null) {
                if (slow.val == fast.next.val)
                    fast.next = fast.next.next;
                else
                   fast = fast.next;
            }
            slow = slow.next;
        }
    }

    // 2.2
    public static Node returnKthElementToLast(Node head, int kth){
        Node runner = head;
        for (int i = 0; i < kth; i ++){
            if (runner.next != null) 
                runner = runner.next;
            else
                return null;
        }
        while (runner.next != null){
            runner = runner.next; 
            head = head.next; 
        }
        return head; 
    } 

    // 2.3. Assumed node is not first / last
    public static void deleteMiddleNode(Node middle) {
        middle.val = middle.next.val; 
        middle.next = middle.next.next; 
    }

    // 2.4. Stable
    public static Node partitionStable(Node head, int divider){
        Node smallH = null, smallT = null, largeH = null, largeT = null;

        while(head != null ){
            Node curr = new Node(head);
            curr.next = null; 
            if (curr.val < divider) {
                if (smallH == null){
                    smallH = curr; 
                    smallT = smallH; 
                } else {
                    smallT.next = curr; 
                    smallT = curr; 
                }
            } else {
                if (largeH == null){
                    largeH = curr; 
                    largeT = largeH; 
                } else {
                    largeT.next = curr; 
                    largeT = curr; 
                }            }
            head = head.next;
        }
        if (smallH == null){
            return largeH;
        }

        smallT.next = largeH;
        return smallH; 
    } 

    // 2.5
    public static Node sumListReversed(Node n1, Node n2){
        Node head = new Node();
        Node curr = head; 
        int carry = 0;
        while (true) {
            int sum = carry + n1.val + n2.val;
            int val = sum % 10; 
            carry = sum / 10; 
            curr.next = new Node(val); 
            curr = curr.next; 
            if (n1.next != null) {
                n1 = n1.next;
            } else {
                n1 = new Node();
            } 
            if (n2.next != null) {
                n2 = n2.next;
            } else {
                n2 = new Node();
            }
            if (n1.next == null && n2.next == null && carry == 0) {
                break;
            }
        }
        return head.next; 
    } 

    static class OneDigitSum {
        int carry;
        Node sum; 
        public OneDigitSum(int carry, Node sum) {
            this.carry = carry;
            this.sum = sum; 
        }
        public Node getSum(){
            if (carry == 1) {
                Node t = new Node(1); 
                t.next = sum;
                return t;
            } else {
                return sum; 
            }
        }
    }

    // Reversing would be cheating. 
    public static Node sumList(Node n1, Node n2){
        // 0 paddings. 
        int len1 = n1.size();
        int len2 = n2.size(); 
        if (len1 < len2) {
            n1 = padding(n1, len2-len1);
        } else {
            n2 = padding(n2, len1-len2);
        }
        return recursiveAdd(n1, n2).getSum();
    }

    private static OneDigitSum recursiveAdd(Node n1, Node n2) {
        if (n1.next == null) {
            int sum = n1.val + n2.val;
            return new OneDigitSum(sum/10, new Node(sum%10));
        }

        OneDigitSum ods = recursiveAdd(n1.next, n2.next);
        int sum = n1.val + n2.val + ods.carry; 
        int carry = sum / 10;
        Node t = new Node(sum %10);
        t.next = ods.sum; 
        return new OneDigitSum(carry, t);
    }

    private static Node padding(Node node, int padding) {
        for (int i = 0; i < padding; i++) {
            Node t = new Node();
            t.next = node; 
            node = t; 
        }
        return node; 
    }

    public static boolean isPalindromeRunner(Node node) {
        Node slow = node, fast = node, head = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Even
       if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        return compare(slow, head);
    }

    private static Node reverse(Node node) {
        Node head = new Node();
        while (node != null ){
            Node curr = head.next; 
            Node temp = new Node(node.val);
            temp.next = curr; 
            head.next = temp; 
            node = node.next; 
        }
        return head.next; 
    }
    private static boolean compare(Node n1, Node n2) {
        while (n1 != null) {
            if (n1.val != n2.val) 
                return false;
            n1 = n1.next;
            n2 = n2.next; 
        }
        return true; 
    }

    public static boolean isPalindromeStack(Node node){
        Stack<Integer> stack = new Stack<>();
        Node slow = node, fast = node;
        while (fast != null && fast.next != null) {
            stack.push(slow.val); 
            slow = slow.next;
            fast = fast.next.next;
        } 
        if (fast != null ) {
            slow = slow.next;
        }
        while(slow != null) {
            Integer val = stack.pop();
            if (val != slow.val) 
                return false;
            slow = slow.next; 
        }
        return true; 
    }

    public static boolean isPalindromeRecursive(Node node) {
        int len = node.size();
        PalindromeHelper result = isPalindromeHelper(node, len);
        return result.result; 
    }

    static class PalindromeHelper {
        boolean result; 
        Node node;
        public PalindromeHelper(boolean result, Node node) {
            this.result = result; 
            this.node = node; 
        }
    }

    // Assume no null nodes by itself
    private static PalindromeHelper isPalindromeHelper(Node node, int len){
        // Even
        if (len == 0) {
            return new PalindromeHelper(true, node);
        } else if (len == 1) {
            return new PalindromeHelper(true, node.next);
        }

        PalindromeHelper result = isPalindromeHelper(node.next, len-2);
        if (result.result == false) {
            return new PalindromeHelper(false, node);
        }
        if (result.node.val != node.val) {
            return new PalindromeHelper(false, node);
        }
        return new PalindromeHelper(true, result.node.next);
    }

    // 2.7
    public static Node intersect(Node n1, Node n2) {
        if (!doIntersect(n1, n2)) {
            return null;
        }
        int len1 = n1.size();
        int len2 = n2.size();
        if (len1 < len2) {
            n2 = goToKth(n2, len2-len1);
        } else {
            n1 = goToKth(n1, len1-len2);
        }
        while (n1 != null && n2 != null) {
            if (n1 == n2) 
                return n1;
            n1 = n1.next;
            n2 = n2.next; 
        }
        return null;
    }

    private static Node goToKth(Node node, int kth) {
        while (kth > 0) {
            node = node.next;
            kth--;
        }
        return node; 
    }

    private static boolean doIntersect(Node n1, Node n2){
        while(n1.next != null) {
            n1= n1.next;
        } 
        while (n2.next != null) { 
            n2 = n2.next;
        }
        return n1==n2; 
    }

    // 2.8
    public static Node loopDection(Node node) {
        return null;
    }
}