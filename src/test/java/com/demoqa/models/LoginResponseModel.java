package com.demoqa.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginResponseModel {
    private String userId;
    @JsonProperty("username")
    private String userName;
    private String password;
    private String token;
    private String expires;
    @JsonProperty("created_date")
    private String createdDate;
    private String isActive;
}
