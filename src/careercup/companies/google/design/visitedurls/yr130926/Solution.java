package careercup.companies.google.design.visitedurls.yr130926;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* http://www.careercup.com/question?id=4681660918398976
 * Given a large network of computers, each keeping log files of visited urls, 
 * find the top ten of the most visited urls. 
 (i.e. have many large <string (url) -> int (visits)> maps, 
 calculate implicitly <string (url) -> int (sum of visits among all distributed maps), 
 and get the top ten in the combined map) 

 The result list must be exact, and the maps are too large to transmit over the network 
 (especially sending all of them to a central server or using MapReduce directly, is not allowed)
 */
public class Solution {

    public static void main(String[] args) throws Exception {
        solve(1, Arrays.asList(new String[] { "htttp://www.site0.com",
                "http://www.site25.com", "http://www.site33.com",
                "http://www.site19.com", "htttp://www.site22.com",
                "htttp://www.site44.com", "htttp://www.site0.com",
                "htttp://www.site22.com", "http://www.site25.com",
                "htttp://www.site0.com", "htttp://www.site44.com",
                "http://www.site25.com", "htttp://www.site0.com" },
                new String[] { "htttp://www.site1.com",
                        "htttp://www.site1.com", "htttp://www.site1.com",
                        "htttp://www.site0.com", "htttp://www.site1.com",
                        "htttp://www.site1.com", "htttp://www.site2.com",
                        "htttp://www.site1.com", "htttp://www.site2.com",
                        "htttp://www.site3.com", "htttp://www.site4.com",
                        "htttp://www.site5.com", "htttp://www.site6.com", }),
                new Url[] { new Url("htttp://www.site1.com", 6),
                        new Url("http://www.site25.com", 3),

                });
    }
    
    private static Url[] solve2(int topN, List<String[]> urls, Url[] expected)
    {
        //Get counts of unique urls on each computer
        //Merge the countHashes from all computers into 1 big hash or distribute it into seperate files
        //Create an ordered list of files (sort largest to smallest)
        //  Each file is a chunk of the counts sorted from largest to smallest
        //   for each countHash,
        //       get hash index of file it should belong in
        //          see if it exists there
        //             if no, then insert
        //             else yes, then update: currentSum + newSum
        //Apply algorithm to get topN urls
        
        List<Computer> computers = new ArrayList<Computer>();
        // List<String> fileNames = new ArrayList<String>();

        // for (String fileName : fileNames) {
        Map<String,Integer> oneHash = null;
        for (String[] urlSet : urls) {
            // Computer c = new Computer(fileName);
            Computer c = new Computer(urlSet);
            computers.add(c);
            Map<String,Integer> counts = c.getCounts();
            if(oneHash==null){
                oneHash = counts;
            }
            else{
                merge(oneHash,counts);
            }
        }
               
        return null;
    }

    private static Url[] solve(int topN, List<String[]> urls, Url[] expected)
            throws Exception {
        List<Computer> computers = new ArrayList<Computer>();
        // List<String> fileNames = new ArrayList<String>();

        // for (String fileName : fileNames) {

        for (String[] urlSet : urls) {
            // Computer c = new Computer(fileName);
            Computer c = new Computer(urlSet);
            computers.add(c);
            c.getCounts();
        }

        Collections.sort(computers);
        Url[] result = new Url[topN];
        int i = 0;

        // for (int i = 0; i < computers.size(); i++) {
        // for (int j = i + 1; j < computers.size(); j++) {

        while (topN > 0 && i < computers.size()) {
            Computer firstComp = computers.get(i);
            while (!firstComp.hasMore() && i < computers.size()) {
                ++i;
                firstComp = computers.get(i);
            }

            int j = i + 1;
            if (j == computers.size()) {
                while (topN > 0 && firstComp.hasMore()) {
                    result[result.length - topN] = firstComp
                            .removeNextLargest();
                }
            }
            Computer secondComp = computers.get(j);
            if (!secondComp.hasMore() && j < computers.size()) {
                j++;
                secondComp = computers.get(j);
            }
            while (topN > 0
                    && firstComp.hasMore()
                    && firstComp.getNextLargest().freq >= secondComp
                            .getNextLargest().freq) {
                result[result.length - topN] = firstComp.removeNextLargest();
                --topN;
            }

            if (topN > 0) {
                if (firstComp.hasMore()) {
                    for (int k = j; k < computers.size(); k++) {
                        Computer otherComp = computers.get(k);
                        if (otherComp.hasMore()
                                && otherComp.getNextLargest().freq > firstComp
                                        .getNextLargest().freq) {

                            // Swap
                            computers.set(i, otherComp);
                            computers.set(j, firstComp);
                        } else {
                            break;
                        }
                    }
                } else {
                    ++i;
                }
            }
        }
        return result;
        // }
    }

    private static void merge(Map<String, Integer> oneHash,
            Map<String, Integer> counts) {
        for(String key:counts.keySet())
        {
            if(oneHash.containsKey(key))
            {
                oneHash.put(key, oneHash.get(key) + counts.get(key));
            }
            else
            {
                oneHash.put(key, counts.get(key));
            }
        }
        
    }
}
