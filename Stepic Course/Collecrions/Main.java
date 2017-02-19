package Collecrions;
import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean nech = false;
        ArrayList<Integer> integers = new ArrayList<>();
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                if (nech) {
                    integers.add(scanner.nextInt());
                    nech = !nech;
                }
                else {
                    scanner.nextInt();
                    nech = !nech;
                }
            }
            else scanner.nextByte();
        }
        integers.forEach(System.out::print);
        for (int i = integers.size()- 1; i >= 0; i--) {
            System.out.print(integers.get(i));
            if (i != 0)
                System.out.print(" ");
        }
       // System.out.flush();
    }

    public static <T> Set<T> difference (Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> set = new HashSet<>();
        for (T element : set1) {
            if (set2.contains(element))
                continue;
            set.add(element);
        }
        return set;
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> set = new HashSet<>();
        set.addAll(difference(set1,set2));
        set.addAll(difference(set2,set1));
        return set;
    }
}

