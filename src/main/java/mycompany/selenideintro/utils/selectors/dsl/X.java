package mycompany.selenideintro.utils.selectors.dsl;

public class X {
    private String locator;

    public X(String locator) {
        this.locator = locator;
    }

    public static X any() {
        return new X("//*");
    }

    public String x() {
        return this.locator;
    }

    public X descendant(String element) {
        this.locator += ("//" + element);
        return this;
    }

    public X descendant() {
        return this.descendant("*");
    }

    public X child(String element) {
        this.locator += "/" + element;
        return this;
    }

    public X child() {
        return this.child("*");
    }

    public X by(String predicate) {
        this.locator += "[" + predicate + "]";
        return this;
    }

    public X byNot(String predicate) {
        this.locator += "[not(" + predicate + ")]";
        return this;
    }

    public static class Its {
        public static String id(String name) {
            return "@id=\"" + name + "\"";
        }

        public static String descendantText(String text) {
            return ".//text()='" + text + "'";
        }

        public static String cssClass(String name) {
            return "contains(concat(' ', normalize-space(@class), ' '), ' " +
                    name + " ')";
        }
    }
}
