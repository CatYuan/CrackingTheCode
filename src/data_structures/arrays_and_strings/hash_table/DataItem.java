package data_structures.arrays_and_strings.hash_table;

// an object that holds the data for a hash table
public class DataItem <K,V> {
    K key_;
    V value_;

    public DataItem(K key, V value) {
        key_ = key;
        value_ = value;
    }

    public K getKey() {
        return key_;
    }

    public V getValue(K key) {
        if (key_.equals(key)) {
            return value_;
        }
        return null;
    }
}
