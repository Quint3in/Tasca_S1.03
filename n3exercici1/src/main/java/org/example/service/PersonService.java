package org.example.service;

import org.example.model.Person;
import org.example.model.PersonComparators;
import org.example.repository.PersonRepository;
import org.example.utils.ValidationUtils;

import java.util.Comparator;
import java.util.List;

public class PersonService {
    public enum AddPersonResult {
        SUCCESS,
        INVALID_DNI,
        DUPLICATE_DNI
    }

    public enum SortType {
        NAME_ASC,
        NAME_DESC,
        SURNAME_ASC,
        SURNAME_DESC,
        DNI_ASC,
        DNI_DESC
    }

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public AddPersonResult addPerson(String name, String surname, String dni) {
        if (!ValidationUtils.isValidDni(dni)) {
            return AddPersonResult.INVALID_DNI;
        }

        boolean added = repository.add(new Person(name, surname, dni.trim().toUpperCase()));
        return added ? AddPersonResult.SUCCESS : AddPersonResult.DUPLICATE_DNI;
    }

    public List<Person> getPeopleSorted(SortType sortType) {
        List<Person> people = repository.findAll();
        people.sort(toComparator(sortType));
        return people;
    }

    private Comparator<Person> toComparator(SortType sortType) {
        return switch (sortType) {
            case NAME_ASC -> PersonComparators.BY_NAME_ASC;
            case NAME_DESC -> PersonComparators.BY_NAME_DESC;
            case SURNAME_ASC -> PersonComparators.BY_SURNAME_ASC;
            case SURNAME_DESC -> PersonComparators.BY_SURNAME_DESC;
            case DNI_ASC -> PersonComparators.BY_DNI_ASC;
            case DNI_DESC -> PersonComparators.BY_DNI_DESC;
        };
    }
}
