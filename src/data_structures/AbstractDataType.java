package data_structures;

// A generic interface for data structures
public interface AbstractDataType<T> {

    // inserts an item into the data structure
    public void insert(T item);

    // removes the item from the data structure
    public void remove(T item);

    // searches for an item and returns something that
    // 'points' to the item in the data structure
    public <E>E search(T item);

    // checks if the data structure is empty or not
    public boolean isEmpty();
}
