package com.demoqa.tests;

import com.demoqa.api.AuthorizationApi;
import com.demoqa.api.BooksApi;
import com.demoqa.models.LoginResponseModel;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.demoqa.helpers.AddCookie.addCookiesToBrowser;
import static com.demoqa.tests.TestData.credentials;

public class LoginTests extends BaseTest{
   private AuthorizationApi authorizationApi = new AuthorizationApi();
    @Test
    void successfulLoginTest() {
        LoginResponseModel loginResponse = authorizationApi.login(credentials);
        addCookiesToBrowser(loginResponse);

        open("/profile");
        $("#userName-value").shouldHave(text(credentials.getUserName()));

    }
}
