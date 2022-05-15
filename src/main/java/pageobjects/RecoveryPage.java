package pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RecoveryPage {

    public static final String RECOVER_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    // кнопка Восстановить
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Восстановить')]")
    private SelenideElement recoveryButton;

    // кнопка Войти
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Войти')]")
    private SelenideElement enterButton;


    @Step("Click recovery button")
    public ResetPasswordPage clickRecoveryButton() {
        recoveryButton.click();
        return page(ResetPasswordPage.class);
    }

    @Step("Click enter button")
    public LoginPage clickEnterButton() {
        enterButton.click();
        return page(LoginPage.class);
    }
}