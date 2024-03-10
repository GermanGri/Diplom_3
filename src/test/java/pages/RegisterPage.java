package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.locators.RegisterPageLocators.*;

public class RegisterPage {
    private static WebDriver driver;
    public RegisterPage (WebDriver driver) {
        this.driver = driver;
    }
    private By nameRegistrationField = By.xpath(nameRegistrationFieldXpath);
    private By emailRegistrationField = By.xpath(emailRegistrationFieldXpath);
    private By passwordRegistrationField = By.xpath(passwordRegistrationFieldXpath);
    private By registerButton = By.xpath(registerButtonXpath);
    public By incorrectPassText = By.xpath(incorrectPassXpath);
    public By loginLink = By.xpath(loginLinkXpath);

    public void fillingNameRegistrationField(String name){
        driver.findElement(nameRegistrationField).sendKeys(name);
    }
    public void fillingEmailRegistrationField(String email){
        driver.findElement(emailRegistrationField).sendKeys(email);
    }
    public void fillingPasswordRegistrationField(String password){
        driver.findElement(passwordRegistrationField).sendKeys(password);
    }
    public void registerButtonClick(){
        driver.findElement(registerButton).click();
    }
    public void clickLoginLink(){driver.findElement(loginLink).click();}

}
