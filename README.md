Below is a compilation of my notes from Cracking the Coding Interview

- [Arrays and Strings](#arrays-and-strings)
- [ArrayList and Resizable Arrays](#arraylist-and-resizable-arrays)
- [StringBuilder](#stringbuilder)

# Arrays and Strings

## Hash Tables

- maps keys to values for highly efficient lookup
- one method of implementing a hash table - separate chaining with linked list
  1. compute the key's hash code - two keys may have the same hash code
  2. Map the hash code to an index in the array - again two keys may have the same hash code
  3. At the index, there is a linked list of keys and values
- hash table can also be implemented w/ balanced binary search tree

## ArrayList and Resizable Arrays

- these structures automatically resize as you append items, while still providing O(1) access
- implementation, the array resizes to double its size once it is full

## StringBuilder

- stringBuilder creates a resizable array of all the strings, copying them back to a string only when necessary
