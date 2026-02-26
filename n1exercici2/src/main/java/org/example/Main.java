package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    static void main() {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(5);
        numbers.add(10);
        numbers.add(40);

        List<Integer> reversedNumbers = new ArrayList<>();

        reversedNumbers.add(40);
        reversedNumbers.add(10);
        reversedNumbers.add(5);

        ListIterator<Integer> it = numbers.listIterator();
        while (it.hasNext()) {
            reversedNumbers.add(it.next());
        }

        numbers.forEach(System.out::println);
        reversedNumbers.forEach(System.out::println);
    }
}
