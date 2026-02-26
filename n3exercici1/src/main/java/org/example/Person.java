package org.example;

import java.util.Objects;

public class Person {
    private String name;
    private String surname;
    private String DNI;

    public Person(String name, String surname, String DNI) {
        this.name = name;
        this.surname = surname;
        this.DNI = DNI;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDNI() {
        return DNI;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(DNI, person.DNI);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(DNI);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nom='" + name + '\'' +
                ", cognom='" + surname + '\'' +
                ", DNI='" + DNI + '\'' +
                '}';
    }
}
