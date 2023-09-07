package mycompany.selenideintro;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;

public class TodoMvcXpathTest {


    @Test
    void toDoCompletion() {
        Configuration.browser = "firefox";
        open("https://todomvc.com/examples/emberjs/");
        $x("//*[@id='new-todo']").append("a").pressEnter();
        $x("//*[@id='new-todo']").append("b").pressEnter();
        $x("//*[@id='new-todo']").append("c").pressEnter();
        $$x("//*[@id='todo-list']//li").shouldHave(exactTexts("a", "b", "c"));

        $x("//*[@id='todo-list']//*[text()[normalize-space() = 'b']]/preceding-sibling::*[contains(concat(' ', @class, ' '), ' toggle ')]").click();

        $$x("//*[@id='todo-list']//li[not(contains(@class,'completed'))]").shouldHave(exactTexts("a", "c"));
        $$x("//*[@id='todo-list']//li[(contains(@class,'completed'))]").shouldHave(exactTexts("b"));

    }
}
