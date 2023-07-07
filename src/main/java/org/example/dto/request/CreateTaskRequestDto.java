package org.example.dto.request;

import lombok.Data;

@Data
public class CreateTaskRequestDto {

    private String name;
    private String description;
    private String status;
    private String priority;
    private String assignees;
    private String timeEstimate;
    private String parent;
    private boolean archived;
}
