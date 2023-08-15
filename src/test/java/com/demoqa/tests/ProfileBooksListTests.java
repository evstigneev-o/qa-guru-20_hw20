package com.demoqa.tests;

import com.codeborne.selenide.Selenide;
import com.demoqa.api.AuthorizationApi;
import com.demoqa.api.BooksApi;
import com.demoqa.models.AddBooksListModel;
import com.demoqa.models.LoginResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.demoqa.helpers.AddBookToBooksList.addBookToUserBooksList;
import static com.demoqa.helpers.AddCookie.addCookiesToBrowser;
import static com.demoqa.tests.TestData.credentials;

public class ProfileBooksListTests extends BaseTest {
    private final AuthorizationApi authorizationApi = new AuthorizationApi();
    private final BooksApi booksApi = new BooksApi();
    private LoginResponseModel loginResponse;

    @BeforeEach
    public void init() {
        loginResponse = authorizationApi.login(credentials);
        booksApi.deleteAllBooks(loginResponse);
    }

    @Test
    void addBookToProfileTest() {
        AddBooksListModel booksList = addBookToUserBooksList("9781449325862", loginResponse.getUserId());

        booksApi.addBook(loginResponse, booksList);
        addCookiesToBrowser(loginResponse);

        open("/profile");
        $("[id='see-book-Git Pocket Guide']").shouldBe(visible);
    }

    @Test
    void deleteBookFromProfileTest() {
        AddBooksListModel booksList = addBookToUserBooksList("9781449325862", loginResponse.getUserId());

        booksApi.addBook(loginResponse, booksList);
        addCookiesToBrowser(loginResponse);

        open("/profile");
        $("[id='delete-record-undefined']").click();
        $("#closeSmallModal-ok").click();
        Selenide.confirm();
        $("[id='see-book-Git Pocket Guide']").shouldNot(visible);
    }
}
