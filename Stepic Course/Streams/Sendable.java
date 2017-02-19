package Streams;

/**
 * Created by vitaly on 19.02.17.
 */
public interface Sendable<T> {
    String getFrom();
    String getTo();
    T getContent();
}
