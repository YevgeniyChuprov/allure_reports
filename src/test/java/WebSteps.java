import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step("Открываем github")
    public void openMainPage(String link) {
        open(link);
    }

    @Step("Ищем репозиторий {repository}")
    public void searchRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Кликаем по ссылке {repository}")
    public void clickRepository(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Открываем issues-tab")
    public void openIssue() {
        $("#issues-tab").click();
    }

    @Step("Проверяем issues")
    public void shouldIssueWithNumber(int issueNum) {
        $(withText("#" + issueNum)).should(Condition.exist);
    }
}
