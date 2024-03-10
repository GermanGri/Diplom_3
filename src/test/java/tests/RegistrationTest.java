package tests;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.*;

import pages.MainPage;
import pages.LoginPage;
import pages.RegisterPage;
import site.nomoreparties.stellarburgers.User;

import static helper.Helper.*;
import static io.restassured.RestAssured.given;


public class RegistrationTest extends BaseTest{
    private static String randomEmail;
    private static String randomPassword;
    private static String randomName;
    private static String accessToken;

    @Before
    public void setUp() {
        driver.get(URL);

        RestAssured.baseURI = BASE_URI;
        randomEmail = generateRandomEmail(5);
        randomPassword = generateRandomString(6);
        randomName = generateRandomString(7);

    }


    @Test
    @Step("Positive: Registration user")
    public void registrationTest(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.clickPrivateOfficeButton();
        loginPage.clickRegistrationLink();
        registerPage.fillingNameRegistrationField(randomName);
        registerPage.fillingEmailRegistrationField(randomEmail);
        registerPage.fillingPasswordRegistrationField(randomPassword);
        registerPage.registerButtonClick();
        Assert.assertEquals("Вход",loginPage.getLoginHeaderText());
    }

    @Test
    @Step("Negative: Failed registration, short password")
    public void incorrectRegistrationTest(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        mainPage.clickPrivateOfficeButton();
        loginPage.clickRegistrationLink();
        registerPage.fillingNameRegistrationField(randomName);
        registerPage.fillingEmailRegistrationField(randomEmail);
        registerPage.fillingPasswordRegistrationField("four");
        registerPage.registerButtonClick();
        Assert.assertTrue("Элемент с сообщением об ошибке не отображается", driver.findElement(registerPage.incorrectPassText).isDisplayed());
    }

    @AfterClass
    static public void deleteUser() {
        User user = new User(randomEmail, randomPassword, null);
        Response response = given()
                .header(CONTENT_TYPE_LABEL, CONTENT_TYPE_VALUE)
                .body(user)
                .when()
                .post(USER_LOGIN_URL);
        accessToken = response.jsonPath().getString("accessToken").replace("Bearer ", "");
        given()
                .auth().oauth2(accessToken)
                .delete(USER_URL)
                .then().assertThat().statusCode(202).and().body("success", Matchers.is(true));
    }

}








