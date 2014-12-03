package careercup.companies.google.arrays.yr130823;

import java.util.Arrays;

/* http://www.careercup.com/question?id=5201559730257920
 * Give you an array which has n integers,it has both positive and negative integers.Now you need sort this array in
 * a special way.After that,the negative integers should in the front,and the positive integers should in the back.
 * Also the relative position should not be changed. 
   eg. -1 1 3 -2 2 ans: -1 -2 1 3 2. 
   o(n)time complexity and o(1) space complexity is perfect.
 */
public class Solution {

    public static void main(String[] args) {
        int test = 0;
        test = test(test,new int[]{-1, 1, 3, -2, 2}, new int[]{-1, -2, 1, 3, 2});

    }

    private static int test(int test, int[] input, int[] expected) {
        System.out.println("Test" + (test++));
        System.out.println("input: " + print(input));
        int[] actual = solve(input);
        System.out.println("Actual:" + print(actual));
        if (areEqual(expected,actual)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        System.out.println("-----------------");
        return test;
    }

    private static int[] solve(int[] input) {
        Numeral[] a = new Numeral[input.length];
        for(int i=0; i<input.length; i++){
            Numeral n = new Numeral(input[i]);
            a[i] = n;
        }
        
        Arrays.sort(a);
        int[] result = new int[input.length];
        for(int j=0; j<input.length; j++){
            result[j] = a[j].number;
        }
        return result;
    }

    private static boolean areEqual(int[] expected, int[] actual) {
        if (expected == null) {
            return actual == null;
        }
        if (actual == null) {
            return false;
        }
        if (actual.length != expected.length) {
            System.out.println("Expected length ("+expected.length + ") and Actual length (" + actual.length + ") don't match");
            return false;
        }
        for (int i = 0; i < expected.length; i++) {
            int e = expected[i];
            int a = actual[i];

            if(e!=a){
                System.out.println("Error: Did not find " + e);
                return false;
            }
        }

        return true;
    }

    private static String print(int[] input) {
        String result = "\n[";
        for (int v : input) {
            result += v + " ";
        }
        result += "]\n";
        return result;
    }

}
