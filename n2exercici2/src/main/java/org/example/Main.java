package org.example;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Restaurant> restaurants = new HashSet<>();

        restaurants.add(new Restaurant("B",10));
        restaurants.add(new Restaurant("A",5));
        restaurants.add(new Restaurant("B",1));
        restaurants.add(new Restaurant("C",2));
        restaurants.add(new Restaurant("A",10));
        restaurants.forEach(System.out::println);

        restaurants.stream().sorted(Restaurant.BY_NAME_THEN_SCORE).forEach(System.out::println);
    }
}
