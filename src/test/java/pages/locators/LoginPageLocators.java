package pages.locators;




public interface LoginPageLocators {
    String registrationLinkXpath = ".//a[@class='Auth_link__1fOlj' and @href='/register']";
    String loginEmailFieldXpath = ".//div[@class='input pr-6 pl-6 input_type_text input_size_default']/input[@name='name']";
    String loginPasswordFieldXpath = ".//div[@class='input pr-6 pl-6 input_type_password input_size_default']/input[@name='Пароль']";
    String loginEnterButtonXpath = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']";
    String restorePassLinkXpath = ".//a[@href='/forgot-password' and text()='Восстановить пароль']";
    String enterTextXpath = "//h2[text()='Вход']";

}
