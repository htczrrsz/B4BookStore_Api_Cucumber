package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class GenerateToken extends Globals {

    String generate_token_endpoint="/Account/v1/GenerateToken";

    public void generateToken(){
        Map<String,Object> map = new HashMap<>();
        map.put("userName",username);
        map.put("password",password);

        response= given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(map).log().all()
                .when()
                .post(generate_token_endpoint)
                .prettyPeek();
    }


    public void validateTokenIsGenerated(){
        //get the token and assign it into a global variable
        token=response.path("token");

        //validate that status code is 200
        Assert.assertEquals(response.statusCode(),200);

        //validate that status and result values are correct
        Assert.assertEquals("Success",response.path("status"));
        Assert.assertEquals("User authorized successfully.",response.path("result"));
    }


}
