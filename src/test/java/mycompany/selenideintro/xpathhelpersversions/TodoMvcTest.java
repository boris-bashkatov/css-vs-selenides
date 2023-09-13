package mycompany.selenideintro.xpathhelpersversions;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;
import static utils.XpathHelpers.normalizeClassName;

public class TodoMvcTest {


    @Test
    void toDoCompletion() {
        Configuration.browser = "firefox";
        open("https://todomvc.com/examples/emberjs/");
        $x("//*[@id='new-todo']").append("a").pressEnter();
        $x("//*[@id='new-todo']").append("b").pressEnter();
        $x("//*[@id='new-todo']").append("c").pressEnter();
        $$x("//*[@id='todo-list']//li").shouldHave(exactTexts("a", "b", "c"));

        $x("//*[@id='todo-list']//li[.//text()[normalize-space() = 'b']]//*[" + normalizeClassName("toggle") + "]")
                .click();

        $$x("//*[@id='todo-list']//li[not(" + normalizeClassName("completed") + ")]")
                .shouldHave(exactTexts("a", "c"));
        $$x("//*[@id='todo-list']//li[" + normalizeClassName("completed") + "]")
                .shouldHave(exactTexts("b"));

    }
}
