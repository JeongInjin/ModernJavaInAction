package com.me.injin.modernjavainaction.ch03.mjia;

import lombok.Getter;

public class ConstructorReferenceExample {
    public class Main {
        public static void main(String[] args) {
            PersonFactory<Person> personFactory = Person::new;
            Person person = personFactory.create("John Doe", 30);

            System.out.println(person.getName());
            System.out.println(person.getAge());
        }
    }
}

@Getter
class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

interface PersonFactory<P extends Person> {
    P create(String name, int age);
}
