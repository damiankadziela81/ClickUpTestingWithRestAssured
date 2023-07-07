package org.example.requests.space;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.properties.ClickUpProperties;
import org.example.url.ClickUpUrl;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class CreateSpaceRequest {

    public static Response createSpace(JSONObject space) {
        return given()
                .header("Authorization", ClickUpProperties.getToken())
                .contentType(ContentType.JSON)
                .body(space.toString())
                .when()
                .post(ClickUpUrl.getSpacesUrl(ClickUpProperties.getTeamId()))
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}
