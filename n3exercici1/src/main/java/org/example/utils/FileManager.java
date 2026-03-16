package org.example.utils;

import org.example.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;

import static org.example.utils.ValidationUtils.isValidDni;


public class FileManager {

    public static HashSet<Person> loadPersonCSVtoHashSet(Path p) throws IOException {
        HashSet<Person> people = new HashSet<>();
        try(BufferedReader br = Files.newBufferedReader(p)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] parts = line.split(",");
                if (parts.length != 3 || !isValidDni(parts[2].trim())) {
                    System.out.println("Invalid DNI - " + parts[2].trim());
                    continue;
                }
                people.add(new Person(parts[0].trim(), parts[1].trim(), parts[2].trim()));
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Error al cargar el CSV desde: " + p.toAbsolutePath(), e);
        }
        return people;
    }

}
