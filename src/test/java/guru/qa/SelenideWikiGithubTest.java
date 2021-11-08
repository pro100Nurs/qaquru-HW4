package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideWikiGithubTest {

    @BeforeAll
    static void configBeforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void searchSoftAssertions() {

        // Открываем страницу Selenide в Github
        open("https://github.com/selenide/selenide");

        // Переходим в раздел (вкладку) Wiki проекта
        $("#wiki-tab").click();

        // Проверяем, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");

        // Открываем страницу SoftAssertions
        $$("#wiki-pages-box li a").findBy(Condition.text("SoftAssertions")).click();

        // Проверяем, что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(Condition.text("JUnit5 extension - com.codeborne.selenide.junit5.SoftAssertsExtension"));

    }
}
