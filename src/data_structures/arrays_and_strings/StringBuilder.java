package data_structures.arrays_and_strings;

import data_structures.AbstractDataType;

import java.util.ArrayList;

public class StringBuilder extends AbstractDataType<String> {
  private ArrayList<String> _list;

  public StringBuilder() {
    _list = new ArrayList<>();
  }

  @Override
  public void insert(String item) {
    _list.add(item);
  }

  @Override
  public void remove(String item) {
    _list.remove(item);
  }

  @Override
  public <String, V>V search(String key) {
    return (V) Integer.valueOf(_list.indexOf(key));
  }

  @Override
  public boolean isEmpty() {
    return _list.isEmpty();
  }
}
