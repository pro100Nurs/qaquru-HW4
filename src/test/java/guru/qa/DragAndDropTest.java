package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll
    static void configBeforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void changeAB() {

        // Открываем страницу
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // Переносим прямоугольник А на место В
        $("#column-a").dragAndDropTo("#column-b");

        // Проверяем, что прямоугольники действительно поменялись
        $("#column-a header").shouldHave(Condition.text("B"));
        $("#column-b header").shouldHave(Condition.text("A"));

    }
}
