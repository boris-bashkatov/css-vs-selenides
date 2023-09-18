package mycompany.selenideintro.xpathversions.dsl;

import com.codeborne.selenide.Configuration;
import mycompany.selenideintro.utils.selectors.X;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;
import static mycompany.selenideintro.utils.selectors.X.Its;


public class TodoMvcTest {


    @Test
    void toDoCompletion() {

        Configuration.browser = "firefox";
        Configuration.holdBrowserOpen = true;
        open("https://todomvc.com/examples/emberjs/");
        X x = new X();
        $x(x.all().by(Its.id("new-todo")).x()).append("a").pressEnter();
        $x(x.x()).append("b").pressEnter();
        $x(x.x()).append("c").pressEnter();
        x = new X();
        $$x(x.all().by(Its.id("todo-list")).child("li").x()).shouldHave(exactTexts("a", "b", "c"));

        x = new X();
        $x(x.all().by(Its.id("todo-list")).child("li").by(Its.descendantWithText("b")).descendant().by(Its.CssClass("toggle")).x()).click();

        x = new X();
        $$x(x.all().by(Its.id("todo-list")).child("li").by(Its.noCssClass("completed")).x()).shouldHave(exactTexts("a", "c"));
        x = new X();
        $$x(x.all().by(Its.id("todo-list")).child("li").by(Its.CssClass("completed")).x()).shouldHave(exactTexts("b"));

    }
}
