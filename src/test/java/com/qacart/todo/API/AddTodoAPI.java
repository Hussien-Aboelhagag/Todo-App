package com.qacart.todo.API;

import com.qacart.todo.Config.APIResources;
import com.qacart.todo.Object.TodoAPI;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AddTodoAPI {
    TodoAPI todoItem=new TodoAPI(false,"learn rest assured");
    public void addNewTask(String token){
        Response response=given()
                .baseUri(APIResources.BASE_URL)
                .header("Content-Type","application/json")
                .body(todoItem)
                .auth().oauth2(token)
        .when()
                .post(APIResources.ADD_TASK_RESOURCE)
        .then()
                .log().all()
                .assertThat().statusCode(201)
                .extract().response();
    }

}
