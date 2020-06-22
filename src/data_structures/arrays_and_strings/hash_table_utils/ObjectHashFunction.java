package data_structures.arrays_and_strings.hash_table_utils;

// a generic class, limited to objects, that creates a hash function
public class ObjectHashFunction<T extends Object> implements HashFunction<T>{
  @Override
  public int hash(T key) {
    return key.hashCode();
  }
}
