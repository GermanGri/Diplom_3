package tests;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import site.nomoreparties.stellarburgers.User;

import static helper.Helper.*;
import static io.restassured.RestAssured.given;


public class LoginTests extends BaseTest {


    @Before
    public void setUp() {
        driver.get(URL);
        createUserFromAPI();
    }



    @Test
    @Step("Login from enter account button")
    public void loginFromMainPageButton(){
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
    @Step("Login from private office button")
    public void loginFromPrivateOfficeButton(){
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
    @Step("Login from registration page")
    public void loginFromRegistrationPage(){
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
    @Step("Login from forgot-password page")
    public void loginFromForgotPassPage(){
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
