//-----------------------------------------------------------------------
// <copyright file="Solution.cs" company="MyCompany">
//     Copyright (c) MyCompany. All rights reserved.
// </copyright>
//-----------------------------------------------------------------------
package companies.microsoft.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Implement an algorithm to return all subsets of a set
 * Also implement an enumerable interface that allows you to
 * return a specific subset
 */
public class Solution {

    public static void main(String[] args) {
        int test =0;
        test = test(test,new int[]{1,2,3}, 
                Arrays.asList(
                        new ArrayList<Integer>(),
                        Arrays.asList(1),
                        Arrays.asList(2),
                        Arrays.asList(1,2),
                        Arrays.asList(3),
                        Arrays.asList(1,3),
                        Arrays.asList(2,3),                       
                        Arrays.asList(1,2,3)));

    }

    private static int test(int test, int[] set, List<List<Integer>> expected) {
        System.out.println("Test" + (test++));
        System.out.println("input: " + print(set));
        List<List<Integer>> actual = solve(set);        

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

    private static boolean areEqual(List<List<Integer>> expected,
            List<List<Integer>> actual) {
        // TODO Auto-generated method stub
        return false;
    }

    private static String print(List<List<Integer>> expected) {
        // TODO Auto-generated method stub
        return null;
    }

    private static List<List<Integer>> solve(int[] set) {
        // TODO Auto-generated method stub
        return null;
    }

    private static String print(int[] set) {
        // TODO Auto-generated method stub
        return null;
    }

}
