package com.demoqa.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AddBooksListModel {
   private String userId;
   private List<IsbnModel> collectionOfIsbns;

}
