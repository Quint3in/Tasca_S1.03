package org.example.utils;

public class ValidationUtils {
    public static boolean isValidDni(String dni) {
        if (dni == null) return false;

        dni = dni.trim().toUpperCase();
        if (!dni.matches("\\d{8}[A-Z]")) return false;

        int number = Integer.parseInt(dni.substring(0, 8));
        char letter = dni.charAt(8);

        String table = "TRWAGMYFPDXBNJZSQVHLCKE";
        char expected = table.charAt(number % 23);

        return letter == expected;
    }
}
