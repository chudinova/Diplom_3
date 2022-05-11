package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {

    public static final String REGISTRATION_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";


    // поле Имя
    @FindBy(how = How.XPATH, using = "//fieldset[1]//input")
    private SelenideElement nameField;

    // поле Email
    @FindBy(how = How.XPATH, using = "//fieldset[2]//input")
    private SelenideElement emailField;

    // поле Пароль
    @FindBy(how = How.XPATH, using = "//input[@type='password']")
    private SelenideElement passwordField;

    // кнопка Зарегистрироваться
    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;

    // кнопка Войти
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Войти')]")
    private SelenideElement enterButton;

    // кнопка Конструктор
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Конструктор')]")
    private SelenideElement constructorButton;

    // ошибка Некорректный пароль
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Некорректный пароль')]")
    private SelenideElement errorPasswordField;


    @Step("Set name")
    public RegistrationPage setNameField(String name) {
        nameField.setValue(name);
        return this;
    }

    @Step("Set email")
    public RegistrationPage setEmailField(String email) {
        emailField.setValue(email);
        return this;
    }

    @Step("Set password")
    public RegistrationPage setPasswordField(String password) {
        passwordField.setValue(password);
        return this;
    }

    @Step("Click register button")
    public LoginPage clickRegisterButton () {
        this.registerButton.click();
        return page(LoginPage.class);
    }

    @Step("Click enter button")
    public LoginPage clickEnterButton() {
        enterButton.click();
        return page(LoginPage.class);
    }

    @Step("Click constructor button")
    public MainPage clickConstructorButton() {
        constructorButton.click();
        return page(MainPage.class);
    }

    @Step("Incorrect password error message is displayed")
    public boolean errorPasswordFieldIsDisplayed() {
        return errorPasswordField.isDisplayed();
    }
}
