package mycompany.selenideintro.selectors.dsl;


public class X {
    private final String selector;

    public X(String selector) {
        this.selector = selector;
    }

    public static X any() {
        return new X("//*");
    }

    public String x() {
        return this.selector;
    }

    public X descendant(String element) {
        return new X(this.selector + "//" + element);
    }

    public X descendant() {
        return new X(descendant("*").selector);
    }

    public X child(String element) {
        return new X(this.selector + "/" + element);
    }

    public X child() {
        return new X(child("*").selector);
    }

    public X by(String predicate) {
        return new X(this.selector + "[" + predicate + "]");
    }

    public X byNot(String predicate) {
        return new X(by(Its.not(predicate)).selector);
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

        public static String not(String predicate) {
            return "not(" + predicate + ")";
        }
    }
}
