package org.example;

public final class Parser {
    public static boolean isInteger(String str) {
        return str.matches("-?\\d+");
    }

    public static boolean isFloat(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
