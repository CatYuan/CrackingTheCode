Notes on how and why I organized the files and designed the classes/interfaces the way that they are.

A brief note on some conventions that I use: 
- add `_` after the name of private instance variables
  - ex: `String key_`

- [General Functions of an ADT](#general-functions-of-an-abstract-data-type)
- [Java Generics](#java-generics)
- [Interface](#interface)
  - [Java Generic Interface](#java-generic-interface)

# General functions of an abstract data type

- create data type
- insert data to data type
- get/access/search for data from data type
- remove/delete data from data type
- check if data type is empty

# Java Generics

- java generics allow for type-safety, they are somewhat equivalent to Templates in C++
  - you can have a 'generic' type instead of using an Object
    - using an Object requires typecasting in Java
    - HOWEVER, for the purposes of backwards compatibility, Java Generics do not support primitive types

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

- Interfaces are essentially a completely abstract class.
- These are used to create an AbstractDataType interface that all ADTs will implement
  - b/c many different ADTs are implementing it, I use generic interfaces

## Java Generic Interface

```
public interface GenericInterface<T> {
    public int someMethod(T thing);
}
```

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

# Generic Methods

- you can also define generic methods

```
public <T>T someMethod(){}
```

# Callable and Runnable in Java