package careercup.companies.google.arrays.yr130804;

public class Person implements Comparable<Person> {
    public int height;
    public int numLarger;
    public Person(int h, int l) {
        this.height = h;
        this.numLarger = l;
    }
    @Override
    public int compareTo(Person other) {
        return -1 * new Integer(this.height).compareTo(other.height);
    }
}
