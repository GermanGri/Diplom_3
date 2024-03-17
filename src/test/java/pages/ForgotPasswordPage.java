package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ForgotPasswordPage {
    private WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public By loginLink = By.xpath(".//a[@class='Auth_link__1fOlj' and @href='/login']");

    @Step("Клик на ссылку 'Восстановить пароль' на странице логина")
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

}
