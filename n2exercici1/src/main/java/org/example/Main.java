package org.example;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Restaurant> restaurants = new HashSet<>();

        System.out.println(restaurants.add(new Restaurant("A1",0)));
        System.out.println(restaurants.add(new Restaurant("A1",0)));
        System.out.println(restaurants.add(new Restaurant("A1",5)));
        restaurants.forEach(System.out::println);
    }
}
