package com.grace.springbootpractice;

public interface HelloRepository {

    Hello findHello(String name);

    void increaseCount(String name);

    default int count(String name) {
        Hello hello = findHello(name);
        return hello == null ? 0 : hello.getCount();
    }
}
