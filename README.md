# Testing the Stellar Burgers web application.
    Automation of testing of the educational web application Stellar Burgers in Google Chrome and Yandex Browsers.
## Documentation
[Link](https://stellarburgers.nomoreparties.site/) to the Stellar Burgers educational app.
## Description
    Java 11 version.
Libraries:
- JUnit v4.13.2;
- Selenium v4.16.1
- RestAssured v4.4.0;
- Allure v2.15.0;

## Launch
To run the autotest you need to:

1. Clone the repository using the command:
```sh
git clone git@github.com:GermanGri/Diplom_3.git
```
2. To run tests
```sh
mvn clean test
```
3. To create a report in Allure
```sh
mvn allure:report
```
## Completed tasks
1. Registration:
- Successful registration;
- Error for short password;
2. Entrance:
- Login using the “Войти в аккаунт” button on the main page;
- Login using the “Личный кабинет” button;
- Login using the registration form;
- Login using the password recovery form.
3. Go to your personal account:
- Go to “Personal Account” by clicking;
- Transition from your personal account to the constructor;
- Click on “Constructor”;
- Click on the Stellar Burgers logo.
4. Logout:
- Exit using the “Logout” button in your personal account;
- Exiting the “Designer” section.
5. Transition to sections:
- "Buns";
- "Sauces";
- "Fillings".