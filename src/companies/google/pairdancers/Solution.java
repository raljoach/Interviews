//-----------------------------------------------------------------------
// <copyright file="Solution.cs" company="MyCompany">
//     Copyright (c) MyCompany. All rights reserved.
// </copyright>
//-----------------------------------------------------------------------
package companies.google.pairdancers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Problem: Pair dancers
Neighborhood of homes containing people. Pair them up for a dance under 2 conditions:
1. Pair people of opposite gender
2. If a partner is available in the home, preference is given to them. Don't pair outside the home unless no partner is available in the home.
Input: List/container (unordered) of people
Output: List/container of unordered pairs
Define any data structures needed, a Person is a good start.
Ignore any unpaired people.
 * 
 */
public class Solution {

    public static void main(String[] args) {
        int test = 0;
        boolean isMale = true;
        Person A, B, C, D;
        test = test(
                test,
                Arrays.asList(A=new Person("A",isMale), B=new Person("B",!isMale)),
                Arrays.asList(new Pair(A,B)));
        
        test = test(
                test,
                Arrays.asList(A=new Person("A",isMale), B=new Person("B",!isMale),
                              C=new Person("C",!isMale), D=new Person("D",isMale)),
                Arrays.asList(new Pair(A,B), new Pair(C,D)));
        
        test = test(
                test,
                Arrays.asList(A=new Person("A",isMale), B=new Person("B",isMale),
                              C=new Person("C",!isMale), D=new Person("D",isMale)),
                Arrays.asList(new Pair(A,C)));
        
        test = test(
                test,
                Arrays.asList(A=new Person("A",!isMale), B=new Person("B",!isMale),
                              C=new Person("C",isMale), D=new Person("D",!isMale)),
                Arrays.asList(new Pair(C,A)));
        
        test = test(
                test,
                Arrays.asList(A=new Person("A",!isMale), B=new Person("B",!isMale),
                              C=new Person("C",isMale), D=new Person("D",isMale)),
                Arrays.asList(new Pair(A,C), new Pair(B,D)));

    }

    private static int test(int test, List<Person> input, List<Pair> expected) {
        System.out.println("Test" + (test++));
        System.out.println("input: " + printPersons(input));
        List<Pair> actual = solve(input);        

        System.out.println("Expected:" + printPairs(expected));
        System.out.println("Actual:" + printPairs(actual));
        if ((expected == null && actual == null) || areEqual(expected,actual)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        System.out.println("-----------------");
        return test;
    }

    private static List<Pair> solve(List<Person> input) {
        int i=-1;
        int mPointer = -1;
        int fPointer = -1;
        int n = input.size();
        List<Pair> result = new ArrayList<Pair>();
        while(i<n && mPointer<n && fPointer<n){
            Person male = null, female = null;
            if(i==-1){i=0;}
            else { i = mPointer+1; }
            while(i<n && !input.get(i).isMale){
                ++i;
            }
            if(i<n){
                mPointer = i;
                male = input.get(i);
            }
            if(i==-1){i=0;}
            else { i = fPointer+1; }
            while(i<n && input.get(i).isMale){
                ++i;
            }
            if(i<n){
                fPointer = i;
                female = input.get(i);
                ++i;
            }
            if(male!=null && female!=null){
                result.add(new Pair(male,female));
            }
        }
        return result;
    }

    private static boolean areEqual(List<Pair> expected, List<Pair> actual) {
        int eCount = expected.size();
        int aCount = actual.size();
        if(eCount!=aCount){
            System.out.println("Error: Expected("+eCount+")and Actual("+aCount+") do not match in number of elements");
            return false;
        }
        for(Pair e:expected){
            boolean found = false;
            for(Pair a:actual){
                if((e.A==a.A && e.B==a.B) ||
                   (e.A==a.B && e.B==a.A)){
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("Error: Actual does not contain pair " + printPair(e));
                return false;
            }
        }
        return true;
    }

    private static String printPersons(List<Person> input) {
        String result = "";
        for(Person p:input){
            String s = "("+p.name+",isMale="+p.isMale+")";
            result += s + " ";
        }
        return result;
    }

    private static String printPairs(List<Pair> expected) {
        String result = "";
        for(Pair p:expected){
            String s = printPair(p);
            result += s + " ";
        }
        return result;
    }

    private static String printPair(Pair p) {
        String s = "("+p.A.name+","+p.B.name+")";        
        return s;
    }


}
