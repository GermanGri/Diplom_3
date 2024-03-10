package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.locators.ForgotPasswordLocators.loginLinkXpath;

public class ForgotPasswordPage {
    private WebDriver driver;
    public ForgotPasswordPage (WebDriver driver) {
        this.driver = driver;
    }
    public By loginLink = By.xpath(loginLinkXpath);


    public void clickLoginLink(){
        driver.findElement(loginLink).click();
    }






}
