//-----------------------------------------------------------------------
// <copyright file="Solution.cs" company="MyCompany">
//     Copyright (c) MyCompany. All rights reserved.
// </copyright>
//-----------------------------------------------------------------------
package careercup.datastructures.strings.yr130302;

import java.util.List;

/* http://www.careercup.com/question?id=15555796
 * 
 */
public class Solution {

    public static void main(String[] args) {
        int test = 0;
        test = test(test,"abcdefg","ba",true);

    }

    private static int test(int test, String str1, String str2, boolean expected) {
        System.out.println("Test" + (++test));
        boolean actual = solve(str1, str2);
        System.out.println(str1 + " " + str2);

        System.out.println("Expected:" + expected);
        System.out.println("Actual:" + actual);
        if (expected == actual) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        System.out.println("-----------------");
        return test;
    }

    private static boolean solve(String str1, String str2) {
        SuffixTree suffixTree = new SuffixTree(str1);
        if(suffixTree.contains(str2)){
            return true;
        }
        List<String> perms = getPerms(str2);
        for(String p:perms){
            if(suffixTree.contains(p)){
                return true;
            }
        }
        return false;
    }

    private static List<String> getPerms(String str2) {
        // TODO Auto-generated method stub
        return null;
    }

}
