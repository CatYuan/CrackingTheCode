package data_structures.arrays_and_strings;

import data_structures.AbstractDataType;

import java.util.Arrays;

/**
 * The arrayList doubles in size when capacity is reached.
 * The default capacity of an ArrayList is 10 in Java
 * If an element in the middle of the arraylist is moved,
 *    all the elements after it are shifted forward one index
 */
public class ArrayList<T> extends AbstractDataType<T> {
  private final int RESIZE_FACTOR = 2;
  private final int DEFAULT_SIZE = 10;

  private Object _arr[];
  private int _numItems;

  public ArrayList() {
    _arr = new Object[DEFAULT_SIZE];
    Arrays.fill(_arr, null);
    _numItems = 0;
  }

  public ArrayList(int size) {
    _arr = new Object[size];
    Arrays.fill(_arr, null);
    _numItems = 0;
  }

  public ArrayList(T[] arr) {
    _arr = arr.clone();
    _numItems = arr.length;
  }

  @Override
  public void insert(T item) {
    if (shouldResize()) {resize();}
    _arr[_numItems] = item;
    ++_numItems;
  }

  @Override
  public void remove(T toRemove) {
    for (int i = 0; i < _numItems; ++i) {
      Object item = _arr[i];
      if (item == toRemove) {
        if (i + 1 < _arr.length) {
          System.arraycopy(_arr, i + 1, _arr, i, _numItems - i - 1);
          _arr[_numItems - 1] = null;
        } else {
          _arr[_arr.length - 1] = null;
        }
        --_numItems;
        return;
      }
    }
  }

  @Override
  public <T, V> V search(T key) {
    return (V) _search(key);
  }

  private <T> Integer _search(T key) {
    for (int i = 0; i < _numItems; ++i) {
      if (_arr[i] == key) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public boolean isEmpty() {
    return _numItems == 0;
  }

  private boolean shouldResize() { return _numItems == _arr.length; }

  private void resize() {
    Object newArr[] = new Object[_arr.length * RESIZE_FACTOR];
    System.arraycopy(_arr, 0, newArr, 0, _arr.length);
    this._arr = newArr;
  }
}
