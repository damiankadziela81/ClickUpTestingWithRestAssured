package org.example.tests;

import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.example.requests.space.CreateSpaceRequest;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

class CreateSpaceTest {

    @Test
    void createSpaceTest(){

        JSONObject space = new JSONObject();
        space.put("name", "MY SPACE FROM JAVA");

        final Response response = CreateSpaceRequest.createSpace(space);

        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(response.jsonPath().getString("name")).isEqualTo("MY SPACE FROM JAVA");
    }
}
