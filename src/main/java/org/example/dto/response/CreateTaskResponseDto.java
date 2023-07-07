package org.example.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTaskResponseDto {

    private String id;
    private String name;
    @JsonProperty("text_content")
    private String textContent;
    private String description;
    private CreateTaskStatusResponseDto status;
    private CreateTaskCreatorResponseDto creator;
}
