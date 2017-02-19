package FunctionalInterfeises;
import java.util.function.*;
import java.util.*;

public class Main {
    public static void main (String[] arg) {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return (O) -> {
            if (condition.test(O))
                return ifTrue.apply(O);
            else
                return ifFalse.apply(O);
        };
    }
}
