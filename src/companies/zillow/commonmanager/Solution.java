package companies.zillow.commonmanager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* Given 2 employees, find the lowest common manager
 * between them
 */
public class Solution {

    public static void main(String[] args) {
        int test=0;
        Employee A,B,C,D,E,F,G,H,I;
        A=new Employee("A");
        A.addReports(
                Arrays.asList(
                B=new Employee("B"),
                C=new Employee("C"),
                D=new Employee("D")));
        B.addReports(Arrays.asList(E=new Employee("E"),F=new Employee("F")));
        C.addReports(Arrays.asList(G=new Employee("G")));
        D.addReports(Arrays.asList(H = new Employee("H")));
        E.addReports(Arrays.asList(I=new Employee("I")));
        test = test(test,F,G,A);

        test = test(test,E,F,B);
        test = test(test,F,I,B);
        test = test(test,A,F,A);
    }

    private static int test(int test, Employee e1, Employee e2, Employee expected) {        
        System.out.println("Test" + (test++));
        Employee actual = solve(e1,e2);
        System.out.println("input: " + e1.name + " " + e2.name);

        System.out.println("Expected:" + ((expected==null)?"null":expected.name));
        System.out.println("Actual:" + ((actual==null)?"null":actual.name));
        if (expected == actual) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        System.out.println("-----------------");
        return test;
    }

    private static Employee solve(Employee e1, Employee e2) {
        Map<Employee,Boolean> visited = new HashMap<Employee,Boolean>();
        Employee current = e1;
        while(current!=null){
            visited.put(current,true);
            current = current.manager;
        }
        current = e2;
        while(current!=null && !visited.containsKey(current)){            
            current = current.manager;
        }
        return current;
    }

}
