package data_structures.arrays_and_strings.hash_table;

@FunctionalInterface
public interface HashFunction<K> {
  /**
   * a function which takes in a key of a data item
   * and returns an index to the location of the data item
   * @param key - the key to look for
   * @return - index of the location or -1 if the key does not exist
   */
  public int hash(K key);
}
