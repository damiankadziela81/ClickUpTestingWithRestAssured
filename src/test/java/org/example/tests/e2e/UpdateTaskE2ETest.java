package org.example.tests.e2e;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.example.dto.request.CreateTaskRequestDto;
import org.example.dto.response.CreateTaskResponseDto;
import org.example.requests.list.CreateListRequest;
import org.example.requests.space.CreateSpaceRequest;
import org.example.requests.task.CreateTaskRequest;
import org.example.requests.task.UpdateTaskRequest;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class UpdateTaskE2ETest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateTaskE2ETest.class);
    private static String spaceName = "Test Space E2E";
    private static String listName = "Test List E2E";
    private static String taskName = "Test Task E2E";
    private String spaceId;
    private String listId;
    private String taskId;

    @Test
    void updateTaskE2ETest() {
        createSpace();
        LOGGER.info("Space created with id: {}", spaceId);
        createList(spaceId);
        LOGGER.info("List created with id: {}", listId);
        createTask(listId);
        LOGGER.info("Task created with id: {}", taskId);
        updateTask(taskId);
        LOGGER.info("Task with id: {} updated", taskId);
    }

    private void createSpace(){
        JSONObject space = new JSONObject();
        space.put("name", spaceName);

        final Response response = CreateSpaceRequest.createSpace(space);
        Assertions.assertThat(response.statusCode()).isEqualTo(200);

        JsonPath jsonData = response.jsonPath();
        Assertions.assertThat(jsonData.getString("name")).isEqualTo(spaceName);

        spaceId = jsonData.getString("id");
    }

    private void createList(String spaceId){
        JSONObject list = new JSONObject();
        list.put("name", listName);

        final Response response = CreateListRequest.createList(list, spaceId);
        Assertions.assertThat(response.statusCode()).isEqualTo(200);

        JsonPath jsonData = response.jsonPath();
        Assertions.assertThat(jsonData.getString("name")).isEqualTo(listName);

        listId = jsonData.getString("id");
    }

    private void createTask(String listId) {
        CreateTaskRequestDto taskDto = new CreateTaskRequestDto();
        taskDto.setName(taskName);
        taskDto.setDescription("test description");
        taskDto.setStatus("to do");

        final CreateTaskResponseDto response = CreateTaskRequest.createTask(taskDto, listId);
        Assertions.assertThat(response.getName()).isEqualTo(taskName);
        Assertions.assertThat(response.getDescription()).isEqualTo("test description");
        Assertions.assertThat(response.getStatus().getStatus()).isEqualTo("to do");

        LOGGER.info("CREATE TASK RESPONSE OBJ: {}", response);
        taskId = response.getId();
    }

    private void updateTask(String taskId) {
        JSONObject updatedTask = new JSONObject();
        updatedTask.put("name", "Test task renamed");
        updatedTask.put("description", "changed description");

        final Response response = UpdateTaskRequest.updateTask(updatedTask, taskId);
        Assertions.assertThat(response.statusCode()).isEqualTo(200);

        JsonPath json = response.jsonPath();
        Assertions.assertThat(json.getString("name")).isEqualTo("Test task renamed");
        Assertions.assertThat(json.getString("description")).isEqualTo("changed description");
    }
}
