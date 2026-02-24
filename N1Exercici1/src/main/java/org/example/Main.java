package org.example;

import java.util.*;

public class Main {
    static void main() {
        List<Month> months = new ArrayList<>();

        months.add(new Month("January"));
        months.add(new Month("February"));
        months.add(new Month("March"));
        months.add(new Month("April"));
        months.add(new Month("May"));
        months.add(new Month("June"));
        months.add(new Month("July"));
        //months.add(new Month("August"));
        months.add(new Month("September"));
        months.add(new Month("October"));
        months.add(new Month("November"));
        months.add(new Month("December"));

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
    }
}
