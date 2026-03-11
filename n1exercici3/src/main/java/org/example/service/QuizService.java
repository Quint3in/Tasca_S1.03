package org.example.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.example.utils.ConsoleInput;
import org.example.utils.RandomPicker;

public class QuizService {
    private final Map<String, String> countries;
    private final int questionCount;

    public QuizService(Map<String, String> countries, int questionCount) {
        this.countries = countries;
        this.questionCount = questionCount;
    }

    public int run() {
        List<Entry<String, String>> randomQuestions =
                RandomPicker.pickRandomEntries(countries, questionCount);

        int score = 0;
        for (Entry<String, String> entry : randomQuestions) {
            if (askQuestion(entry)) {
                score++;
            }
            ConsoleInput.pressEnterToContinue();
        }
        return score;
    }

    private boolean askQuestion(Entry<String, String> entry) {
        String question = "Capital de " + formatName(entry.getKey()) + ": ";
        String answer = ConsoleInput.readNonEmptyString(question);

        String expected = normalize(entry.getValue());
        if (normalize(answer).equalsIgnoreCase(expected)) {
            System.out.println("Correcte!");
            return true;
        }

        System.out.println("Incorrecte!");
        return false;
    }

    private String formatName(String value) {
        return value.replace("_", " ");
    }

    private String normalize(String value) {
        return value.trim().replace("_", " ");
    }
}
