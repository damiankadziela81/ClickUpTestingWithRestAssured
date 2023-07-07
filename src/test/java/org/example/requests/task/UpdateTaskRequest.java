package org.example.requests.task;

import io.restassured.response.Response;
import org.example.requests.BaseRequest;
import org.example.url.ClickUpUrl;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class UpdateTaskRequest {

    public static Response updateTask(JSONObject updatedTask, String listId) {
        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(updatedTask.toString())
                .when()
                .put(ClickUpUrl.getTaskUrl(listId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}
