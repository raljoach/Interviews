package careercup.companies.google.design.visitedurls.yr130926;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer implements Comparable<Computer> {

    private int nextLargest = 0;
    private Map<String,Integer> counts = new HashMap<String,Integer>();
    private List<Url> list = new ArrayList<Url>();
    
    public List<String> urls = new ArrayList<String>();
   
    public Computer(String file) throws Exception {
        File f = new File(file);
        if (f.exists()) {
            StreamReader sr = new StreamReader(file);
            String url = null;
            if ((url = sr.readLine()) != null) {
                urls.add(url.toLowerCase().trim());
            }
        } else {
            throw new Exception("File: " + file + " does not exist");
        }               
    }
    
    public Computer(String[] urlSet)
    {
        for(String u:urlSet){
            urls.add(u.toLowerCase().trim());
        }
    }
    
    public Map<String,Integer>  getCounts()
    {
        counts.clear();
        list.clear();
        for(String url:urls){
            if(counts.containsKey(url)){
                int c = counts.get(url);
                counts.put(url, c+1);
            }
            else{
                counts.put(url,1);
            }
        }
        
        
        for(String key:counts.keySet())
        {
            Url u = new Url(key, counts.get(key));
            list.add(u);
        }
        
        Collections.sort(list);
        return counts;
        
    }
    
    public Url getNextLargest() /*throws Exception*/{
        /*if(nextLargest==counts.size()){
            throw new Exception("Invalid index: " + nextLargest);
        }*/
        return list.get(nextLargest);
    }
    
    public Url removeNextLargest(){
        Url url = getNextLargest();
        nextLargest++;
        return url;
    }
    public boolean hasMore(){
        return nextLargest<counts.size();
    }
    
    public void reset(){
        nextLargest = 0;
    }

    @Override
    public int compareTo(Computer other) {
        return -1 * new Integer(this.getNextLargest().freq).compareTo(new Integer(other.getNextLargest().freq));
    }
}

