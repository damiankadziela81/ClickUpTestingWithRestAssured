package org.example.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class CreateSpaceTest {

//    {{url}}/team/{{teamId}}/space
//    9005139548

    private static final String BASE_URL = "https://api.clickup.com/api/v2";
    private static final String TOKEN = "pk_50695454_ZC3UP6OCOM3V1A4P477RFODFL54NQJAV";

    @Test
    void createSpaceTest(){

        JSONObject space = new JSONObject();
        space.put("name", "MY SPACE FROM JAVA");

        final Response response = given()
                .header("Authorization", TOKEN)
                .contentType(ContentType.JSON)
                .body(space.toString())
                .when()
                .post(BASE_URL + "/team/9005139548/space")
                .then()
                .extract()
                .response();

        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(response.jsonPath().getString("name")).isEqualTo("MY SPACE FROM JAVA");
    }
}
