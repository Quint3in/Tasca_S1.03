package org.example.test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(5,10,40);
        List<Integer> reversedNumbers = new ArrayList<>();

        ListIterator<Integer> it = numbers.listIterator(numbers.size());

        while (it.hasPrevious()) {
            reversedNumbers.add(it.previous());
        }

        numbers.forEach(System.out::println);
        reversedNumbers.forEach(System.out::println);
    }
}
