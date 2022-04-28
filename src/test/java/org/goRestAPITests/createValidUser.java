package org.goRestAPITests;

import Utilities.RestUtilities;
import apiConfigs.apiPath;
import apiConfigs.headers;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class createValidUser {

    String newUserName = RestUtilities.userNameValidValidFormat();
    String newUserEmail = RestUtilities.userEmailValidFormat();
    String newUserGender = "male";
    String newUserStatus = "active";


    @Test
    public void createNewUser() {

        JSONObject reqParams = new JSONObject();
        reqParams.put("name", newUserName);
        reqParams.put("email", newUserEmail);
        reqParams.put("gender", newUserGender);
        reqParams.put("status", newUserStatus);

        Response responseBody = given().
                body(reqParams.toJSONString()).
                header("Authorization", "Bearer " + headers.AuthToken).
                header("Content-Type", "application/json").
                when().
                post(apiPath.CREATE_NEW_USER);

        String response = responseBody.getBody().asString();
        System.out.println(responseBody);

//Verify Status Code
        int StatusCode = responseBody.getStatusCode();
        Assert.assertEquals(StatusCode, 201);
//Verify Name
        String nameValue = responseBody.jsonPath().get("name");
        Assert.assertEquals(nameValue, newUserName);
//Verify Email
        String emailValue = responseBody.jsonPath().get("email");
        Assert.assertEquals(emailValue, newUserEmail);
//Verify Gender
        String genderValue = responseBody.jsonPath().get("gender");
        Assert.assertEquals(genderValue, newUserGender);
//Verify Status
        String statusValue = responseBody.jsonPath().get("status");
        Assert.assertEquals(statusValue, newUserStatus);


    }
}
