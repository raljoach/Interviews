package careercup.companies.google.arrays.yr130823;

public class Numeral implements Comparable<Numeral> {

    public int number;
    public Numeral(int number){
        this.number = number;
    }
    @Override
    public int compareTo(Numeral other) {
        if(this.number<0){
            if(other.number<0){
                return 0;
            }
            else{
                return -1;
            }
        }
        else{
            if(other.number<0){
                return 1;
            }
            else{
                return 0;
            }
        }
    }

}
