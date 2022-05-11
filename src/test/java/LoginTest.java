import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.RecoveryPage;
import pageObjects.RegistrationPage;
import rest.User;
import rest.UserClient;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static pageObjects.MainPage.MAIN_PAGE_URL;

@Feature("Login")
public class LoginTest {

    private User user;
    private UserClient userClient;
    private String accessToken;
    private MainPage mainPage;

    @Before
    public void setUp() {
        userClient = new UserClient();
        user = User.getRandom();
        ValidatableResponse response = userClient.userCreate(user);
        accessToken = response.extract().path("accessToken");
        mainPage = open(MAIN_PAGE_URL, MainPage.class);
    }

    @After
    public void tearDown() {
        userClient.deleteUser(accessToken, user);
    }

    @Test
    @DisplayName("Validation test")
    @Description("Validation test with click enter button from Main page")
    public void enterButtonMainPageTest() {
        mainPage.clickEnterAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickEnterButton();

        webdriver().shouldHave(url(MAIN_PAGE_URL));
    }

    @Test
    @DisplayName("Validation test")
    @Description("Validation test with click personal account button from Main page")
    public void personalAccountButtonMainPageTest() {
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickEnterButton();

        webdriver().shouldHave(url(MAIN_PAGE_URL));
    }

    @Test
    @DisplayName("Validation test")
    @Description("Validation test with click enter button from Registration page")
    public void enterButtonRegistrationPageTest() {
        mainPage.clickEnterAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegistrationButton();

        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.clickEnterButton();

        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickEnterButton();

        webdriver().shouldHave(url(MAIN_PAGE_URL));
    }

    @Test
    @DisplayName("Validation test")
    @Description("Validation test with click enter button from recovery page")
    public void enterButtonRecoverPageTest() {
        mainPage.clickEnterAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRecoverButton();

        RecoveryPage recoverPage = page(RecoveryPage.class);
        recoverPage.clickEnterButton();

        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickEnterButton();

        webdriver().shouldHave(url(MAIN_PAGE_URL));
    }
}