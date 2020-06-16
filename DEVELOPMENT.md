Notes on how and why I organized the files and designed the classes/interfaces the way that they are.

A brief note on some conventions that I use: 
- add `_` before the name of private instance variables or helper functions
  - ex: `String _key`

- [AbstractDataType Class](#abstractdatatype-class)
    - [Encapsulation and Abstraction](#encapsulation-and-abstraction)
    - [General Functions of an ADT](#general-functions-of-an-abstract-data-type)
    - [Java Generics](#java-generics)
    - [Interface](#interface)
      - [Java Generic Interface](#java-generic-interface)
- [HashFunction Class](#hashfunction-class)
    - [Callable and Runnable in Java](#callable-and-runnable-in-java)
      - [Runnable](#runnable)
      - [Callable](#callable)
    - [Functional Interfaces](#functional-interfaces)

# General functions of an abstract data type

- create data type
- insert data to data type
- get/access/search for data from data type
- remove/delete data from data type
- check if data type is empty

# AbstractDataType Class

I wanted to develop an abstracted wrapper for all of the AbstractDataTypes that I would be writing. 
The wrapper would only make the [above mentioned](#General-functions-of-an-abstract-data-type)
 functions available to the user, thus providing a layer of [encapsulation and abstraction](#encapsulation-and-abstraction).
 I considered using a [generic interface](#java-generic-interface) to do this; however, the inability to add
 custom constructors to interfaces made me use an abstract class to create AbstractDataType.

In addition, the `search` method of each ADT would return a different type than than
the type of the data stored in the data strucutre itself, so I chose to use a [generic method](#generic-methods)
to deal with this.
 
## Encapsulation and Abstraction

- Encapsulation and abstraction are fundamental concepts of OOP.
  - the others being inheritance and polymorphism
- What is encapsulation?
  - wrapping the data and the methods handling the data as a single unit
    - this allows the data to be hidden from other classes - 'data hiding'
    - this allows only necessary functions to be exposed ot the public - 'abstraction'
  

## Java Generics

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

## Interface

- Interfaces are essentially a completely abstract class.

### Java Generic Interface

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

## Generic Methods

- you can also define generic methods

```
public <T>T someMethod(){}
```

# HashFunction Class

Another issue that I ran into when developing the HashTable was the Hash Function.
The hash function would be completely different depending on the type of the key.
  - For example, the hash function for the pair <String key, String value> is not the same as for the pair <int key, int value>

However, the hash function is a key component of the HashTable, and the HashTable must
have access to the hash function. To solve this problem I explored different Java concepts, including 
[callable and runnable interfaces](#callable-and-runnable-in-java) and [functional interfaces](#functional-interfaces), 
before finally settling on the use of an [abstract class](#abstract-class).

Initially, in exploring [callable and runnable interfaces](#callable-and-runnable-in-java), I was attempting to
emulate the use of callbacks in multi-threaded components. However, I realized that using callbacks did not achieve
what I intended. I didn't want to execute the function at a later time. Rather, I wanted to pass in a function as 
a parameter to save as an instance variable or to use immediately.

I also considered the use of an [abstract class](#abstract-class); however, I realized that creating an abstract
class that contained one abstract method would be equivalent, in my use case, to using a [functional interface](#functional-interfaces).
Thus I created HashFunction as a [functional interface](#functional-interfaces).

Java has a built in hash function for objects called .hashCode(), it returns an integer.
This will be the default hash function for Objects in my implementation.

## Callable and Runnable in Java

- both are interfaces that represent a task that can be executed by multiple threads
- These can be used as callbacks.

### Runnable

- a functional interface with a single `run()` method
  - `run()` doesn't accept parameters and does not return any values
  - mostly used to log incoming events
 
 ```
public interface Runnable {
    public void run();
}
```

- after being logged, the task can be launched from the `ExecutorService`

### Callable

- generic interface w/ a single `call()` method which returns a generic value V

```
public interface Callable<V> {
    V call() throws Exception;
}
```

## Functional Interfaces

- in java, an Interface w/ a single abstract method (SAM) is known as a functional interface

``` 
public interface MyInterface {
    String doSomething(int param1, int param2);
}

// implementing this interface in a class
class MyClass {
    public MyInterface myInterface = (p1, p2) => { return p1 + p2; }
}
```

- this essentially allows you to pass functions as a parameter to another function

## Abstract Class

- Abstract classes are similar to interfaces except they can contain default method implementation
  - Abstract classes can have abstract methods which have no implementation
    - These abstract methods must be denoted with the `abstract` keyword

``` 
public abstract class Person {
    protected String name_;

    public Person(String name) {
        name_ = name;
    }

   public abstract void work();
}
```