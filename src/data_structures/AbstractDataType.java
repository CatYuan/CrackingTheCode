package data_structures;

// A generic abstract class for data structures
public abstract class AbstractDataType<T> {

  // inserts an item into the data structure
  public abstract void insert(T item);

  // removes the item from the data structure
  public abstract void remove(T item);

  // searches for an item and returns something that
  // 'points' to the item in the data structure
  public abstract <K, V>V search(K key);

  // checks if the data structure is empty or not
  public abstract boolean isEmpty();
}
