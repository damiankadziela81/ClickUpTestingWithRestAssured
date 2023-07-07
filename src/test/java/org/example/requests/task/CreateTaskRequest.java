package org.example.requests.task;

import io.restassured.response.Response;
import org.example.dto.request.CreateTaskRequestDto;
import org.example.dto.response.CreateTaskResponseDto;
import org.example.requests.BaseRequest;
import org.example.url.ClickUpUrl;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class CreateTaskRequest {

    public static Response createTask(JSONObject task, String listId) {
        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(task.toString())
                .when()
                .post(ClickUpUrl.getTasksUrl(listId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }

    public static CreateTaskResponseDto createTask(CreateTaskRequestDto taskDto, String listId) {
        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(taskDto)
                .when()
                .post(ClickUpUrl.getTasksUrl(listId))
                .then()
                .statusCode(200)
                .log().ifError()
                .extract()
                .response()
                .as(CreateTaskResponseDto.class);
    }
}
