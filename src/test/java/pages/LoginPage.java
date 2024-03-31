package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By registrationLink = By.xpath(".//a[@class='Auth_link__1fOlj' and @href='/register']");
    private By loginEmailField = By.xpath(".//div[@class='input pr-6 pl-6 input_type_text input_size_default']/input[@name='name']");
    private By loginPasswordField = By.xpath(".//div[@class='input pr-6 pl-6 input_type_password input_size_default']/input[@name='Пароль']");
    private By loginEnterButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private By restorePassLink = By.xpath(".//a[@href='/forgot-password' and text()='Восстановить пароль']");
    private By enterText = By.xpath("//h2[text()='Вход']");

    @Step("Клик на ссылку'Регистрация'")
    public void clickRegistrationLink() {
        driver.findElement(registrationLink).click();
    }

    @Step("Заполнение поля эл.почты на странице логина")
    public void fillingEmailLoginField(String email) {
        driver.findElement(loginEmailField).sendKeys(email);
    }

    @Step("Заполнение поля пароля на странице логина")
    public void fillingPasswordLoginField(String password) {
        driver.findElement(loginPasswordField).sendKeys(password);
    }

    @Step("Клик на кнопку входа на странице логина")
    public void clickLoginEnterButton() {
        driver.findElement(loginEnterButton).click();
    }

    @Step("Клик на кнопку 'Восстановить пароль' на странице логина")
    public void clickRestorePassLick() {
        driver.findElement(restorePassLink).click();
    }

    @Step("Ожидание отображения текста 'Вход'")
    public void waitEnterText() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(enterText));
    }

    @Step("Получение текста 'Вход'")
    public String getLoginHeaderText() {
        return driver.findElement(enterText).getText();
    }
}
