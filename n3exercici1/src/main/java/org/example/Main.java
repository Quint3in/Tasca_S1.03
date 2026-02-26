package org.example;

import org.example.menu.ConsoleMenu;
import org.example.model.Person;
import org.example.repository.PersonRepository;
import org.example.service.PersonService;
import org.example.utils.FileManager;

import java.nio.file.Path;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        final String MODULE = "n3exercici1";
        final Path inputFile = Path.of(MODULE, "persones.csv");

        HashSet<Person> people = FileManager.loadPersonCSVtoHashSet(inputFile);

        PersonRepository repository = new PersonRepository(people);
        PersonService service = new PersonService(repository);
        ConsoleMenu menu = new ConsoleMenu(service);
        menu.start();
    }
}
