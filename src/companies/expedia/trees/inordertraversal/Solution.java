//-----------------------------------------------------------------------
// <copyright file="Solution.cs" company="MyCompany">
//     Copyright (c) MyCompany. All rights reserved.
// </copyright>
//-----------------------------------------------------------------------
package companies.expedia.trees.inordertraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import companies.google.pairdancers.Pair;

/* c) What are the different traversals of the tree- write inorder. 
d) By modifying your inorder function - print only the given kth node ( so say 4 is given as an input, print the 4th node in inorder traversal )
 * 
 */
public class Solution {

    public static void main(String[] args) {
        int test = 0;
        TreeNode root, A, B, C, D, E, F, G;
        root = new TreeNode("Root",A=new TreeNode("A",null,null),B=new TreeNode("B",null,null));
        test = test(test, root, Arrays.asList(A,root,B));
                
        C = new TreeNode("C",E=new TreeNode("E",null,null),F=new TreeNode("F",null,null));
        D = new TreeNode("D",null,G=new TreeNode("G",null,null));
        A.left = C;
        B.right = D;
        test = test(test,root,Arrays.asList(E,C,F,A,root,B,D,G));
    }

    private static int test(int test, TreeNode root, List<TreeNode> expected) {
        System.out.println("Test" + (test++));
        List<TreeNode> actual = solve(root);
        
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

    private static List<TreeNode> solve(TreeNode root) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        inorder(root, result);
        return result;
    }

    private static void inorder(TreeNode root, List<TreeNode> result) {
        if(root!=null){
            inorder(root.left,result);
            result.add(root);
            inorder(root.right,result);
        }
    }

    private static String print(List<TreeNode> actual) {
        String result = "";
        for(TreeNode n:actual){
            result += n.data + " ";
        }
        return result;
    }

    private static boolean areEqual(List<TreeNode> expected,
            List<TreeNode> actual) {
        int eCount = expected.size();
        int aCount = actual.size();
        if(eCount!=aCount){
            System.out.println("Error: Expected("+eCount+")and Actual("+aCount+") do not match in number of elements");
            return false;
        }
        for(int i=0; i<eCount; i++){
            TreeNode e=expected.get(i);
            TreeNode a=actual.get(i);
            boolean found = e.data==a.data;           
            if(!found){
                System.out.println("Error: Actual does not contain " + e.data);
                return false;
            }
        }
        return true;
    }

}
