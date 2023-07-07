package org.example.tests.e2e;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.example.requests.list.CreateListRequest;
import org.example.requests.space.CreateSpaceRequest;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class UpdateTaskE2ETest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateTaskE2ETest.class);
    private static String spaceName = "Test Space E2E";
    private static String listName = "Test Tasks E2E";
    private String spaceId;
    private String listId;

    @Test
    void udpateTaskE2ETest() {
        createSpace();
        LOGGER.info("Space created with id: {}", spaceId);
        createList(spaceId);
        LOGGER.info("List created with id: {}", listId);
    }

    private void createSpace(){
        JSONObject json = new JSONObject();
        json.put("name", spaceName);

        final Response response = CreateSpaceRequest.createSpace(json);
        Assertions.assertThat(response.statusCode()).isEqualTo(200);

        JsonPath jsonData = response.jsonPath();
        Assertions.assertThat(jsonData.getString("name")).isEqualTo(spaceName);

        spaceId = jsonData.getString("id");
    }

    private void createList(String spaceId){
        JSONObject json = new JSONObject();
        json.put("name", listName);

        final Response response = CreateListRequest.createList(json, spaceId);
        Assertions.assertThat(response.statusCode()).isEqualTo(200);

        JsonPath jsonData = response.jsonPath();
        Assertions.assertThat(jsonData.getString("name")).isEqualTo(listName);

        listId = jsonData.getString("id");
    }
}
