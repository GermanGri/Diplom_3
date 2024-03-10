package tests;

import io.qameta.allure.Step;
import org.hamcrest.Matchers;
import org.junit.*;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

import static helper.Helper.*;
import static io.restassured.RestAssured.given;


public class TransitionsTests extends BaseTest{

    @Before
    public void setUp() {
        driver.get(URL);
        createUserFromAPI();
    }
    @Test
    @Step("Positive: Transitions test")
    public void transitionsTest(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        // Login
        mainPage.clickPrivateOfficeButton();
        loginPage.fillingEmailLoginField(getRandomEmail());
        loginPage.fillingPasswordLoginField(getRandomPassword());
        loginPage.clickLoginEnterButton();
        mainPage.waitForLoadMainPage();
        Assert.assertEquals("Соберите бургер", mainPage.getBurgerHeaderText());
        //Click constructor button
        mainPage.clickPrivateOfficeButton();
        profilePage.waitForLoadProfilePage();
        Assert.assertEquals("Профиль", profilePage.getProfileText());

        mainPage.clickConstructionButton();
        mainPage.waitForLoadMainPage();
        //Click logo button
        mainPage.clickPrivateOfficeButton();
        profilePage.waitForLoadProfilePage();
        mainPage.clickLogo();
        mainPage.waitForLoadMainPage();
        //Clicking tabs
        mainPage.clickSaucesTab();
        mainPage.waitForLoadSaucesText();
        mainPage.clickFillingTab();
        mainPage.waitForLoadFillingText();
        mainPage.clickBunsTab();
        mainPage.waitForLoadBunsText();
        //Exit
        mainPage.clickPrivateOfficeButton();
        profilePage.waitForLoadProfilePage();
        profilePage.clickExitButton();
        loginPage.waitEnterText();
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
