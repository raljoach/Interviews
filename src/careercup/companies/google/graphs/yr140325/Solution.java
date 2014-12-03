package careercup.companies.google.graphs.yr140325;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* http://www.careercup.com/question?id=5988741646647296
 * Given a undirected graph with corresponding edges. Find the number of possible triangles? 
 Example: 
 0 1 
 2 1 
 0 2 
 4 1 

 Answer: 
 1
 */
public class Solution {
    public static void main(String[] args) {
        int test = 0;
        test = test(test, new String[] { "0 1", "2 1", "0 2", "4 1" }, 1);

        test = test(test, new String[] { "1 2", "2 5", "1 5", "5 3", "3 4",
                "4 5" }, 2);

        test = test(test, new String[] { "1 2", "2 3", "3 1", "1 4", "4 2" }, 2);

        test = test(test, new String[] { "1 1", "1 2", "2 3", "1 3" }, 1);

        test = test(test, new String[] { "1 2", "2 4", "3 2", "3 1" }, 1);

        test = test(test, new String[] { "1 2", "3 4", "5 6", "6 6", "6 5",
                "6 7" }, 0);
    }

    private static int test(int test, String[] input, int expected) {
        System.out.println("Test" + (test++));
        System.out.println("input: " + print(input));
        System.out.println("Expected: " + expected);
        int actual = solve2(input);
        System.out.println("Actual: " + actual);
        if (expected == actual) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        System.out.println("-----------------");
        return test;
    }
    
    //Improvement: check for edge between pair of vertices in adjacency list
    private static int solve2(String[] input){
        Map<Integer, List<Integer>> hash = new HashMap<Integer, List<Integer>>();
        for (String line : input) {
            String[] tokens = line.split("\\s");
            int v1 = Integer.parseInt(tokens[0]);
            int v2 = Integer.parseInt(tokens[1]);

            if (hash.containsKey(v1)) {
                List<Integer> list = hash.get(v1);
                list.add(v2);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(v2);
                hash.put(v1, list);
            }

            if (v1 != v2) {
                if (hash.containsKey(v2)) {
                    List<Integer> list = hash.get(v2);
                    list.add(v1);
                } else {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(v1);
                    hash.put(v2,list);
                }
            }
        }
        int triCount=0;
        for(int first:hash.keySet()){
            List<Integer> list = hash.get(first);
            for(int i=0; i<list.size(); i++)
            {
                int second = list.get(i);
                if(second!=first){
                for(int j=i+1; j<list.size(); j++){
                    int third = list.get(j);
                 if(third!=first && third!=second){
                     if(hash.containsKey(second) && hash.get(second).contains(third)){
                         triCount++;
                     }
                 }
                }
                }
            }
        }
        return triCount/3;
    }

    private static int solve(String[] input) {
        Map<Integer, List<Integer>> hash = new HashMap<Integer, List<Integer>>();
        for (String line : input) {
            String[] tokens = line.split("\\s");
            int v1 = Integer.parseInt(tokens[0]);
            int v2 = Integer.parseInt(tokens[1]);

            if (hash.containsKey(v1)) {
                List<Integer> list = hash.get(v1);
                list.add(v2);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(v2);
                hash.put(v1, list);
            }

            if (v1 != v2) {
                if (hash.containsKey(v2)) {
                    List<Integer> list = hash.get(v2);
                    list.add(v1);
                } else {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(v1);
                    hash.put(v2,list);
                }
            }
        }

        List<String> triList = new ArrayList<String>();
        for (int first : hash.keySet()) {
            List<Integer> list = hash.get(first);
            if (list.size() >= 2) {
                for (int second : list) {
                    if (second != first && hash.containsKey(second)) {
                        for (int third : hash.get(second)) {
                            if (third != first && third != second
                                    && hash.containsKey(third)) {
                                for (int fourth : hash.get(third)) {
                                    if (fourth == first) {
                                        int[] triangle = new int[] { first,
                                                second, third };
                                        Arrays.sort(triangle);
                                        String result = "";
                                        for (int s : triangle) {
                                            if (result != "") {
                                                result += " ";
                                            }
                                            result += s;
                                        }
                                        if(!triList.contains(result)){
                                        triList.add(result);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return triList.size();
    }

    private static String print(String[] input) {
        String result = "\n";
        for (String r : input) {
            result += r + "\n";
        }
        return result;
    }

}
