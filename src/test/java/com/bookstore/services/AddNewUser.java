package com.bookstore.services;

import com.bookstore.utilities.Globals;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class AddNewUser extends Globals {

    String add_new_user_endpoint = "/Account/v1/User";
    Faker faker = new Faker();

    public void addNewUser() {
        username = faker.name().username();
        password = "Abc.!123" + faker.internet().password();

        Map<String,Object> map= new HashMap<>();
        map.put("userName",username);
        map.put("password",password);

                response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(map).log().all()
                        .post(add_new_user_endpoint)
                        .prettyPeek();
    }


    public void validateThatUserPosted(){
        //get userID from the response body
        userID = response.path("userID");

        //verify status code is 201
        Assert.assertEquals(response.statusCode(),201);

        //verify that username is correct
        Assert.assertEquals(username,response.path("username"));

    }
}
