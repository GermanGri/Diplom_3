package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pages.locators.ProfileLocators.exitButtonXpath;
import static pages.locators.ProfileLocators.profileTextXpath;

public class ProfilePage {
    private WebDriver driver;
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    private By profileText = By.xpath(profileTextXpath);
    private By exitButton = By.xpath(exitButtonXpath);

    public void waitForLoadProfilePage(){
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(profileText));
    }
    public void clickExitButton(){
        driver.findElement(exitButton).click();
    }
    public String getProfileText(){
        return driver.findElement(profileText).getText();
    }



}
