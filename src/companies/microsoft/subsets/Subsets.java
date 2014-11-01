package companies.microsoft.subsets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Subsets implements List<List<Integer>> {
    
    private List<Integer> set;
    private double numSubSets;
    public Subsets(List<Integer> set){
        this.set = set;
        int n = set.size();
        this.numSubSets = Math.pow(2, n);
    }

    @Override
    public boolean add(List<Integer> e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void add(int index, List<Integer> element) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean addAll(Collection<? extends List<Integer>> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends List<Integer>> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Integer> get(int index) {
        return getSet(index);
    }
    
    public List<List<Integer>> getAllSubsets()
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0; i<this.numSubSets; i++){
            List<Integer> newSet = getSet(i);
            result.add(newSet);
        }
        return result;
    }

    private List<Integer> getSet(int i) {
        int k=i;
        int index=0;
        List<Integer> newSet = new ArrayList<Integer>();
        while(k>0){
            if((k&1)==1){
                newSet.add(set.get(index));
            }
            k>>=1;
            ++index;
        }
        return newSet;
    }


    @Override
    public int indexOf(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<List<Integer>> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ListIterator<List<Integer>> listIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ListIterator<List<Integer>> listIterator(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Integer> remove(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Integer> set(int index, List<Integer> element) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<List<Integer>> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        return null;
    }

}
