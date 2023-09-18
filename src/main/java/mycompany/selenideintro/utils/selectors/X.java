package mycompany.selenideintro.utils.selectors;

public class X {
    private String locator;

    public X() {
        this.locator = "//";
    }

    public X all() {
        this.locator += "*";
        return this;
    }

    public X descendant() {
        this.locator += "//*";
        return this;
    }

    public String x() {
        return this.locator;
    }

    public X child(String element) {
        this.locator += "/" + element;
        return this;
    }

    public X by(String name) {
        this.locator += "[" + name + "]";
        return this;
    }

    public static String cssClass(String name) {
        return "contains(concat(' ', normalize-space(@class), ' '), ' " + name + " ')";
    }

    public static String not(String predicate) {
        return "not(" + predicate + ")";
    }
    public static class Its {
        public static String id(String name) {
            return "@id=\"" + name + "\"";
        }

        public static String descendantWithText(String text) {
            return ".//text()='" + text + "'";
        }

        public static String CssClass(String name) {
            return cssClass(name);
        }

        public static String noCssClass(String name) {
            return not(cssClass(name));
        }

    }
}
