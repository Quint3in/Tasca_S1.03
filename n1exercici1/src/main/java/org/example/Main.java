package org.example;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    static void main() {
        List<Month> months = List.of(
            new Month("January"),
            new Month("February"),
            new Month("March"),
            new Month("April"),
            new Month("May"),
            new Month("June"),
            new Month("July"),
            new Month("September"),
            new Month("October"),
            new Month("November"),
            new Month("December")
        );

        Month august = new Month("August");
        months.add(7,august);

        months.forEach(System.out::println);

        Set<Month> monthsSet = new HashSet<>(months);
        System.out.println("-----HASHSET---------");

        System.out.println("Agost agregat de nou -> "+monthsSet.add(august));

        Iterator<Month> iterator = monthsSet.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("-----BUCLE FOR---------");
        for (Month month : months) {
            System.out.println(month);
        }
    }
}
