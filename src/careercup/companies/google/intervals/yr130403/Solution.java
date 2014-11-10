package careercup.companies.google.intervals.yr130403;

import java.util.Arrays;
import java.util.List;

/* http://www.careercup.com/question?id=16759664
 * You have k lists of sorted integers. Find the smallest range that includes at least one number from each of the k lists. 

 For example, 
 List 1: [4, 10, 15, 24, 26] 
 List 2: [0, 9, 12, 20] 
 List 3: [5, 18, 22, 30] 

 0 4 5 9 10 12 15 20 22 24 26 30

 set iEnd, jEnd, kEnd
 find 2 largest
 check to see if current iEnd, jEnd, kEnd are within range
 if NO
 decrement the array xEnd pointer that has the next largest value (compare iEnd-1, jEnd-1, kEnd-1)

 The smallest range here would be [20, 24] as it contains 24 from list 1, 20 from list 2, and 22 from list 3.
 * 
 */
public class Solution {

    public static void main(String[] args) {
        int test = 0;
        test = test(test, new int[] { 4, 10, 15, 24, 26 }, new int[] { 0, 9,
                12, 20 }, new int[] { 5, 18, 22, 30 }, new int[] { 20, 24 });

    }

    private static int test(int test, int[] input1, int[] input2, int[] input3,
            int[] expected) {
        System.out.println("Test" + (test++));
        int[] actual = solve(input1, input2, input3);
        System.out.println("list: " + print(input1));
        System.out.println("list: " + print(input2));
        System.out.println("list: " + print(input2));

        System.out.println("Expected:" + print(expected));
        System.out.println("Actual:" + print(actual));
        if ((expected == null && actual == null) || areEqual(expected, actual)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        System.out.println("-----------------");
        return test;
    }

    /*
     * 1)Find the minimum of all list's last index List 1: [4, 10, 15, 24, 26]
     * List 2: [0, 9, 12, 20] List 3: [5, 18, 22, 30] which is 20 from List 2,
     * take it as lower range. 2)Binary search in List 1 and List 3, and find
     * its immediate greater value, which is 24 in List 1, and 22 in List 3.
     * 3)Take the maximum of these two values as upper range(Which is 24).
     * 4)Hence [20-24] is the required range. Kindly correct me, if i am wrong.
     */
    private static int[] solve(int[] input1, int[] input2, int[] input3) {
        int[] merged = new int[input1.length + input2.length + input3.length];
        int[] source = new int[input1.length + input2.length + input3.length];
        merge(input1, input2, input3, merged, source);
        if (merged.length < 2) {
            return null;
        }
        int sIndex = merged.length - 2;
        int eIndex = merged.length - 1;
        int start = merged[sIndex];
        int end = merged[eIndex];

        List<Integer> notFound = Arrays.asList(1, 2, 3);
        for (int i = sIndex; i <= eIndex; i++) {
            notFound.remove(source[i]);
            if (notFound.size() == 0) {
                break;
            }
        }

        if (notFound.size() == 0) {
            return new int[] { merged[sIndex], merged[eIndex] };
        }
        return null;
    }

    private static void merge(int[] input1, int[] input2, int[] input3,
            int[] merged, int[] source) {
        int i = 0, j = 0, k = 0;
        int loc = 0;
        while (i < input1.length && j < input2.length && k < input3.length) {
            if (input1[i] <= input2[j] && input1[i] <= input3[k]) {
                merged[loc] = input1[i++];
                source[loc++] = 1;
            } else if (input2[j] <= input1[i] && input2[j] <= input3[k]) {
                merged[loc] = input2[j++];
                source[loc++] = 2;
            } else {
                merged[loc] = input3[k++];
                source[loc++] = 3;
            }
        }

        while (i < input1.length && j < input2.length) {
            if (input1[i] < input2[j]) {
                merged[loc] = input1[i++];
                source[loc++] = 1;
            } else {
                merged[loc] = input2[j++];
                source[loc++] = 2;
            }
        }

        while (i < input1.length && k < input3.length) {
            if (input1[i] < input3[k]) {
                merged[loc] = input1[i++];
                source[loc++] = 1;
            } else {
                merged[loc] = input3[k++];
                source[loc++] = 3;
            }
        }

        while (j < input2.length && k < input3.length) {
            if (input2[j] < input3[k]) {
                merged[loc] = input2[j++];
                source[loc++] = 2;
            } else {
                merged[loc] = input3[k++];
                source[loc++] = 3;
            }
        }

        while (i < input1.length) {
            merged[loc] = input1[i++];
            source[loc++] = 1;
        }

        while (j < input2.length) {
            merged[loc] = input2[j++];
            source[loc++] = 2;
        }

        while (k < input3.length) {
            merged[loc] = input3[k++];
            source[loc++] = 3;
        }
    }

    private static boolean withinRange(int val, int start, int end) {
        return val >= start && val <= end;
    }

    private static boolean areEqual(int[] expected, int[] actual) {
        if (expected.length != actual.length) {
            System.out
                    .println("Expected and Actual are not the same size or length");
            return false;
        }

        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual[i]) {
                System.out.println("Expected and Actual don't match at index: "
                        + i + " expected: " + expected[i] + " actual: "
                        + actual[i]);
                return false;
            }
        }

        return true;
    }

    private static String print(int[] input) {
        String result = "";
        for (int v : input) {
            result += v + " ";
        }
        return result;
    }

}
