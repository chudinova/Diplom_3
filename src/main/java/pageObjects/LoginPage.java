package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";

    // поле Email
    @FindBy(how = How.XPATH, using = ".//input[@name ='name']")
    private SelenideElement emailField;

    // поле Пароль
    @FindBy(how = How.XPATH, using = ".//input[@name ='Пароль']")
    private SelenideElement passwordField;

    // кнопка Войти
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Войти')]")
    private SelenideElement enterButton;

    // кнопка Зарегистрироваться
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Зарегистрироваться')]")
    private SelenideElement registrationButton;

    // кнопка Восстановить пароль
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Восстановить')]")
    private SelenideElement passwordRecoveryButton;


    @Step("Set email")
    public LoginPage setEmailField(String email){
        emailField.setValue(email);
        return this;
    }

    @Step("Set password")
    public LoginPage setPasswordField(String password) {
        passwordField.setValue(password);
        return this;
    }

    @Step("Click enter button")
    public MainPage clickEnterButton() {
        enterButton.click();
        return page(MainPage.class);
    }

    @Step("Click registration button")
    public RegistrationPage clickRegistrationButton() {
        registrationButton.click();
        return page(RegistrationPage.class);
    }

    @Step("Click password recovery button")
    public RecoveryPage clickRecoverButton() {
        passwordRecoveryButton.click();
        return page(RecoveryPage.class);
    }
}
