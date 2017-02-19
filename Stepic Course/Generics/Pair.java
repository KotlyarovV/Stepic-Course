package Generics;

/**
 * Created by vitaly on 11.02.17.
 */
public class Pair <S,T> {
    private S first;
    private T second;

    private Pair (S s, T t) {
        this.first = s;
        this.second = t;
    }

    public static <S,T> Pair  of (S s, T t) {
        Pair<S,T> pair = new Pair<>(s,t);
        return pair;
    }

    public S getFirst(){return first;}

    public T getSecond () {return second;}

    @Override
    public int hashCode() {
        int firstHash;
        int secondHash;
        firstHash = first == null ?  0 :  first.hashCode();
        secondHash = second == null ? 0 : second.hashCode();
        return firstHash*2+secondHash;
    }

    @Override
    public boolean equals (Object o) {
        if (!(o instanceof Pair))
            return false;
        Pair pair = (Pair) o;
        if (pair.hashCode() != hashCode() )
            return false;
        if (first == null && second == null)
            return pair.first == null && pair.second == null;
        if (first == null)
            return pair.first == null && pair.second.equals(second);
        if (second == null)
            return pair.second == null && pair.first.equals(first);
        return (pair.getFirst().equals(this.getFirst()) && pair.getSecond().equals(this.getSecond()));
    }
}
