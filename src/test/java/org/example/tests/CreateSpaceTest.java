package org.example.tests;

import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.example.requests.space.CreateSpaceRequest;
import org.example.requests.space.DeleteSpaceRequest;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

class CreateSpaceTest {

    private static final String SPACE_NAME = "MY SPACE FROM JAVA";

    @Test
    void createSpaceTest(){

        JSONObject space = new JSONObject();
        space.put("name", SPACE_NAME);

        final Response response = CreateSpaceRequest.createSpace(space);

        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(response.jsonPath().getString("name")).isEqualTo(SPACE_NAME);

        final Response deleteResponse = DeleteSpaceRequest.deleteSpace(response.jsonPath().getString("id"));
        Assertions.assertThat(deleteResponse.statusCode()).isEqualTo(200);
        Assertions.assertThat(deleteResponse.asString()).isEqualTo("{}");
    }
}
