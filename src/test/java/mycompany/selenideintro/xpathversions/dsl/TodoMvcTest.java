package mycompany.selenideintro.xpathversions.dsl;

import com.codeborne.selenide.Configuration;
import mycompany.selenideintro.selectors.dsl.X;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;
import static mycompany.selenideintro.selectors.dsl.X.Its;

public class TodoMvcTest {
    @Test
    void toDoCompletion() {
        Configuration.browser = "firefox";
        open("https://todomvc.com/examples/emberjs/");
        $x(X.any().by(Its.id("new-todo")).x()).append("a").pressEnter();
        $x(X.any().by(Its.id("new-todo")).x()).append("b").pressEnter();
        $x(X.any().by(Its.id("new-todo")).x()).append("c").pressEnter();
        $$x(X.any().by(Its.id("todo-list")).child("li").x())
                .shouldHave(exactTexts("a", "b", "c"));

        $x(X.any().by(Its.id("todo-list")).child("li")
                .by(Its.descendantText("b"))
                .descendant().by(Its.cssClass("toggle")).x())
                .click();

        $$x(X.any().by(Its.id("todo-list")).child("li")
                .byNot(Its.cssClass("completed")).x())
                .shouldHave(exactTexts("a", "c"));
        $$x(X.any().by(Its.id("todo-list")).child("li")
                .by(Its.cssClass("completed")).x())
                .shouldHave(exactTexts("b"));
    }
}
