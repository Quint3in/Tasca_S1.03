package org.example;

import java.util.Comparator;

public final class PersonComparators {
    private PersonComparators(){}

    public static final Comparator<Person> BY_NAME_ASC =
            Comparator.comparing(Person::getName, String.CASE_INSENSITIVE_ORDER);
    public static final Comparator<Person> BY_NAME_DESC =
            BY_NAME_ASC.reversed();
    public static final Comparator<Person> BY_SURNAME_ASC =
            Comparator.comparing(Person::getSurname, String.CASE_INSENSITIVE_ORDER);
    public static final Comparator<Person> BY_SURNAME_DESC =
            BY_SURNAME_ASC.reversed();
    public static final Comparator<Person> BY_DNI_ASC =
            Comparator.comparingInt(p -> Integer.parseInt(p.getDNI().substring(0, 8)));
    public static final Comparator<Person> BY_DNI_DESC =
            BY_DNI_ASC.reversed();
}
