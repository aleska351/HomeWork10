package com.company;
import java.util.Objects;

public class Pair<K, V> {

    public final K key;
    public final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public boolean equals(Object o) {
        return o instanceof Pair && Objects.equals(key, ((Pair<?,?>)o).key) && Objects.equals(value, ((Pair<?,?>)o).value);
    }

    public int hashCode() {
        return 31 * Objects.hashCode(key) + Objects.hashCode(value);
    }

    public String toString() {
        return key + "=" + value;
    }
}