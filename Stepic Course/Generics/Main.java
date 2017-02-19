package Generics;

import java.util.logging.Logger;
/**
 * Created by vitaly on 11.02.17.
 */
public class Main {

    public static Logger logger = Logger.getLogger(Main.class.getName()) ;

    public static void main (String[] args) {
        Pair<Integer, String> pair = Pair.of(1, null);
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        logger.info(s);
        Pair<Integer, String> pair2 = Pair.of(1, null);
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
    }
}
