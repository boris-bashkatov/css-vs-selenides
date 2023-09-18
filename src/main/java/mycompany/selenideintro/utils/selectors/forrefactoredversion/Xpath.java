package mycompany.selenideintro.utils.selectors.forrefactoredversion;

public class Xpath {
    public static String cssClass(String name) {
        return "contains(concat(' ', normalize-space(@class), ' '), ' " + name + " ')";
    }

    public static String filterBy(String predicate) {
        return "[" + predicate + "]";
    }

    public static String not(String predicate) {
        return "[not(" + predicate + ")]";
    }


    public static class FilterBy {
        public static String hasCssClass(String name) {
            return filterBy(cssClass(name));
        }

        public static String noCssClass(String name) {
            return not(cssClass(name));
        }
    }
}
