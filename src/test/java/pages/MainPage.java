package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By privateOfficeButton = By.xpath(".//a[@class='AppHeader_header__link__3D_hX' and @href='/account']");
    private By LoginToAccountButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");
    public By textBurgerMainPage = By.xpath(".//section/h1[text()='Соберите бургер']");
    public By constructorButton = By.xpath(".//a[@class='AppHeader_header__link__3D_hX' and @href='/']");
    public By logo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    private By saucesTab = By.xpath(".//span[@class='text text_type_main-default' and text()='Соусы']");
    private By fillingsTab = By.xpath(".//span[@class='text text_type_main-default' and text()='Начинки']");
    private By bunsTab = By.xpath(".//span[@class='text text_type_main-default' and text()='Булки']");
    private By saucesText = By.xpath(".//h2[contains(@class, 'text text_type_main-medium mb-6 mt-10') and text()='Соусы']");
    private By fillingText = By.xpath(".//h2[contains(@class, 'text text_type_main-medium mb-6 mt-10') and text()='Начинки']");
    private By bunsText = By.xpath(".//h2[contains(@class, 'text text_type_main-medium mb-6 mt-10') and text()='Булки']");

    @Step("Клик на кнопку 'Личный кабинет'")
    public void clickPrivateOfficeButton() {
        driver.findElement(privateOfficeButton).click();
    }

    @Step("Клик на кнопку 'Войти в аккаунт'")
    public void clickLoginToAccountButton() {
        driver.findElement(LoginToAccountButton).click();
    }

    @Step("Ожидание отображения главной страницы")
    public void waitForLoadMainPage() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(textBurgerMainPage));
    }

    @Step("Получение текста 'Соберите бургер'")
    public String getBurgerHeaderText() {
        return driver.findElement(textBurgerMainPage).getText();
    }

    @Step("Клик на кнопку 'Конструктор'")
    public void clickConstructionButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Клик на логотип")
    public void clickLogo() {
        driver.findElement(logo).click();
    }

    @Step("Клик на вкладку 'Соусы'")
    public void clickSaucesTab() {
        driver.findElement(saucesTab).click();
    }

    @Step("Клик на вкладку 'Начинки'")
    public void clickFillingTab() {
        driver.findElement(fillingsTab).click();
    }

    @Step("Клик на вкладку 'Булки'")
    public void clickBunsTab() {
        driver.findElement(bunsTab).click();
    }

    @Step("Ожидание текста 'Соусы'")
    public void waitForLoadSaucesText() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(saucesText));
    }

    @Step("Ожидание текста 'Начинки'")
    public void waitForLoadFillingText() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(fillingText));
    }

    @Step("Ожидание текста 'Булки'")
    public void waitForLoadBunsText() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(bunsText));
    }

}
