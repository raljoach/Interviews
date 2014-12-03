package careercup.companies.google.math.aggregatenumber.yr121116;

/* http://www.careercup.com/question?id=14948278
 * we will name a number "aggregated number" if this number has the following attribute: 
 just like the Fibonacci numbers 
 1,1,2,3,5,8,13..... 

 the digits in the number can divided into several parts, and the later part is the sum of the former parts. 

 like 112358, because 1+1=2, 1+2=3, 2+3=5, 3+5=8 
 122436, because 12+24=36 
 1299111210, because 12+99=111, 99+111=210 
 112112224, because 112+112=224 
 so can you provide a function to check whether this number is aggregated number or not?
 */
public class Solution {

    public static void main(String[] args) {
        int test = 0;
        test = test(test, 112358, true);
        test = test(test, 122436, true);
        test = test(test, 1299111210, true);
        test = test(test, 101, true);
        test = test(test, 919, false);
    }

    private static int test(int test, int num, boolean expected) {

        System.out.println("Test" + (test++));
        System.out.println("input: " + num);
        System.out.println("Expected: " + expected);
        boolean actual = solve(num);
        System.out.println("Actual:" + actual);
        if (expected == actual) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        System.out.println("-----------------");
        return test;
    }

    private static boolean solve(int num) {
        if (num < 99) {
            return false;
        }
        return isAggregate(num);
    }    

    private static boolean isAggregate(int num) {
        if (num == 0) { //num: 112358
            return true;
        }
        for (int div = 10; (num / div) > 0; div *= 10) {
            int sum = num % div; // digit3 = 8
            int leftPart = num / div; // leftPart: 11235

            for (int subDiv = 10; (num / subDiv) > 0; subDiv *= 10) {
                int op2 = leftPart % subDiv; // digit2=5
                int leftPart2 = leftPart / subDiv; // leftPart=1123
                if (op2 > sum) {
                    break;
                }

                for (int subDiv2 = 10; (num / subDiv2) > 0; subDiv2 *= 10) {
                    int op3 = leftPart2 % subDiv2; // digit1=3
                    int leftPart3 = leftPart2 / subDiv2;
                    if (op3 > sum) {
                        break;
                    }
                    
                    // System.out.println(op3 + "+" + op2 + "=" + sum);
                    if (op3 + op2 == sum) {
                        if (leftPart3 == 0) {
                            return true;
                        }
                        if (isAggregate(leftPart)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
