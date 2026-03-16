package org.example;

import java.util.Comparator;
import java.util.Objects;

public class Restaurant {
    public static final Comparator<Restaurant> BY_NAME_ASC_THEN_SCORE_DESC =
            Comparator.comparing(Restaurant::getName)
                    .thenComparing(Comparator.comparingInt(Restaurant::getScore).reversed());

    private String name;
    private int score;

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Restaurant(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return score == that.score && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "nom: " + name +
                ", puntuació: " + score +
                '}';
    }
}
