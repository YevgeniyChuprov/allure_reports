import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepTest {

    @Test
    public void stepSearchIssue() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем github", () ->{
            open(Settings.LINK);
        });

        step("Ищем репозиторий" + Settings.REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(Settings.REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Кликаем по ссылке репозитория " + Settings.REPOSITORY, () -> {
            $(linkText(Settings.REPOSITORY)).click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с номером " + Settings.ISSUE_NUM, () -> {
            $(withText("#" + Settings.ISSUE_NUM)).should(Condition.exist);
        });
    }
}
