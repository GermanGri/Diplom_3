package pages.locators;

public interface MainPageLocators {
    String privateOfficeButtonHeaderXpath =  ".//a[@class='AppHeader_header__link__3D_hX' and @href='/account']";

    String loginToAccountButtonXpath = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']";
    String textBurgerMainPageXpath = ".//section/h1[text()='Соберите бургер']";
    String constructorButtonXpath = ".//a[@class='AppHeader_header__link__3D_hX' and @href='/']";
    String logoXpath = ".//div[@class='AppHeader_header__logo__2D0X2']";
    String saucesTabXpath = ".//span[@class='text text_type_main-default' and text()='Соусы']";
    String fillingsTabXpath = ".//span[@class='text text_type_main-default' and text()='Начинки']";
    String bunsTabXpath = ".//span[@class='text text_type_main-default' and text()='Булки']";
    String saucesTextXpath = ".//h2[contains(@class, 'text text_type_main-medium mb-6 mt-10') and text()='Соусы']";
    String fillingTextXpath = ".//h2[contains(@class, 'text text_type_main-medium mb-6 mt-10') and text()='Начинки']";
    String bunsTextXpath = ".//h2[contains(@class, 'text text_type_main-medium mb-6 mt-10') and text()='Булки']";


}
