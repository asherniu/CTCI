package com.asher;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Array and String
 * Assuming no inputs are null, and can be empty. 
 */
public class ArrayString{
    // 1.1 brute force
    public static boolean isUniqueBrute(String s){
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // 1.1 with hash set
    public static boolean isUniqueSet(String s) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            boolean add = set.add(s.charAt(i));
            if (add == false) return false; 
        }
        return set.size() == s.length();
    }

    // 1.2
    public static boolean checkPerm(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < s1.length(); i++ ){
            sum ^= s1.charAt(i);
            sum ^= s2.charAt(i);
        }
        return sum == 0;
    }

    // 1.3
    public static String URLify(String s) {
        return "";
    } 

    // 1.4
    public static boolean isPalindromePerm(String s) {
        String sL = s.toLowerCase();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char i = 'a'; i <= 'z'; i++) {
            map.put(i, 0);
        }
        for (int i = 0; i < sL.length(); i++ ) {
            if (sL.charAt(i) >= 'a' && sL.charAt(i) <= 'z' )
                map.put(sL.charAt(i), map.get(sL.charAt(i)) + 1);
        }
        int numberOfOdd = 0;
        for (int i : map.values()) {
            if (i % 2 == 1) 
            numberOfOdd++;
        }
        
        return numberOfOdd == 0 || numberOfOdd == 1;
    }

    // 1.5. Assuming s1.length() always >= s2.length()
    public static boolean isOneAway(String s1, String s2) {
        if (s1.length() - s2.length() > 1) 
            return false;
        for (int i = 0; i < s2.length();) {
            if (s1.charAt(i) == s2.charAt(i))
                i++;
            else{
                // Insertion/Deletion
                if ((s1.substring(i+1)).equals(s2.substring(i))) 
                    return true;
                else if ((s1.substring(i+1)).equals(s2.substring(i+1)))
                    return true;
                else
                    return false;
            }
        }
        return true;
    }

    // 1.6
    public static String compression(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            char curr = s.charAt(i);
            int num = 1; int j = i + 1;
            for (; j < s.length(); j++) {
                if (s.charAt(j) == curr)
                    num++;
                else
                    break;
            }
            sb.append(num); sb.append(curr);
            i = j;
        }
        if (sb.toString().length() < s.length() )
            return sb.toString();
        else 
            return s; 
    }

    // 1.7. Not in place. Assume NxN.
    public static Integer[][] rotateMatrix(Integer[][] matrix) {
        if (matrix.length == 1) return matrix;
        Integer[][] mR = new Integer[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                mR[j][matrix.length - i - 1] = matrix[i][j];
            }
        }
        return mR;
    }

    //1.8. Assume N x M
    public static Integer[][] zeroMatrix(Integer[][] matrix) {
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++){
                 if (matrix[i][j] == 0) {
                     row.add(i); col.add(j);
                 }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++){
                if (row.contains(i) || col.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }
    
    //1.9.
    public static boolean isStringRotation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        String s3 = s2 + s2;
        return s3.contains(s1);
    }
}
