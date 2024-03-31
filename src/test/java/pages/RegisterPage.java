package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegisterPage {
    private static WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nameRegistrationField = By.xpath(".//div[./label[text()='Имя']]/input[@name='name']");
    private By emailRegistrationField = By.xpath(".//div[./label[text()='Email']]/input[@name='name']");
    private By passwordRegistrationField = By.xpath(".//div[./label[text()='Пароль']]/input[@name='Пароль']");
    private By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    public By incorrectPassText = By.xpath(".//p[text()='Некорректный пароль']");
    public By loginLink = By.xpath(".//a[@class='Auth_link__1fOlj' and @href='/login']");

    @Step("Заполнение поля имени пользователя на странице регистрации")
    public void fillingNameRegistrationField(String name) {
        driver.findElement(nameRegistrationField).sendKeys(name);
    }

    @Step("Заполнение поля эл.почты пользователя на странице регистрации")
    public void fillingEmailRegistrationField(String email) {
        driver.findElement(emailRegistrationField).sendKeys(email);
    }

    @Step("Заполнение поля пароля на странице регистрации")
    public void fillingPasswordRegistrationField(String password) {
        driver.findElement(passwordRegistrationField).sendKeys(password);
    }

    @Step("Клик на кнопку регистрации на странице регистрации")
    public void registerButtonClick() {
        driver.findElement(registerButton).click();
    }

    @Step("Клик на кнопку логина на странице регистрации")
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

}
