import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.ProfilePage;
import rest.User;
import rest.UserClient;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static pageobjects.LoginPage.LOGIN_PAGE_URL;
import static pageobjects.MainPage.MAIN_PAGE_URL;
import static pageobjects.ProfilePage.PROFILE_PAGE_URL;

@Feature("Registration")
public class AccountTest {

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
    @DisplayName("Profile test")
    @Description("Check Profile page")
    public void personalAccountTest() {
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickEnterButton();

        mainPage.clickPersonalAccountButton();

        webdriver().shouldHave(url(PROFILE_PAGE_URL));
    }

    @Test
    @DisplayName("Click constructor button")
    @Description("Check click constructor button from Profile page")
    public void constructorFromPersonalAccountTest() {
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickEnterButton();

        mainPage.clickPersonalAccountButton();

        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickConstructorButton();

        webdriver().shouldHave(url(MAIN_PAGE_URL));
    }

    @Test
    @DisplayName("Click logo")
    @Description("Check click logo on profile page")
    public void constructorLogoImageFromPersonalAccountTest() {
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickEnterButton();

        mainPage.clickPersonalAccountButton();

        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickLogo();

        webdriver().shouldHave(url(MAIN_PAGE_URL));
    }

    @Test
    @DisplayName("Exit from account")
    @Description("Check exit from profile page")
    public void exitFromAccountTest() {
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickEnterButton();

        mainPage.clickPersonalAccountButton();

        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickExitButton();

        webdriver().shouldHave(url(LOGIN_PAGE_URL));
    }
}