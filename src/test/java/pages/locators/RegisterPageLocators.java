package pages.locators;

public interface RegisterPageLocators {
    String nameRegistrationFieldXpath = ".//div[./label[text()='Имя']]/input[@name='name']";
    String emailRegistrationFieldXpath = ".//div[./label[text()='Email']]/input[@name='name']";
    String passwordRegistrationFieldXpath = ".//div[./label[text()='Пароль']]/input[@name='Пароль']";
    String registerButtonXpath = ".//button[text()='Зарегистрироваться']";
    String incorrectPassXpath = ".//p[text()='Некорректный пароль']";
    String loginLinkXpath = ".//a[@class='Auth_link__1fOlj' and @href='/login']";






}
