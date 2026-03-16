package org.example;

import java.nio.file.Path;
import java.util.Map;

import org.example.service.QuizService;
import org.example.utils.ConsoleInput;
import org.example.utils.MapFileLoader;

public class Main {
    private static final Path INPUT = Path.of("N1Exercici3/countries.txt");
    private static final Path OUTPUT = Path.of("N1Exercici3/clasificacio.txt");

    public static void main(String[] args) {
        Map<String, String> countries = MapFileLoader.loadCountries(INPUT);

        String name = ConsoleInput.readNonEmptyString("Escriu el teu nom: ");

        QuizService quiz = new QuizService(countries, 10);
        int score = quiz.run();

        MapFileLoader.writeLeaderboard(OUTPUT, name, score);
        System.out.println("Afegit a la classificacio -> " + OUTPUT);
    }
}
