package Streams;

import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by vitaly on 18.02.17.
 */
public class MailService<T> implements Consumer<Sendable>{
    private HashMap <String, List<T>> mailBox = new HashMap<String,List<T>>(){
        @Override public List<T> get(Object key) {
            return super.getOrDefault(key, new ArrayList<T>());
        }
    };
    public Map<String,List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(Sendable t) {
        if (!mailBox.containsKey(t.getTo())) {
            ArrayList<T> arL = new ArrayList<T>();
            arL.add((T)t.getContent());
            mailBox.put(t.getTo(), arL);
        }
        else mailBox.get(t.getTo()).add((T)t.getContent());
    }

}

