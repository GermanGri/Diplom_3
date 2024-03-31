package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import site.nomoreparties.stellarburgers.User;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class Helper {
    public static final String BASE_URI = "https://stellarburgers.nomoreparties.site";
    public static final String USER_URL = "/api/auth/user";
    public static final String USER_REGISTER_URL = "/api/auth/register";
    public static final String CONTENT_TYPE_LABEL = "Content-type";
    public static final String CONTENT_TYPE_VALUE = "application/json";
    public static final String USER_LOGIN_URL = "/api/auth/login";
    private static String randomEmail;
    private static String randomPassword;
    private static String randomName;
    private static String accessToken;


    public static String getRandomEmail() {
        return randomEmail;
    }

    public static String getRandomPassword() {
        return randomPassword;
    }

    public static String getRandomName() {
        return randomName;
    }

    public static String getAccessToken() {
        return accessToken;
    }

    public static String generateRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder randomString = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }
        return randomString.toString();
    }

    public static String generateRandomEmail(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder randomString = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        String domain = "@example.com";

        return randomString.toString() + domain;
    }

    public static void createUserFromAPI() {
        RestAssured.baseURI = BASE_URI;
        randomEmail = generateRandomEmail(5);
        randomPassword = generateRandomString(6);
        randomName = generateRandomString(7);

        User user = new User(randomEmail, randomPassword, randomName);
        Response response = given()
                .header(CONTENT_TYPE_LABEL, CONTENT_TYPE_VALUE)
                .body(user)
                .when()
                .post(USER_REGISTER_URL);
        response.then().assertThat().statusCode(200).and().body("success", Matchers.is(true));
        accessToken = response.jsonPath().getString("accessToken").replace("Bearer ", "");
    }

}
