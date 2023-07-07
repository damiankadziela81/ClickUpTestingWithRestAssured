package org.example.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTaskResponseDto {

    private String id;
    private String name;
    @JsonProperty("text_content")
    private String textContent;
    private String description;
    private CreateTaskStatusResponseDto status;
    private CreateTaskCreatorResponseDto creator;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTextContent() {
        return textContent;
    }

    public String getDescription() {
        return description;
    }

    public CreateTaskStatusResponseDto getStatus() {
        return status;
    }

    public CreateTaskCreatorResponseDto getCreator() {
        return creator;
    }

    @Override
    public String toString() {
        return "CreateTaskResponseDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", textContent='" + textContent + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", creator=" + creator +
                '}';
    }
}
