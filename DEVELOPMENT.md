Notes on how and why I organized the files and designed the classes/interfaces the way that they are.

- [General Functions of an ADT](#general-functions-of-an-abstract-data-type)
- [Java Generics](#java-generics)
- [Interface](#interface)
  - [Java Generic Interface](#java-generic-interface)

# General functions of an abstract data type

- create data type
- add data to data type
- get/access data from data type
- remove data from data type
- check if data type is empty

# Java Generics

- java generics allow for type-safety, they are somewhat equivalent to Templates in C++
  - you can have a 'generic' type instead of using an Object
    - using an Object excludes primitives (such as `int`) and also requires typecasting in Java

```
public class GenericClass<T> {
    private T someVariable;
    public void set(T setTo) { someVariable = setTo; }
    public T get() { return this.someVariable; }
}

public static void main(String args[]) {
    // creating an instance of the GenericClass
    GenericClass<String> instance = new GenericClass<>();
    instance.set("Hello");
    System.println(instance.get()); // prints "Hello"
}
```

# Interface

- Interfaces are essentially a completely abstract class

## Java Generic Interface

```
public interface GenericInterface<T> {
    public int someMethod(T thing);
}

- In this case the `<T>` denotes the type
  - Only generic classes can implement generic interfaces
  - The class implementing the generic interface must have at least the same number of parameters and the same type of parameter
  - Then implementing this interface it would look like

```

public class GenericClass<T> implements GenericInterface<T> {
  
 @Override
public int someMethod(T thing) {
// do something
}
}

```

```
