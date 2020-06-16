package data_structures.arrays_and_strings.hash_table;

import data_structures.AbstractDataType;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * A generic hashtable that uses separate chaining.
 *
 * What is the starting size?
 *      11, the choice is arbitrary
 *      It happens that Java also uses 11 as the initial size
 *
 * When to resize?
 *      when the hash table is at 3/4 capacity
 *
 * What to resize to?
 *      double the size and round up to the nearest prime number
 *
 * The same item cannot be inserted twice into the hash table
 *
 * @param <T> - the DataItem to be stored in the hash table
 */
public class HashTable <T extends DataItem> extends AbstractDataType<T> {
  private final double resizeThreshold = 0.75;

  private LinkedList<T> _table[];
  private HashFunction _hash;
  private int numItems;

  public HashTable(HashFunction hash) {
    _hash = hash;
    Arrays.fill(_table, new LinkedList<T>());
    numItems = 0;
  }

  public HashTable(HashFunction hash, int tableSize) {
    _table = new LinkedList[tableSize];
    Arrays.fill(_table, new LinkedList<T>());
    numItems = 0;
  }

  @Override
  public void insert(T item) {
    ++numItems;
    if (shouldResize()) {
      resize();
    }
    int index = getIndex(item.getKey());
    if (_table[index].isEmpty()) {
      _table[index] = new LinkedList<>();
    }
    if (_table[index].indexOf(item) < 0) {
      _table[index].add(item);
    }
  }

  @Override
  public void remove(T item) {
    if(_table[getIndex(item.getKey())].remove(item)) {
      --numItems;
    }
  }

  @Override
  // returns the value of the corresponding key
  public <K, V>V search(K key) {
    int index = getIndex(key);
    for (T dataItem : _table[index]) {
      if (dataItem != null && dataItem.getKey() == key) {
        return (V) dataItem.getValue(key);
      }
    }
    return null;
  }

  @Override
  public boolean isEmpty() {
    for (LinkedList<T> list: _table) {
      if (!list.isEmpty()) { return false; }
    }
    return true;
  }

  private boolean shouldResize() {
    return numItems/_table.length >= resizeThreshold;
  }

  private void resize() {
    int newSize = nearestPrime(_table.length * 2);
    HashTable<T> newTable = new HashTable<T>(this._hash, newSize);
    for (int i = 0; i < _table.length; ++i) {
      LinkedList<T> list = _table[i];
      for (int j = 0; j < list.size(); ++j) {
        newTable.insert(list.get(j));
      }
    }
    this._hash = newTable._hash;
  }

  private <K>int getIndex(K key) {
    return _hash.hash(key) % _table.length;
  }

  private int nearestPrime(int num) {
    BigInteger newSize = new BigInteger(String.valueOf(num));
    return newSize.isProbablePrime(1) ? newSize.intValue() : newSize.nextProbablePrime().intValue();
  }
}
