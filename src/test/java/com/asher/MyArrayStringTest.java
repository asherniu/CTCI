package com.asher;

import org.testng.annotations.*;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.*;
import static com.asher.MyArrayString.*;

public class MyArrayStringTest 
{
    static String EMPTY = "";
    static Integer[][] MATRIX_R1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    static Integer[][] MATRIX_R2 = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
    static Integer[][] MATRIX_R3 = {{1, 2, 3, 4}, {5, 6, 7, 8}, 
    {9, 10, 11, 12}, {13, 14, 15, 16}};
    static Integer[][] MATRIX_R4 =  {{13, 9, 5, 1}, {14, 10, 6, 2}, 
    {15, 11, 7, 3}, {16, 12, 8, 4}};

    static Integer[][] MATRIX_Z1 = {{1, 2, 3}, {4, 0, 6}, {7, 8, 9}, {10, 11, 12}};
    static Integer[][] MATRIX_Z2 = {{1, 0, 3}, {0, 0, 0}, {7, 0, 9}, {10, 0, 12}};
    static Integer[][] MATRIX_Z3 = {{0, 2, 3, 4}, {5, 6, 7, 8}, 
    {9, 10, 0, 12}, {13, 14, 15, 16}};
    static Integer[][] MATRIX_Z4 = {{0, 0, 0, 0}, {0, 6, 0, 8}, 
    {0, 0, 0, 0}, {0, 14, 0, 16}};

    // 1.1
    @Test
    public void isUniqueTest()
    {
        String s1 = "Aa";
        String s2 = "aa";
        String s3 = "AaBbCc";
        assertTrue(isUniqueBrute(EMPTY));
        assertTrue(isUniqueBrute(s1));
        assertFalse(isUniqueBrute(s2));
        assertTrue(isUniqueBrute(s3));

        assertTrue(isUniqueSet(EMPTY));
        assertTrue(isUniqueSet(s1));
        assertFalse(isUniqueSet(s2));
        assertTrue(isUniqueSet(s3));
    }

    // 1.2
    @Test
    public void checkPermTest() {
        String s1 = "abc";
        String s2 = "bac";
        String s3 = "abcde";
        String s4 = "ABC";
        String s5 = "b    ac";

        assertTrue(checkPerm(EMPTY, EMPTY));
        assertFalse(checkPerm(EMPTY, s1));
        assertTrue(checkPerm(s1, s2));
        assertFalse(checkPerm(s1, s3));
        assertFalse(checkPerm(s1, s4));
        assertFalse(checkPerm(s1, s5));
    }

    // 1.3
    @Test(enabled = false)
    public void URLifyTest(){

    }

    // 1.4
    @Test
    public void isPalindromePermTest(){
        String s1 = "Tact Coa";
        String s2 = "ABCUDe";
        String s3 = "aaaaaaaa";
        String s4 = "aaaaaaB";
        String s5 = "aaaaaaa";

        assertTrue(isPalindromePerm(EMPTY));
        assertTrue(isPalindromePerm(s1));
        assertFalse(isPalindromePerm(s2));
        assertTrue(isPalindromePerm(s3));
        assertTrue(isPalindromePerm(s4));
        assertTrue(isPalindromePerm(s5));        
    }

    // 1.5 
    @Test
    public void isOneAwayTest(){
        String s1 = "a";
        String s2 = "pale";
        String s3 = "pales";
        String s4 = "pal";
        String s5 = "bake";
        String s6 = "bale";

        assertTrue(isOneAway(s1, EMPTY));
        assertTrue(isOneAway(s3, s2));
        assertTrue(isOneAway(s2, s4));
        assertTrue(isOneAway(s2, s6));
        assertFalse(isOneAway(s2, s5));
    }

    // 1.6
    @Test
    public void compressionTest() {
        String s1 = "abc";
        String s2 = "a";
        String s3 = "aaaaaaaa";
        String s4 = "aa"; 
        String s5 = "aAaA";

        assertEquals(s1, compression(s1));
        assertEquals(s2, compression(s2));
        assertEquals("8a", compression(s3));
        assertEquals(s4, compression(s4));
        assertEquals(s5, compression(s5));
        
    }

    // 1.7
    @Test
    public void rotateMatrixTest() {
        Integer[][] MATRIX_R1R = rotateMatrix(MATRIX_R1);
        Integer[][] MATRIX_R3R = rotateMatrix(MATRIX_R3);
        for (int i = 0; i < MATRIX_R1.length; i ++ ) {
            for (int j = 0; j < MATRIX_R1[0].length; j ++ ) {
                assertEquals(MATRIX_R1R[i][j], MATRIX_R2[i][j]);
            }
        }
        for (int i = 0; i < MATRIX_R3.length; i ++ ) {
            for (int j = 0; j < MATRIX_R3[0].length; j ++ ) {
                assertEquals(MATRIX_R3R[i][j], MATRIX_R4[i][j]);
            }
        }
    }

    // 1.8
    @Test
    public void zeroMatrixTest() {
        Integer[][] MATRIX_Z1Z = zeroMatrix(MATRIX_Z1);
        Integer[][] MATRIX_Z3Z = zeroMatrix(MATRIX_Z3);
        for (int i = 0; i < MATRIX_Z1.length; i ++ ) {
            for (int j = 0; j < MATRIX_Z1[0].length; j ++ ) {
                assertEquals(MATRIX_Z1Z[i][j], MATRIX_Z2[i][j]);
            }
        }
        for (int i = 0; i < MATRIX_Z3.length; i ++ ) {
            for (int j = 0; j < MATRIX_R3[0].length; j ++ ) {
                assertEquals(MATRIX_Z3Z[i][j], MATRIX_Z4[i][j]);
            }
        }
    }

    // 1.9
    @Test
    public void isStringRotationTest() {
        String s1 = "waterbottle";
        String s2 = "bottlewater";
        String s3 = "bottelwaert";
        String s4 = "waterbottl";

        assertTrue(isStringRotation(s1, s2));
        assertTrue(isStringRotation(s2, s1));
        assertFalse(isStringRotation(s1, s3));
        assertFalse(isStringRotation(s1, s4));
    }
}
