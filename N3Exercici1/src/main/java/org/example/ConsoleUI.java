package org.example;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.example.utils.ConsoleInput.*;
import static org.example.utils.ValidationUtils.*;

public class ConsoleUI {
    private final HashSet<Person> people;
    private List<Person> sortedPeople;
    boolean running;

    public ConsoleUI(HashSet<Person> people) {
        this.people = people;
        this.sortedPeople = new ArrayList<>(people);
        running = false;
    }

    public void start() {
        running = true;
        while (running) {
            int option = readMenuOption();
            handleOption(option);
        }
    }

    private void stop() {
        running = false;
        System.out.println("Fins aviat!");
    }

    private void showMenu() {
        System.out.println("""
                1. Introduir persona. \s
                2. Mostrar les persones ordenades per nom (A-Z). \s
                3. Mostrar les persones ordenades per nom (Z-A). \s
                4. Mostrar les persones ordenades per cognoms (A-Z). \s
                5. Mostrar les persones ordenades per cognoms (Z-A). \s
                6. Mostrar les persones ordenades per DNI (1-9). \s
                7. Mostrar les persones ordenades per DNI (9-1). \s
                0. Sortir.""");
    }

    private int readMenuOption() {
        while (true) {
            showMenu();
            int option = readInt("Escull una opció (0-7): ");
            if (option >= 0 && option <= 7) {
                return option;
            }
            System.out.println("Opció no valida.");
        }
    }

    private void handleOption(int option) {
        switch (option) {
            case 1 -> {
                addPerson();
                pressEnterToContinue();
            }
            case 2 -> {
                sortByNameAsc();
                showPeople();
                pressEnterToContinue();
            }
            case 3 -> {
                sortByNameDesc();
                showPeople();
                pressEnterToContinue();
            }
            case 4 -> {
                sortBySurnameAsc();
                showPeople();
                pressEnterToContinue();
            }
            case 5 -> {
                sortBySurnameDesc();
                showPeople();
                pressEnterToContinue();
            }
            case 6 -> {
                sortByDNIAsc();
                showPeople();
                pressEnterToContinue();
            }
            case 7 -> {
                sortByDNIDesc();
                showPeople();
                pressEnterToContinue();
            }
            case 0 -> stop();
            default -> System.out.println("Opció no vàlida.");
        }
    }

    private void sortByDNIDesc() {
        sortedPeople.sort(PersonComparators.BY_DNI_DESC);
    }

    private void sortByDNIAsc() {
        sortedPeople.sort(PersonComparators.BY_DNI_ASC);
    }

    private void sortBySurnameAsc() {
        sortedPeople.sort(PersonComparators.BY_SURNAME_ASC);
    }

    private void sortBySurnameDesc() {
        sortedPeople.sort(PersonComparators.BY_SURNAME_DESC);
    }

    private void sortByNameDesc() {
        sortedPeople.sort(PersonComparators.BY_NAME_DESC);
    }

    private void sortByNameAsc() {
        sortedPeople.sort(PersonComparators.BY_NAME_ASC);
    }

    private void addPerson() {
        String name = readNonEmptyString("Introdueix el nom: ");
        String surname = readNonEmptyString("Introdueix el cognom: ");
        String dni = readNonEmptyString("Introdueix el DNI: ");
        while(!isValidDni(dni)) {
            System.out.println("DNI invalid.");
            dni = readNonEmptyString("Introdueix el DNI: ");
        }
        if(people.add(new Person(name, surname, dni))){
            System.out.println("Persona afegida!");
            sortedPeople = new ArrayList<>(people);
        } else {
            System.out.println("DNI ja existent.");
        }
    }

    private void showPeople() {
        System.out.printf("%-15s %-20s %-10s\n",
                "___Nom___",
                "____Cognoms____",
                "___NIF___");

        for (Person person : sortedPeople) {
            System.out.printf("%-15s %-20s %-10s\n",
                    person.getName(),
                    person.getSurname(),
                    person.getDNI());
        }

    }

}
