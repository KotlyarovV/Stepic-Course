package Streams;

/**
 * Created by vitaly on 19.02.17.
 */
public class Salary implements Sendable{
    private String from;
    private String to;
    private Integer size;
    public Salary (String from, String to, int size) {
        this.from = from;
        this.to = to;
        this.size = size;
    }
    public String getFrom () {
        return from;
    }
    public String getTo() {
        return to;
    }

    public Integer getContent() {
        return size;
    }
}