package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pages.locators.LoginPageLocators.*;


public class LoginPage {
    private WebDriver driver;
    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }
    private By registrationLink = By.xpath(registrationLinkXpath);
    private By loginEmailField = By.xpath(loginEmailFieldXpath);
    private By loginPasswordField = By.xpath(loginPasswordFieldXpath);
    private By loginEnterButton = By.xpath(loginEnterButtonXpath);
    private By restorePassLink = By.xpath(restorePassLinkXpath);
    private By enterText = By.xpath(enterTextXpath);

    public void clickRegistrationLink(){
        driver.findElement(registrationLink).click();
    }
    public void fillingEmailLoginField(String email){
        driver.findElement(loginEmailField).sendKeys(email);
    }
    public void fillingPasswordLoginField(String password){
        driver.findElement(loginPasswordField).sendKeys(password);
    }
    public void clickLoginEnterButton(){
        driver.findElement(loginEnterButton).click();
    }
    public void clickRestorePassLick(){
        driver.findElement(restorePassLink).click();
    }
    public void waitEnterText(){
        new WebDriverWait(driver, Duration.ofSeconds(15))
                     .until(ExpectedConditions.visibilityOfElementLocated(enterText));
    }
    public String getLoginHeaderText(){
        return driver.findElement(enterText).getText();
    }
}
