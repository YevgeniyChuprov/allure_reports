import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class WebTest {

    @Test
    public void annotationStepSearchIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage(Settings.LINK);
        steps.searchRepository(Settings.REPOSITORY);
        steps.clickRepository(Settings.REPOSITORY);
        steps.openIssue();
        steps.shouldIssueWithNumber(Settings.ISSUE_NUM);
    }
}
