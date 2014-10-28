//-----------------------------------------------------------------------
// <copyright file="Solution.cs" company="MyCompany">
//     Copyright (c) MyCompany. All rights reserved.
// </copyright>
//-----------------------------------------------------------------------
package careercup.datastructures.strings.yr130302;

import java.util.ArrayList;
import java.util.List;

public class SuffixNode {
    private static String endMarker = "$";
    public String value;
    public List<SuffixNode> children = new ArrayList<SuffixNode>();

    public SuffixNode(String val) {
        this.value = val;
    }

    public void insert(String str) {
        SuffixNode found = null;
        String remStr = null;
        int strLen = str.length();
        for (int end = 1; end <= strLen; end++) {
            String prefix = str.substring(0, end);
            for (SuffixNode c : children) {
                if (c.value.equals(prefix)) {
                    found = c;
                    if(end<strLen){
                        remStr = str.substring(end, strLen);
                    }
                    break;
                }
            }
        }
        if (found == null) {
            SuffixNode newNode = new SuffixNode(str);
            newNode.children.add(new SuffixNode(endMarker));
            this.children.add(newNode);
        }
        else{
            if(remStr!=null){
                found.insert(remStr);
            }
        }
    }

    public boolean contains(String str) {
        if(str==null || str.equals("")){
            return false;
        }
        if(this.value!=null && this.value.equals(str)){
            return true;
        }
        else {
            SuffixNode found = null;
            String remStr = null;
            int strLen = str.length();
            for (int end = 1; end <= strLen; end++) {
                String prefix = str.substring(0, end);
                for (SuffixNode c : children) {
                    if (c.value.equals(prefix)) {
                        found = c;
                        if(end<strLen){
                            remStr = str.substring(end, strLen);
                        }
                        break;
                    }
                }
            }
            
            if (found == null) {
                return false;
            }
            else{
                if(remStr!=null){
                    return found.contains(remStr);
                }
                else{
                    return true;
                }
            }
        }
    }

}
