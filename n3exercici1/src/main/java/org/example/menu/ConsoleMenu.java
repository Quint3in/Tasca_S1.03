package org.example.menu;

import org.example.model.Person;
import org.example.service.PersonService;

import java.util.List;

import static org.example.utils.ConsoleInput.pressEnterToContinue;
import static org.example.utils.ConsoleInput.readInt;
import static org.example.utils.ConsoleInput.readNonEmptyString;

public class ConsoleMenu {
    private final PersonService personService;
    private boolean running;

    public ConsoleMenu(PersonService personService) {
        this.personService = personService;
    }

    public void start() {
        running = true;
        while (running) {
            MenuOption option = readMenuOption();
            handleOption(option);
        }
    }

    private MenuOption readMenuOption() {
        while (true) {
            showMenu();
            int code = readInt("Escull una opcio (0-7): ");
            MenuOption option = MenuOption.fromCode(code);
            if (option != null) {
                return option;
            }
            System.out.println("Opcio no valida.");
        }
    }

    private void showMenu() {
        for (MenuOption option : MenuOption.values()) {
            System.out.println(option.getCode() + ". " + option.getLabel());
        }
    }

    private void handleOption(MenuOption option) {
        switch (option) {
            case ADD_PERSON -> {
                addPerson();
                pressEnterToContinue();
            }
            case SHOW_NAME_ASC, SHOW_NAME_DESC, SHOW_SURNAME_ASC, SHOW_SURNAME_DESC, SHOW_DNI_ASC, SHOW_DNI_DESC -> {
                showPeople(personService.getPeopleSorted(option.getSortType()));
                pressEnterToContinue();
            }
            case EXIT -> stop();
        }
    }

    private void addPerson() {
        String name = readNonEmptyString("Introdueix el nom: ");
        String surname = readNonEmptyString("Introdueix el cognom: ");
        String dni = readNonEmptyString("Introdueix el DNI: ");

        PersonService.AddPersonResult result = personService.addPerson(name, surname, dni);
        while (result == PersonService.AddPersonResult.INVALID_DNI) {
            System.out.println("DNI invalid.");
            dni = readNonEmptyString("Introdueix el DNI: ");
            result = personService.addPerson(name, surname, dni);
        }

        if (result == PersonService.AddPersonResult.SUCCESS) {
            System.out.println("Persona afegida!");
        } else {
            System.out.println("DNI ja existent.");
        }
    }

    private void showPeople(List<Person> people) {
        System.out.printf("%-15s %-20s %-10s%n", "___Nom___", "____Cognoms____", "___NIF___");
        for (Person person : people) {
            System.out.printf("%-15s %-20s %-10s%n", person.getName(), person.getSurname(), person.getDni());
        }
    }

    private void stop() {
        running = false;
        System.out.println("Fins aviat!");
    }
}
