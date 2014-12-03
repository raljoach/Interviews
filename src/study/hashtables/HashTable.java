package study.hashtables;

public class HashTable {    
    private Object[] table;
    public HashTable(int size){
        table = new Object[size];
    }
    
    public void put(int key, Object object){
        int index = hash(key);
        if(table[index]==null){
            table[index] = object;
        }
        else{
            //Collision resolution strategy
            //1 Linear Probing
            //2 Double addressing
            //3 LinkedList insert
        }
    }
    
    public Object get(int key){        
        return null;
    }
    
    private int hash(int key){
        int tableSize = this.table.length;
        int index = key % tableSize;
        return index;
    }
    
    private boolean linearProbe(int index, Object object){
        return false;
    }
    
    private boolean doubleAddress(int index, Object object){
        return false;
    }
    
    private boolean insert(int index, Object object){
        return false;
    }
}
