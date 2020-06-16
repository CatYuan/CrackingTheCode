import data_structures.arrays_and_strings.hash_table.DataItem;
import data_structures.arrays_and_strings.hash_table.HashTable;
import data_structures.arrays_and_strings.hash_table.ObjectHashFunction;

public class Main {
  public static void main(String[] args) {
    ObjectHashFunction<String> hash = new ObjectHashFunction<>();
    HashTable<DataItem<String, String>> table = new HashTable<>(hash);

    DataItem<String, String> data = new DataItem("key", "value");
    table.insert(data);
    String value = table.search("key");
    System.out.println(value);
  }
}
