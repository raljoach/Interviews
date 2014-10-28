//-----------------------------------------------------------------------
// <copyright file="Solution.cs" company="MyCompany">
//     Copyright (c) MyCompany. All rights reserved.
// </copyright>
//-----------------------------------------------------------------------
package careercup.datastructures.strings.yr130302;

public class SuffixTree {

    private SuffixNode root = new SuffixNode(null);
    public SuffixTree(String str) {
        this.insert(str);
    }

    public boolean contains(String s) {
        return root.contains(s);
    }
    
    private void insert(String str){
        //int endIndex = str.length();
        //for(int start=str.length()-1; start>=0; start--){
        //    String subStr = str.substring(start, endIndex);
        int strLen = str.length();
        for (int end = 1; end <= strLen; end++) {
            String prefix = str.substring(0, end);
            root.insert(prefix);
        }
    }
}
