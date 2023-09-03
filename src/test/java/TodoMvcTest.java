import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
        import static com.codeborne.selenide.Selectors.*;
        import static com.codeborne.selenide.Condition.*;
        import static com.codeborne.selenide.CollectionCondition.*;
        import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

        import org.junit.jupiter.api.Test;

public class TodoMvcTest {

    @Test
    void taskComption() {

        open("https://todomvc.com/examples/emberjs/");

        $("#new-todo").append("a").pressEnter();
        $("#new-todo").append("b").pressEnter();
        $("#new-todo").append("c").pressEnter();
        $$("#todo-list>li").shouldHave(exactTexts("a","b","c"));

        $("#todo-list>li:nth-child(2) input.toggle").click();

        $("#todo-list>li:nth-child(2)[class='completed ember-view']").shouldHave(exactText("b"));
        $$("#todo-list>li[class='ember-view']").shouldHave(exactTexts("a","c"));
    }
}