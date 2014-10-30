//-----------------------------------------------------------------------
// <copyright file="Solution.cs" company="MyCompany">
//     Copyright (c) MyCompany. All rights reserved.
// </copyright>
//-----------------------------------------------------------------------
package companies.tableau.sort;

/* Given an array containing numbers and characters,
 * sort the array such that all letters come before numbers
 * and all numbers and characters are sorted
 * Example: [A, 1, B, 3, C, 4] => [A,B,C,1,3,4]
 */
public class Solution {

    public static void main(String[] args) {
        int test =0;
        test = test(test,new Object[]{'A',1,'B',2,'C',3}, new Object[]{'A','B','C',1,2,3});
    }

    private static int test(int test, Object[] input, Object[] expected) {
        System.out.println("Test" + (++test));
        System.out.println("input: " + print(input));
        Object[] actual = solve(input);
        
        System.out.println("Expected:" + print(expected));
        System.out.println("Actual:" + print(actual));
        if ((expected == null && actual == null) || areEqual(expected,actual)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        System.out.println("-----------------");
        return test;
    }

    private static boolean areEqual(Object[] expected, Object[] actual) {
        // TODO Auto-generated method stub
        return false;
    }

    private static Object[] solve(Object[] input) {
        // TODO Auto-generated method stub
        return null;
    }

    private static String print(Object[] input) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
