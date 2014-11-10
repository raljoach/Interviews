//-----------------------------------------------------------------------
// <copyright file="Solution.cs" company="MyCompany">
//     Copyright (c) MyCompany. All rights reserved.
// </copyright>
//-----------------------------------------------------------------------
package careercup.datastructures.dp.yr141022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* http://www.careercup.com/question?id=5931067269709824
 * Given a string (1-d array) , find if there is any sub-sequence that repeats itself. 
 Here, sub-sequence can be a non-contiguous pattern, with the same relative order. 

 Eg: 

 1. abab <------yes, ab is repeated 
 2. abba <---- No, a and b follow different order 
 3. acbdaghfb <-------- yes there is a followed by b at two places 
 4. abcdacb <----- yes a followed by b twice 

 The above should be applicable to ANY TWO (or every two) characters in the string and optimum over time. 

 In the sense, it should be checked for every pair of characters in the string.
 */
public class Solution {

    public static void main(String[] args) {
        int test = 0;
        test = test(test, "abab", "ab");
        test = test(test, "abba", null);
        test = test(test, "acbdaghfb", "ab");
        test = test(test, "abcdacb", "ab");
    }

    private static int test(int test, String input, String expected) {
        System.out.println("Test" + (test++));
        String actual = solve(input);
        System.out.println("input: " + input);

        System.out.println("Expected:" + expected);
        System.out.println("Actual:" + actual);
        if ((expected == null && actual == null) || expected.equals(actual)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        System.out.println("-----------------");
        return test;
    }

    private static String solve(String input) {
        // Scan and store in hash locations of each character
        Map<Character, List<Integer>> hash = getLocations(input);

        // Invoke LongestCommonSubsequence algorithm on all pairs of strings
        // that start with the same character
        String maxLCS = null;
        for (char key : hash.keySet()) {
            List<Integer> locs = hash.get(key);
            int n = locs.size();
            if (n > 1) {
                for (int i = 0; i < n; i++) {
                    int s = locs.get(i);
                    for (int j = i + 1; j < n; j++) {
                        int t = locs.get(j);
                        String lcs = longCommSubseq(input, s, t);
                        if (lcs != null && lcs.length() > 1) {
                            if (maxLCS == null
                                    || maxLCS.length() < lcs.length()) {
                                maxLCS = lcs;
                            }
                        }
                    }
                }
            }
        }

        return maxLCS;
    }

    private static String longCommSubseq(String input, int start1, int start2) {
        int n = input.length();
        int h = start2 - start1;
        int l = n - start2;
        int[][] L = new int[h][l];
        String seq = null;
        int prevMatchIndex = -1;
        for (int i = start1; i < start2; i++) {
            for (int j = start2; j < n; j++) {
                char c1 = input.charAt(i);
                char c2 = input.charAt(j);
                int i2 = i - start1;
                int j2 = j - start2;
                if (c1 == c2) {
                    if (seq == null) {
                        seq = new String(new char[] { c1 });
                    } else if (j > prevMatchIndex) {
                        seq += c1;
                        prevMatchIndex = j;
                    }

                    L[i2][j2] = 1 + getVal(L, i2 - 1, j2 - 1);
                } else {
                    L[i2][j2] = Math.max(getVal(L, i2 - 1, j2),
                            getVal(L, i2, j2 - 1));
                }
            }
        }
        return seq;
    }

    private static int getVal(int[][] L, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        return L[i][j];
    }

    private static Map<Character, List<Integer>> getLocations(String input) {
        Map<Character, List<Integer>> hash = new HashMap<Character, List<Integer>>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            List<Integer> list = null;
            if (hash.containsKey(c)) {
                list = hash.get(c);
            } else {
                list = new ArrayList<Integer>();
                hash.put(c, list);
            }
            list.add(i);
        }
        return hash;
    }

}
