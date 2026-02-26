package org.example;

import java.nio.file.Path;
import java.util.*;

import static org.example.utils.ConsoleInput.pressEnterToContinue;
import static org.example.utils.ConsoleInput.readNonEmptyString;
import static org.example.utils.MapFileLoader.loadCountries;
import static org.example.utils.MapFileLoader.writeLeaderboard;

public class Main {
    static void main() {
        final String MODULE_ROUTE = "N1Exercici3/";
        final String FILE_INPUT = MODULE_ROUTE + "countries.txt";
        final String FILE_OUTPUT = MODULE_ROUTE + "clasificacio.txt";
        Map<String,String> countries = loadCountries(Path.of(FILE_INPUT));

        String name = readNonEmptyString("Escriu el teu nom: ");

        List<Map.Entry<String,String>> random10 = pickRandomEntries(countries,10);

        int puntuacio = 0;
        for (Map.Entry<String,String> entry : random10) {
            String answer = readNonEmptyString("Capital de " + entry.getKey().replace("_"," ") + ": ");
            if (answer.equals(entry.getValue().replace("_"," "))) {
                puntuacio++;
                System.out.println("Correcte!");
            } else {
                System.out.println("Incorrecte!");
            }
            pressEnterToContinue();
        }

        writeLeaderboard(Path.of(FILE_OUTPUT),name,puntuacio);
        System.out.println("Afegit a la classificació -> " + FILE_OUTPUT);

    }


    public static <K, V> List<Map.Entry<K, V>> pickRandomEntries(Map<K, V> map, int n) {
        List<Map.Entry<K, V>> entries = new ArrayList<>(map.entrySet());
        Collections.shuffle(entries);
        return entries.subList(0, Math.min(n, entries.size()));
    }

}
