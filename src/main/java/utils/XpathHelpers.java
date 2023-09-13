package utils;

public class XpathHelpers {
    public static String normalizeClassName(String input) {
        String output = "contains(concat(' ', normalize-space(@class), ' '), ' " + input + " ')";
        return output;
    }
}
