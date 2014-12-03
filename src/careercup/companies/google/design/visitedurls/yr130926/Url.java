package careercup.companies.google.design.visitedurls.yr130926;

public class Url implements Comparable<Url> {
    public String uri;
    public int freq;
    public Url(String uri, int freq) {
        this.uri = uri;
        this.freq = freq;
    }
    @Override
    public int compareTo(Url other) {
        return -1 * new Integer(this.freq).compareTo(new Integer(other.freq));
    }

}
