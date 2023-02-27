package com.me.injin.modernjavainaction.example.me.stream;

class Parent {
    int a = 10;
}

class Child extends Parent {

    void display() {

        int a = 20;
        System.out.println(a); //20
        System.out.println(this.a); //10
        System.out.println(super.a); //10

    }
}

public class Main {

    public static void main(String[] args) {

        Child ch = new Child();

        ch.display();

    }
}

