package careercup.companies.google.intervals.yr130403;

import java.util.Arrays;

public class Answer {

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

    private static int[] solve(int[] input1, int[] input2, int[] input3) {
        int i = 0;
        int p1 = 0, p2 = 0, p3 = 0;
        int min = Integer.MAX_VALUE;
        int[] interval = new int[]{0,0};
        while ((p1 != input1.length) && (p2 != input2.length)
                && (p3 != input3.length)) {
            int v1 = input1[p1], v2 = input2[p2], v3 = input3[p3];
            int range = findRange(v1, v2, v3, interval);
            min = Math.min(range, min);
            int which = findMin(v1, v2, v3);

            switch (which) {
            case 1:
                p1++;
                break;
            case 2:
                p2++;
                break;
            case 3:
                p3++;
                break;
            }

        }
        // (*t)--;
        // cout<<*p1<<"'"<<*p2<<"'"<<*p3<<"'"<<min<<endl;
        return interval;
    }
    
    private static String print(int[] input) {
        String result = "";
        for (int v : input) {
            result += v + " ";
        }
        return result;
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
/*
    private static int findRange(int p1, int p2, int p3) {
        return Math.max(Math.max(Math.abs(p1 - p2), Math.abs(p2 - p3)),
                Math.abs(p3 - p1));
    }*/
    
    private static int findRange(int p1, int p2, int p3, int[] interval) {        
        int max = Math.abs(p3 - p1);
        //int[] range = new int[]{p1,p3};
        int range12 = Math.abs(p2-p1);
        int range23 = Math.abs(p3-p2);
        if(max<range12){
            max = range12;
            interval[0] = p1;
            interval[1] = p2;
            Arrays.sort(interval);
        }
        if(max<range23){
            max = range23;
            interval[0] = p2;
            interval[1] = p3;
            Arrays.sort(interval);
        }
        return max;
    }

    private static int findMin(int p1, int p2, int p3) {
        int min = p1;
        int which = 1;
        if (min > p2) {
            min = p2;
            which = 2;
        }
        if (min > p3) {
            return 3;
        }
        return which;
    }

}
