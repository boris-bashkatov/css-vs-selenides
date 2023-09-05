package mycompany.selenideintro;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.CollectionCondition.*;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;



public class TodoMvcTest {

    @Test
    void todoCompletion() {
        Configuration.browser = "firefox";
        open("https://todomvc.com/examples/emberjs/");
        $("#new-todo").append("a").pressEnter();
        $("#new-todo").append("b").pressEnter();
        $("#new-todo").append("c").pressEnter();
        $$("#todo-list>li").shouldHave(exactTexts("a","b","c"));

        $("#todo-list>li:nth-of-type(2) .toggle").click();

        $$("#todo-list>li.completed").shouldHave(exactTexts("b"));
        $$("#todo-list>li:not(.completed)").shouldHave(exactTexts("a","c"));
    }
}