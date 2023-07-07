package org.example.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTaskStatusResponseDto {

    private String status;
    private String type;

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "CreateTaskStatusResponseDto{" +
                "status='" + status + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
