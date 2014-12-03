package careercup.companies.google.arrays.yr130804;

import java.util.Arrays;
import java.util.List;

/* http://www.careercup.com/question?id=24532662
 * You are given two array, first array contain integer which represent heights of persons and 
 * second array contain how many persons in front of him are standing who are greater than him in term 
 * of height and forming a queue. Ex 
A: 3 2 1 
B: 0 1 1 
It means in front of person of height 3 there is no person standing, person of height 2 there is one person 
in front of him who has greater height then he, similar to person of height 1. Your task to arrange them 
Ouput should be. 
3 1 2 
Here - 3 is at front, 1 has 3 in front ,2 has 1 and 3 in front.


Example #2:
Though I like the idea of sorting using the comparator as mentioned above by amitb2108 but 
below is the approach that came to my mind first. 
lets say height[] = {3,1,2,4} 
pos[] = {0,2,1,0}; //no of persons greater height than him 
1. create an array of person struct of size n and fill the data from the above two arrays 
struct person 
{ 
int height; 
int num; 
}; 
2. Sort the person array with height as the key in decreasing order. o(nlgn) 
index 0,1,2,3 
person[] = {4,3,2,1} 
{0,0,1,2} //person.num 
3. Remember the index of array represents the no of persons greater in front of the current index. e.g. person with height 3 has array index 1, so 1 person is in front of him with greater height. But we need to have 0 no of person greater than 3, so swap it with index 0. 
person[] = {3,4,2,1} //after swapping 3 
//2 has only one person in front but index of 2 is 2 currently there are 2 persons 
//swap it with index 1 
person[] = {3,2,4,1} 
//1 has only 2 persons in front but index of 1 is 3, so currently there are 3 persons 
//swap it with index 2 
person[] = {3,2,1,4} 


 */
public class Solution {

    public static void main(String[] args) {
        int test=0;
        test = test(test, new int[]{3,2,1}, new int[]{0,1,1}, new int[]{3,1,2});
        
        test = test(test,new int[]{3,1,2,4}, new int[] {0,2,1,0}, new int[]{3,2,1,4});
        
    }

    private static int test(int test, int[] heights, int[] larger, int[] expected) {
        System.out.println("Test" + (test++));
        System.out.println("heights: " + print(heights));
        System.out.println("larger: " + print(larger));
        System.out.println("expected: " + print(expected));
        int[] actual = solve(heights,larger);
        System.out.println("Actual:" + print(actual));
        if (areEqual(expected,actual)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        System.out.println("-----------------");
        return test;
    }       

    private static int[] solve(int[] heights, int[] larger) {
        Person[] people = new Person[heights.length];
        for(int i=0; i<heights.length; i++){
            people[i] = new Person(heights[i], larger[i]);
        }
        int[] result = new int[heights.length];
        Arrays.sort(people);
        for(int k=0; k<people.length; k++){            
            int numLarger = people[k].numLarger;
            if(numLarger!=k)//swap k and numLarger index items
            {
                Person tmp = people[numLarger];
                people[numLarger] = people[k];
                people[k] = tmp;
            }
        }
        for(int i=0; i<heights.length; i++){
            result[i] = people[i].height;
        }
        return result;
    }

    private static String print(int[] input) {
        String result = "\n[";
        for (int v : input) {
            result += v + " ";
        }
        result += "]\n";
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
}

