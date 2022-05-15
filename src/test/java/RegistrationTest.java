import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.RegistrationPage;
import rest.User;
import rest.UserClient;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.junit.Assert.assertTrue;
import static pageobjects.LoginPage.LOGIN_PAGE_URL;

@Feature("Registration")
public class RegistrationTest {

    private User user;
    private UserClient userClient;
    private MainPage mainPage;
    private String accessToken;
    private ValidatableResponse response;

    @Before
    public void setUp() {
        userClient = new UserClient();
        user = User.getRandom();
        mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
        response = userClient.userCreate(user);
        accessToken = response.extract().path("accessToken").toString();
    }

    @After
    public void tearDown() {

        userClient.deleteUser(accessToken, user);
    }

    @Test
    @DisplayName("Successful registration")
    @Description("Successful registration and check url")
    public void positiveRegistrationTest() throws InterruptedException {
        mainPage.clickEnterAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegistrationButton();

        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.setNameField(user.getName());
        registrationPage.setEmailField(user.getEmail());
        registrationPage.setPasswordField(user.getPassword());
        registrationPage.clickRegisterButton();

        webdriver().shouldHave(url(LOGIN_PAGE_URL));
    }

    @Test
    @DisplayName("Registration with too short password")
    @Description("Check error field for not valid password (<6)")
    public void checkErrorFieldPasswordTest() {
        mainPage.clickEnterAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegistrationButton();

        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.setNameField(user.getName());
        registrationPage.setEmailField(user.getEmail());
        registrationPage.setPasswordField(RandomStringUtils.randomAlphabetic(5));
        registrationPage.clickRegisterButton();

        assertTrue("Error password field not displayed", registrationPage.errorPasswordFieldIsDisplayed());
    }
}