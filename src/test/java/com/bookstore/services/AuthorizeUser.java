package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class AuthorizeUser extends Globals {
    String authorize_user_endpoint="/Account/v1/Authorized";

    public void authorizeUser(){
        Map<String,Object> map= new HashMap<>();
        map.put("userName",username);
        map.put("password",password);

        response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(map).log().all()
                .when()
                .post(authorize_user_endpoint)
                .prettyPeek();
    }


    public void validateThatUserIsAuthorized(){
        //validate status code
        Assert.assertEquals(response.statusCode(),200);

        //validate response body
        Assert.assertTrue(response.asString().contains("true"));

    }

}
