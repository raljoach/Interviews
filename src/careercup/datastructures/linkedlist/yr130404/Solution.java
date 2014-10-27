//-----------------------------------------------------------------------
// <copyright file="Solution.cs" company="MyCompany">
//     Copyright (c) MyCompany. All rights reserved.
// </copyright>
//-----------------------------------------------------------------------
package careercup.datastructures.linkedlist.yr130404;

/* http://www.careercup.com/question?id=16917698
 * Write a function which returns kth element from the tail in a linked list.
 */
public class Solution {

    public static void main(String[] args) throws Exception {
        int test = 0;
        test = test(test, new int[] { 1, 2, 3, 4, 5, 6 }, 2, 5);
        test = test(test, new int[] { 8, 1, 6, 5, 4 }, 3, 6);
    }

    private static int test(int test, int[] input, int k, int expected)
            throws Exception {
        System.out.println("Test" + (++test));
        int actual = solve(input, k);
        System.out.println("list: ");
        for (int val : input) {
            System.out.print(val + " ");
        }
        System.out.println();

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

    private static int solve(int[] input, int k) throws Exception {
        Node head = LinkedList.create(input);
        Node n2 = head;
        for (int i = k; i > 0; i--) {
            if (n2 == null) {
                throw new Exception("K value is too large!");
            }
            n2 = n2.next;
        }

        Node n1 = head;
        while (n2 != null) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n1.value;
    }
}
