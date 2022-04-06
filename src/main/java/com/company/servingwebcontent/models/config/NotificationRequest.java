package com.company.servingwebcontent.models.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NotificationRequest {

    @JsonProperty("clientSecret")
    String clientSecret;

    @JsonProperty("email")
    String email;
}
