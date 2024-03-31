package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ProfilePage {
    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    private By profileText = By.xpath(".//a[@class='Account_link__2ETsJ text text_type_main-medium text_color_inactive Account_link_active__2opc9' and text()='Профиль']");
    private By exitButton = By.xpath(".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive' and text()='Выход']");

    @Step("Ожидание отображения страницы профиля")
    public void waitForLoadProfilePage() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(profileText));
    }

    @Step("Клик на кнопку выхода")
    public void clickExitButton() {
        driver.findElement(exitButton).click();
    }

    @Step("Получение текста профиля")
    public String getProfileText() {
        return driver.findElement(profileText).getText();
    }


}
