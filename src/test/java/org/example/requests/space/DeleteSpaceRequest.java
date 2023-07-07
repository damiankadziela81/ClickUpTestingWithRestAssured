package org.example.requests.space;

import io.restassured.response.Response;
import org.example.requests.BaseRequest;
import org.example.url.ClickUpUrl;

import static io.restassured.RestAssured.given;

public class DeleteSpaceRequest {

    public static Response deleteSpace(String spaceId) {
        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .when()
                .delete(ClickUpUrl.getSpaceUrl(spaceId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}
