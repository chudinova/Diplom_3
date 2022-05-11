package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";


    // кнопка Войти в аккаунт
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Войти в аккаунт')]")
    private SelenideElement enterAccountButton;

    // кнопка Личный кабинет
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Личный Кабинет')]")
    private SelenideElement personalAccountButton;

    // кнопка Конструктор
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Конструктор')]")
    private SelenideElement constructorButton;

    // вкладка Булки
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunsTab;

    // вкладка Соусы
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement saucesTab;

    // вкладка Начинки
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement meatsTab;

    // виды Булок
    @FindBy(how = How.XPATH, using = "//*[@src='https://code.s3.yandex.net/react/code/bun-01.png']")
    private SelenideElement kindsBuns;

    // виды Соусов
    @FindBy(how = How.XPATH, using = "//*[@src='https://code.s3.yandex.net/react/code/sauce-02.png']")
    private SelenideElement kindsSauces;

    // виды Начинок
    @FindBy(how = How.XPATH, using = "//*[@src='https://code.s3.yandex.net/react/code/meat-02.png']")
    private SelenideElement kindsMeats;


    @Step("Click enter button")
    public LoginPage clickEnterAccountButton() {
        enterAccountButton.click();
        return page(LoginPage.class);
    }

    @Step("Click personal account button")
    public LoginPage clickPersonalAccountButton () {
        personalAccountButton.click();
        return page(LoginPage.class);
    }

    @Step("Click constructor button")
    public MainPage clickConstructorButton() {
        constructorButton.click();
        return this;
    }

    @Step("Choose buns tab")
    public MainPage clickBunsChoose() {
        bunsTab.click();
        return this;
    }

    @Step("Choose sauce tab")
    public MainPage clickSaucesChoose() {
        saucesTab.click();
        return this;
    }

    @Step("Choose meats tab")
    public MainPage clickMeatsChoose() {
        meatsTab.click();
        return this;
    }

    @Step("Kinds buns is displayed")
    public boolean isDisplayedKindsBuns() {
        return kindsBuns.isDisplayed();
    }

    @Step("Kinds sauces is displayed")
    public boolean isDisplayedKindsSauces() {
        return kindsSauces.isDisplayed();
    }

    @Step("Kinds meats is displayed")
    public boolean isDisplayedKindsMeats() {
        return kindsMeats.isDisplayed();
    }
}
