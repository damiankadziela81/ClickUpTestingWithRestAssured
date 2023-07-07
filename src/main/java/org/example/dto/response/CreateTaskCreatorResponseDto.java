package org.example.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTaskCreatorResponseDto {

    @JsonProperty("username")
    private String userName;
    private String email;

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "CreateTaskCreatorResponseDto{" +
                "username='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
