package companies.tableau.palindrome;

/*
 * Get the max palindrome with 2 three digits number multiplication.
 * 
 */
public class Solution {

	public static void main(String[] args) {

		int test = 0;
		test = test(test, 10, 99, 91 * 99);
		test = test(test,100,999,906609);
	}

	private static int test(int test, int min, int max, int expected) {
		System.out.println("Test" + (++test));
		int actual = solve(min, max);
		System.out.println("range: " + min + "-" + max);

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

	private static int calc(int max, int i, int j) {
		int num = i * j;
		if (isPalindrome(num)) {
			if (num > max) {
				max = num;
			}
		}
		return max;
	}

	private static int solve(int rangeMin, int rangeMax) {
		int max = Integer.MIN_VALUE;
		for (int i = rangeMin; i <= rangeMax; i++) {
			for (int j = rangeMin; j <= rangeMax; j++) {
				max = calc(max, i, j);
			}
		}
		return max;
	}

	private static boolean isPalindrome(int number) {
		int s = 0;
		int n = number;
		while (n > 0) {
			int digit = n % 10;
			n = n / 10; // chop off last digit
			s = s * 10 + digit;
		}
		return (s == number);
	}

}
