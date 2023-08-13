package com.demoqa.helpers;

import com.demoqa.models.AddBooksListModel;
import com.demoqa.models.IsbnModel;

import java.util.ArrayList;
import java.util.List;

public class AddBookToBooksList {
    public static AddBooksListModel addBookToUserBooksList(String isbn, String userId){
        IsbnModel isbnModel = new IsbnModel();
        isbnModel.setIsbn(isbn);
        List<IsbnModel> isbnList = new ArrayList<>();
        isbnList.add(isbnModel);
        AddBooksListModel booksList = new AddBooksListModel();
        booksList.setUserId(userId);
        booksList.setCollectionOfIsbns(isbnList);
        return booksList;
    }
}
