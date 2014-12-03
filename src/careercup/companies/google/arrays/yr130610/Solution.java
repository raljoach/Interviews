package careercup.companies.google.arrays.yr130610;

/* http://www.careercup.com/question?id=19286747
 * Given an array of integers. Find two disjoint contiguous sub-arrays such that the absolute difference between the 
 * sum of two sub-array is maximum. 
 * The sub-arrays should not overlap. 

 eg- [2 -1 -2 1 -4 2 8] ans - (-1 -2 1 -4) (2 8), diff = 16 

 I gave him o(n^2) algorithm but he was not satisfied.
 * 
 */
public class Solution {

    public static void main(String[] args) {
        int test = 0;
        test = test(test, new int[] { 2, -1, -2, 1, -4, 2, 8 }, 16);

    }

    private static int test(int test, int[] input, int expected) {
        System.out.println("Test" + (test++));
        System.out.println("input: " + print(input));
        int actual = solve2(input);
        System.out.println("Actual:" + actual);
        if (expected == actual) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        System.out.println("-----------------");
        return test;
    }

    private static int solve(int[] input) {
        int maxDiff = Integer.MIN_VALUE;
        int[] sum = new int[input.length];
        sum[0] = input[0];
        for (int k = 1; k < input.length; k++) {
            sum[k] = sum[k - 1] + input[k];
        }

        for (int m = 0; m < sum.length; m++) {
            int diff = Math.abs(sum[sum.length - 1] - sum[m] - sum[m]);
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }
        return maxDiff;

    }

    private static int solve2(int[] input) {
        int maxDiff = Integer.MIN_VALUE;
        int[] sum = new int[input.length];
        sum[0] = input[0];
        for (int k = 1; k < input.length; k++) {
            sum[k] = sum[k - 1] + input[k];
        }

        for (int m = 0; m < sum.length; m++) {
            for (int i = 0; i <= m; i++) {
                int firstArray = sum[m];
                if(i>0){
                    firstArray-=sum[i-1];
                }
                for (int j = m + 1; j <= sum.length; j++) {
                    int secondArray = sum[sum.length-1] - sum[j-1];
                    
                    int diff = Math.abs(firstArray - secondArray);
                    if (diff > maxDiff) {
                        maxDiff = diff;
                    }
                }
            }
        }
        return maxDiff;

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
