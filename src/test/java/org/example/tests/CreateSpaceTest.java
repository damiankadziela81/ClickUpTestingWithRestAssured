package org.example.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.example.properties.ClickUpProperties;
import org.example.url.ClickUpUrl;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class CreateSpaceTest {

    @Test
    void createSpaceTest(){

        JSONObject space = new JSONObject();
        space.put("name", "MY SPACE FROM JAVA");

        final Response response = given()
                .header("Authorization", ClickUpProperties.getToken())
                .contentType(ContentType.JSON)
                .body(space.toString())
                .when()
                .post(ClickUpUrl.getSpacesUrl(ClickUpProperties.getTeamId()))
                .then()
                .log().ifError()
                .extract()
                .response();

        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(response.jsonPath().getString("name")).isEqualTo("MY SPACE FROM JAVA");
    }
}
