package mycompany.selenideintro;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;

public class TodoMvcTest {

    @Test
    void todoCompletion() {
        Configuration.browser = "firefox";
        open("https://todomvc.com/examples/emberjs/");
        $("#new-todo").append("a").pressEnter();
        $("#new-todo").append("b").pressEnter();
        $("#new-todo").append("c").pressEnter();
        $$("#todo-list>li").shouldHave(exactTexts("a", "b", "c"));

        $("#todo-list>li:nth-of-type(2) .toggle").click();

        $$("#todo-list>li.completed").shouldHave(exactTexts("b"));
        $$("#todo-list>li:not(.completed)").shouldHave(exactTexts("a", "c"));
    }
}