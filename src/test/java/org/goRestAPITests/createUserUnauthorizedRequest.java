package org.goRestAPITests;

import Utilities.RestUtilities;
import apiConfigs.apiPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class createUserUnauthorizedRequest {

    String newUserName = RestUtilities.userNameValidValidFormat();
    String newUserEmail = RestUtilities.userEmailInValidFormat();
    String newUserGender = "male";
    String newUserStatus = "active";


    @Test
    public void createNewUserInputFile() {

        //File requestBody = new File(System.getProperty("user.dir") + "/src/test/Payloads/inputFile.json");
        JSONObject reqParams = new JSONObject();
        reqParams.put("name",newUserName);
        reqParams.put("email",newUserEmail);
        reqParams.put("gender",newUserGender);
        reqParams.put("status",newUserStatus);

        Response responseBody = given().
                body(reqParams.toJSONString()).
                //header(headers.HeaderAuthLabel,headers.AuthToken).
                        //header("Authorization", "Bearer " + headers.AuthToken).
                        header("Content-Type", "application/json").
                        when().
                        post(apiPath.CREATE_NEW_USER);

        String response = responseBody.getBody().asString();
        System.out.println(responseBody);

//Verify Status Code
        int StatusCode = responseBody.getStatusCode();
        Assert.assertEquals(StatusCode, 401);




    }
}
