package org.example.repository;

import org.example.model.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonRepository {
    private final Set<Person> people = new HashSet<>();

    public PersonRepository(Set<Person> initialPeople) {
        if (initialPeople != null) {
            people.addAll(initialPeople);
        }
    }

    public boolean add(Person person) {
        return people.add(person);
    }

    public List<Person> findAll() {
        return new ArrayList<>(people);
    }
}
