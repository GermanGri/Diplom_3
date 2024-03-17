package tests;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.*;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import static helper.Helper.*;
import static io.restassured.RestAssured.given;


public class LoginTests extends BaseTest {
    @Before
    public void setUp() {
        driver.get(URL);
        createUserFromAPI();
    }

    @Test
    @DisplayName("Login using the “Войти в аккаунт” button on the main page")
    @Step("Login from enter account button")
    public void loginFromMainPageButton() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickLoginToAccountButton();
        loginPage.fillingEmailLoginField(getRandomEmail());
        loginPage.fillingPasswordLoginField(getRandomPassword());
        loginPage.clickLoginEnterButton();
        mainPage.waitForLoadMainPage();
        Assert.assertEquals("Соберите бургер", mainPage.getBurgerHeaderText());
    }

    @Test
    @DisplayName("Login using the “Личный кабинет” button")
    @Step("Login from private office button")
    public void loginFromPrivateOfficeButton() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickPrivateOfficeButton();
        loginPage.fillingEmailLoginField(getRandomEmail());
        loginPage.fillingPasswordLoginField(getRandomPassword());
        loginPage.clickLoginEnterButton();
        mainPage.waitForLoadMainPage();
        Assert.assertEquals("Соберите бургер", mainPage.getBurgerHeaderText());
    }

    @Test
    @DisplayName("Login using the registration form")
    @Step("Login from registration page")
    public void loginFromRegistrationPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.clickLoginToAccountButton();
        loginPage.clickRegistrationLink();
        registerPage.clickLoginLink();
        loginPage.fillingEmailLoginField(getRandomEmail());
        loginPage.fillingPasswordLoginField(getRandomPassword());
        loginPage.clickLoginEnterButton();
        mainPage.waitForLoadMainPage();
        Assert.assertEquals("Соберите бургер", mainPage.getBurgerHeaderText());
    }

    @Test
    @DisplayName("Login using the password recovery form")
    @Step("Login from forgot-password page")
    public void loginFromForgotPassPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        mainPage.clickLoginToAccountButton();
        loginPage.clickRestorePassLick();
        forgotPasswordPage.clickLoginLink();
        loginPage.fillingEmailLoginField(getRandomEmail());
        loginPage.fillingPasswordLoginField(getRandomPassword());
        loginPage.clickLoginEnterButton();
        mainPage.waitForLoadMainPage();
        Assert.assertEquals("Соберите бургер", mainPage.getBurgerHeaderText());
    }

    @AfterClass
    @Step("Delete credentials")
    static public void DeleteUser() {
        given()
                .auth().oauth2(getAccessToken())
                .delete(USER_URL)
                .then().assertThat().statusCode(202).and().body("success", Matchers.is(true));
    }
}
