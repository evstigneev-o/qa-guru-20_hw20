package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.api.AuthorizationApi;
import com.demoqa.api.BooksApi;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        RestAssured.baseURI = "https://demoqa.com";
    }
}
