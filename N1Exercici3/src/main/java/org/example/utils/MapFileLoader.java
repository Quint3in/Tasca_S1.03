package org.example.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

public class MapFileLoader {

    public static Map<String,String> loadCountries(Path p) {
        Map<String,String> countries = new HashMap<>();
        try (BufferedReader br = Files.newBufferedReader(p)) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split(" ");
                    if (parts.length == 2 && !parts[0].isEmpty()) {
                        countries.put(parts[0], parts[1]);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return countries;
    }
    public static boolean writeLeaderboard(Path p, String name, int score) {
        boolean exists = Files.exists(p);
        try (BufferedWriter bw = Files.newBufferedWriter(
                p,
                StandardOpenOption.APPEND
        )) {
            if (!exists) {bw.write("# Nom:Puntuació");}
            bw.newLine();
            bw.write(name + ":" + score);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
