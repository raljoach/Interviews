//-----------------------------------------------------------------------
// <copyright file="Solution.cs" company="MyCompany">
//     Copyright (c) MyCompany. All rights reserved.
// </copyright>
//-----------------------------------------------------------------------
package careercup.datastructures.strings.yr130302;

import java.util.ArrayList;
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

    private static List<String> getPerms(String str) {
        return getPerms(0,str);
    }

    private static List<String> getPerms(int index, String str) {
        List<String> list = new ArrayList<String>();
        if(index==str.length()){            
            list.add("");            
        }
        else{
            char item = str.charAt(index);
            List<String> subPerms = getPerms(index+1,str);
            for(String s:subPerms){
                for(int i=0; i<=s.length(); i++){
                    String first = "";
                    if(i>0){
                        first = s.substring(0, i);
                    }
                    String second = "";
                    if(i<s.length()){
                        second = s.substring(i);
                    }
                    String newPerm = first + item + second;
                    list.add(newPerm);
                }
            }
        }
        return list;
    }

}
