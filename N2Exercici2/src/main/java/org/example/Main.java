package org.example;

import java.util.Comparator;
import java.util.HashSet;

public class Main {
    static void main() {
        HashSet<Restaurant> restaurants = new HashSet<>();

        restaurants.add(new Restaurant("B",10));
        restaurants.add(new Restaurant("A",5));
        restaurants.add(new Restaurant("B",1));
        restaurants.add(new Restaurant("C",2));
        restaurants.add(new Restaurant("A",10));
        restaurants.forEach(System.out::println);

        Comparator<Restaurant> byNameThenScore =
                Comparator.comparing(Restaurant::getName)
                        .thenComparingInt(Restaurant::getScore);

        restaurants.stream().sorted(byNameThenScore).forEach(System.out::println);
    }
}
