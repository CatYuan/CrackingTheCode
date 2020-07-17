package data_structures.linked_list;

import data_structures.AbstractDataType;

class Node<T> {
  public T data;
  public Node<T> next;

  Node() {
    data = null;
    next = null;
  }

  Node(T d) {
    data = d;
    next = null;
  }
}

public class SinglyLinkedList<T> extends AbstractDataType<T> {
  private Node<T> _head;

  public SinglyLinkedList(T data) {
    _head = new Node<T>(data);
  }

  public SinglyLinkedList() {
    _head = null;
  }

  @Override
  public void insert(T item) {
    if (_head == null) {
      _head = new Node(item);
    }
    _insert(item, _head);
  }

  private void _insert(T item, Node curr) {
    if (curr.next == null) {
      curr.next = new Node(item);
      return;
    }
    _insert(item, curr.next);
  }

  @Override
  public void remove(T item) {
    if (_head == null) {
      return;
    }
    Node curr = _head;
    Node prev = null;
    while (curr != null) {
      if (curr.data == item) {
        if (prev == null) {
          _head = curr.next;
          return;
        }
        prev.next = curr.next;
        return;
      }
      prev = curr;
      curr = curr.next;
    }
  }

  @Override
  public <T, Boolean> Boolean search(T key) {
    return (Boolean) _search(key, _head);
  }

  private <T> Boolean _search(T item, Node curr) {
    if (curr == null) {
      return Boolean.FALSE;
    }
    if (curr.data == item) {
      return Boolean.TRUE;
    }
    _search(item, curr.next);
  }

  @Override
  public boolean isEmpty() {
    return _head == null;
  }
}
