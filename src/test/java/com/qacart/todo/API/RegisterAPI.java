package com.qacart.todo.API;

import com.qacart.todo.Config.APIResources;
import com.qacart.todo.Object.UserDetails;
import com.qacart.todo.Utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterAPI {

    private String accessToken;
    private List<Cookie> registerCookie;
    private String userID;

    public void register(){
        UserDetails userDetails=new UserUtils().generateUsers();
        Response response =
                given().baseUri(APIResources.BASE_URL)
                    .header("Content-Type","application/json")
                    .body(userDetails)
                .when()
                     .log().all()
                     .post(APIResources.REGISTER_RESOURCE)
                .then()
                    .log().all()
                    .assertThat().statusCode(201)
                    .extract().response();
        accessToken=response.path("access_token");
        registerCookie=response.detailedCookies().asList();
        userID=response.path("userID");


    }


    public List<Cookie> getRegisterCookie() {
        return this.registerCookie;
    }
    public String getAccessToken() {
        return accessToken;
    }
    public String getUserID() {
        return userID;
    }

}
