//-----------------------------------------------------------------------
// <copyright file="Solution.cs" company="MyCompany">
//     Copyright (c) MyCompany. All rights reserved.
// </copyright>
//-----------------------------------------------------------------------
package companies.tableau.comparefiles;

import java.util.Arrays;
import java.util.List;

/* Given 2 xml files as input, output 3 files
 * 1st output file contains leaf elements found in left file only.
 * 2nd output file contains common leaf elements found in both files
 * 3rd output file contains leaf elements round in right file only
 */
public class Solution {

    public static void main(String[] args) {
        int test = 0;
        test = test(test,
                   "<MetaData>\n"+
                   "  <Category>\n" + 
                   "     <Name>Foo</Name>\n" + 
                   "  </Category>\n" + 
                   "  <Group>\n" +
                   "     <Domain>PHX</Domain>\n" + 
                   "</MetaData>",
                   "<MetaData>\n"+
                   "  <Field>\n" + 
                   "     <Name>Foo</Name>\n" + 
                   "  </Field>\n" + 
                   "  <Category>\n" +
                   "     <Attribute>Bar</Attribute>\n" + 
                   "</MetaData>",
                   Arrays.asList("PHX"),
                   Arrays.asList("Foo"),
                   Arrays.asList("Bar"));

    }

    private static int test(int test, String file1, String file2,
            List<String> expectedLeft, List<String> expectedMiddle, List<String> expectedRight) {
        return 0;
    }

}
