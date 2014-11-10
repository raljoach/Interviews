//-----------------------------------------------------------------------
// <copyright file="Solution.cs" company="MyCompany">
//     Copyright (c) MyCompany. All rights reserved.
// </copyright>
//-----------------------------------------------------------------------
package careercup.datastructures.arrays.yr130715;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* http://www.careercup.com/question?id=21263687
 * You are given an array of n integers which can contain integers from 1 to n only . 
 * Some elements can be repeated multiple times and some other elements can be absent from the array . 
 * Write a running code on paper which takes O(1) space apart from the input array and O(n) time to print which 
 * elements are not present in the array and the count of every element which is there in the array along with 
 * the element number . 
 * NOTE: The array isn't necessarily sorted.
 */
public class Solution {

    public static void main(String[] args) {
        int test = 0;
        test = test(test, Arrays.asList(1,1,3,4,6,4,7),Arrays.asList(2,5));

    }

    private static int test(int test, List<Integer> input, List<Integer> expected) {
        System.out.println("Test" + (test++));
        List<Integer> actual = solve(input);
        System.out.println("input: ");
        printList(input);

        System.out.println("Expected:");
        printList(expected);
        
        System.out.println("Actual:");
        printList(actual);
        
        if (compareLists(expected,actual)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        System.out.println("-----------------");
        return test;
    }

    private static boolean compareLists(List<Integer> expected, List<Integer> actual) {
        if(expected.size()!=actual.size()){
            return false;
        }
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int v:actual){
            if(hash.containsKey(v)){
                int count = hash.get(v);
                hash.put(v, ++count);
            }
            else{
                hash.put(v, 1);
            }
        }
        for(int e:expected){
            if(hash.containsKey(e)){
               int count = hash.get(e);               
               if(count==0){
                   System.out.println("Missing: " + e);
                   return false;
               }
               --count;
               if(count==0){
                   hash.remove(e);
               }
            }
            else {
                System.out.println("Missing: " + e);
                return false;
            }
        }
        return true;
    }

    private static void printList(List<Integer> input) {
        for (int val : input) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    private static List<Integer> solve( List<Integer> input) {
        int n = input.size();
        BitTracker bitTracker = new BitTracker(n);
        for(int v:input){
            bitTracker.set(v-1);
        }
        
        List<Integer> missing = new ArrayList<Integer>();
        for(int i=1; i<=n; i++){
            if(!bitTracker.get(i-1)){
                missing.add(i);
            }
        }
        return missing;
    }

}
