package org.example;

import java.nio.file.Path;
import java.util.HashSet;

import static org.example.utils.FileManager.loadPersonCSVtoHashSet;

public class Main {
    static void main() {
        final String MODULE = "N3Exercici1/";
        final String INPUT_FILE = MODULE + "persones.csv";

        HashSet<Person> people = loadPersonCSVtoHashSet(Path.of(INPUT_FILE));

        ConsoleUI ui = new ConsoleUI(people);
        ui.start();
    }
}
