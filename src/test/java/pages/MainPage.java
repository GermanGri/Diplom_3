package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pages.locators.MainPageLocators.*;

public class MainPage {
    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    private By privateOfficeButton = By.xpath(privateOfficeButtonHeaderXpath);
    private By LoginToAccountButton = By.xpath(loginToAccountButtonXpath);
    public By textBurgerMainPage = By.xpath(textBurgerMainPageXpath);
    public By constructorButton = By.xpath(constructorButtonXpath);
    public By logo = By.xpath(logoXpath);
    private By saucesTab = By.xpath(saucesTabXpath);
    private By fillingsTab = By.xpath(fillingsTabXpath);
    private By bunsTab = By.xpath(bunsTabXpath);
    private By saucesText = By.xpath(saucesTextXpath);
    private By fillingText = By.xpath(fillingTextXpath);
    private By bunsText = By.xpath(bunsTextXpath);



    public void clickPrivateOfficeButton() {
        driver.findElement(privateOfficeButton).click();
    }
    public void clickLoginToAccountButton(){
        driver.findElement(LoginToAccountButton).click();
    }
    public void waitForLoadMainPage() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(textBurgerMainPage));
    }
    public String getBurgerHeaderText(){
        return driver.findElement(textBurgerMainPage).getText();
    }
    public void clickConstructionButton(){
        driver.findElement(constructorButton).click();
    }
    public void clickLogo(){
        driver.findElement(logo).click();
    }
    public void clickSaucesTab(){
        driver.findElement(saucesTab).click();
    }
    public void clickFillingTab(){
        driver.findElement(fillingsTab).click();
    }
    public void clickBunsTab(){
        driver.findElement(bunsTab).click();
    }

    public void waitForLoadSaucesText() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(saucesText));
    }
    public void waitForLoadFillingText() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(fillingText));
    }
    public void waitForLoadBunsText() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(bunsText));
    }

}
