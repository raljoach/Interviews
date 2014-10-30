package companies.tableau.sort;
/* Stores a character or an integer
 * 
 */
public class Item implements Comparable<Object> {
    private Object value = null;
    public Item(Object val) throws Exception{        
        if(val==null){
            throw new Exception("Value cannot be null!");
        }
        else if(!val.getClass().equals(Integer.TYPE) ||
                !val.getClass().equals(Character.TYPE)){
            throw new Exception("Value must be of type int or char");
        }
        this.value = val;
    }
    
    @Override
    public int compareTo(Object other) {
        if(other==null){ return 1; } //null item comes before non-null
        if(this.value==null) { return -1; }
        if(this.value.getClass().equals(Character.TYPE)){
            if(other.getClass().equals(Character.TYPE)){
                return ((Character)this.value).compareTo((Character)other);
            }
            else{
                return -1;
            }
        }
        else {
            if(other.getClass().equals(Integer.TYPE)){
                return ((Integer)this.value).compareTo((Integer)other);
            }
            else{
                return +1;
            }
        }
    }

}
