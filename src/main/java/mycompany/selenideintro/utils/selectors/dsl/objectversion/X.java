package mycompany.selenideintro.utils.selectors.dsl.objectversion;

public class X {
    private final String locator;

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
        return new X(this.locator + "//" + element);
    }

    public X descendant() {

        return new X(this.locator + "//*");
    }

    public X child(String element) {
        return new X(this.locator + "/" + element);
    }

    public X child() {
        return new X(this.locator + "/*");
    }

    public X by(String predicate) {
        return new X(this.locator + "[" + predicate + "]");
    }

    public X byNot(String predicate) {
        return new X(this.locator + "[not(" + predicate + ")]");
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
