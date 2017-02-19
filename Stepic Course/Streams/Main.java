package Streams;
import Generics.Pair;

import java.util.*;
import java.io.*;
import java.util.stream.*;
import java.util.function.*;

public class Main {

    private static int mid(int number) {
        return number * number / 10 % 1000;
    }

    public static IntStream pseudoRandomStream(int seed) {
        IntStream intStream = IntStream.iterate(seed, n -> mid(n));
        return intStream;
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List <? extends  T> a = stream.collect(Collectors.toList());
        if (a.size() == 0) {minMaxConsumer.accept(null, null);}
        else {
            a.sort(order);
            T min = a.get(0);
            T max = a.get(a.size() - 1);
            minMaxConsumer.accept(min, max);
        }
    }
    public static class Pair  {
        private String elements;
        private int counter = 0;
        public static Set<Pair> pairs = new HashSet<>();
        private Pair (String elements) {
            this.elements = elements.toLowerCase();
            this.counter++;
        }

        public static void  makePair (String a) {
            if (!pairs.contains(new Pair(a))) pairs.add(new Pair(a));
            else {
                    for (Pair p : pairs)
                        if (p.equals(new Pair(a)))
                            p.counter++;
            }
        }
        public void toLowerCase() {
            this.elements.toLowerCase();
        }

        @Override
        public int hashCode() {
            return elements.hashCode();
        }

        @Override
        public boolean equals (Object o) {
            if (!(o instanceof Pair)) return false;
            return ((Pair)o).elements.equals(this.elements);
        }

        public  void print() {
            System.out.print(this.elements+ "\n");
        }

    }


    public static void main (String [] arg) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        Comparator<Pair> comparator = (n, n1) -> {
            if (n.counter != n1.counter)
                return  (n.counter > n1.counter) ? -1 : 1;
            else return n.elements.compareTo(n1.elements);
        };
        String[] words = line.split("[^\\p{L}\\p{Digit}]+");
        for (String word : words) {
            Pair.makePair(word);
        }

        Stream<Pair> stream = Pair.pairs.stream()
                .peek(Pair::toLowerCase)
                .sorted(comparator)
                .limit(10)
                ;
        stream.forEach(Pair::print);
    }
}