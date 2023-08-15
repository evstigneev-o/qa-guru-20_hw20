package com.demoqa.helpers;

import com.demoqa.models.AddBooksListModel;
import com.demoqa.models.IsbnModel;

import java.util.List;

public class AddBookToBooksList {
    public static AddBooksListModel addBookToUserBooksList(String isbn, String userId) {
        return AddBooksListModel.builder()
                .userId(userId)
                .collectionOfIsbns(List.of(new IsbnModel(isbn)))
                .build();
    }
}
