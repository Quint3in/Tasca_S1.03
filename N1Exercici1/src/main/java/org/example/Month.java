package org.example;

public class Month {
    private final String name;

    public Month(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Month{" +
                "name='" + name + '\'' +
                '}';
    }
}
