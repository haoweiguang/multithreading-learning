package me.light.demo.designpatterns.iteratorpattern;

public interface Menu {
    void add(String name);

    Iterator getIterator();
}
