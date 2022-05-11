package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class ProfilePage {

    public static final String PROFILE_PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    // поле Имя
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Имя')]")
    private SelenideElement nameField;

    // поле Логин
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Логин')]")
    private SelenideElement loginField;

    // поле Пароль
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Пароль')]")
    private SelenideElement passwordField;

    // кнопка Профиль
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Профиль')]")
    private SelenideElement profileButton;

    // кнопка История заказов
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'История заказов')]")
    private SelenideElement ordersHistoryButton;

    // кнопка Выход
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Выход')]")
    private SelenideElement exitButton;

    // кнопка Сохранить
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Сохранить')]")
    private SelenideElement saveButton;

    // кнопка Конструктор
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Конструктор')]")
    private SelenideElement constructorButton;

    // логотип сайта Stellar Burgers
    @FindBy(how = How.XPATH, using = "//*[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logo;


    @Step("Set name")
    public ProfilePage setNameField(String name) {
        nameField.setValue(name);
        return this;
    }

    @Step("Set login")
    public ProfilePage setLoginField(String login) {
        loginField.setValue(login);
        return this;
    }

    @Step("Set password")
    public ProfilePage setPasswordField(String password) {
        passwordField.setValue(password);
        return this;
    }

    @Step("Click profile button")
    public ProfilePage clickProfileButton() {
        profileButton.click();
        return this;
    }

    @Step("Click orders history button")
    public OrderHistoryPage clickOrdersHistoryButton() {
        ordersHistoryButton.click();
        return page(OrderHistoryPage.class);
    }

    @Step("Click exit button")
    public LoginPage clickExitButton() {
        exitButton.click();
        return page(LoginPage.class);
    }

    @Step("Click save button")
    public ProfilePage clickSaveButton() {
        saveButton.click();
        return this;
    }

    @Step("Click constructor button")
    public MainPage clickConstructorButton() {
        constructorButton.click();
        return page(MainPage.class);
    }

    @Step("Click logo image")
    public MainPage clickLogo() {
        logo.click();
        return page(MainPage.class);
    }
}
