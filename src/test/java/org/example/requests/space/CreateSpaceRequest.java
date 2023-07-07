package org.example.requests.space;

import io.restassured.response.Response;
import org.example.properties.ClickUpProperties;
import org.example.requests.BaseRequest;
import org.example.url.ClickUpUrl;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class CreateSpaceRequest {

    public static Response createSpace(JSONObject space) {
        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(space.toString())
                .when()
                .post(ClickUpUrl.getSpacesUrl(ClickUpProperties.getTeamId()))
                .then()
                .extract()
                .response();
    }
}
