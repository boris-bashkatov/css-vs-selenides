package mycompany.selenideintro.xpathversions.refactoredwithhelpers;

import com.codeborne.selenide.Configuration;
import mycompany.selenideintro.utils.selectors.forrefactoredversion.Xpath;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;


public class TodoMvcTest {


    @Test
    void toDoCompletion() {
        Configuration.browser = "firefox";
        open("https://todomvc.com/examples/emberjs/");
        $x("//*[@id='new-todo']").append("a").pressEnter();
        $x("//*[@id='new-todo']").append("b").pressEnter();
        $x("//*[@id='new-todo']").append("c").pressEnter();
        $$x("//*[@id='todo-list']//li")
                .shouldHave(exactTexts("a", "b", "c"));

        $x("//*[@id='todo-list']//li[.//text()[normalize-space() = 'b']]//*" +
                Xpath.FilterBy.hasCssClass("toggle")).click();

        $$x("//*[@id='todo-list']//li" + Xpath.FilterBy.noCssClass("completed"))
                .shouldHave(exactTexts("a", "c"));
        $$x("//*[@id='todo-list']//li" + Xpath.FilterBy.hasCssClass("completed"))
                .shouldHave(exactTexts("b"));

    }
}
