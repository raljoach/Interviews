//-----------------------------------------------------------------------
// <copyright file="Solution.cs" company="MyCompany">
//     Copyright (c) MyCompany. All rights reserved.
// </copyright>
//-----------------------------------------------------------------------
package careercup.datastructures.arrays.yr130715;

public class BitTracker {
    private static double intSize = 32; //num bits within int
    private int[] set;
    public BitTracker(int numBits) {
       double n = Math.ceil(numBits/intSize);
       set = new int[(int)n];       
    }

    public void set(int bitNum) {
        int section = getSection(bitNum);
        int slot = getBit(bitNum);
        section |= (1<<slot);
        int index = getSectionIndex(bitNum);
        set[index] = section;
    }
    
    public boolean get(int bitNum) {
        int section = getSection(bitNum);
        int slot = getBit(bitNum);
        int compare = (section>>slot)&1;
        return compare==1;
    }

    private int getBit(int bitNum) {
        int slot = (int) (bitNum % intSize);
        return slot;
    }

    private int getSection(int bitNum) {
        int index = getSectionIndex(bitNum);
        int section = set[index];
        return section;
    }

    private int getSectionIndex(int bitNum) {
        double index = bitNum/intSize;
        return (int)index;
    }    
}
