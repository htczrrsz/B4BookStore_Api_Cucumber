package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.cucumber.java.it.Ma;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DeleteBook extends Globals {
    String delete_endpoint="/BookStore/v1/Book";

    public void deleteAndExistingBook(){
        Map<String, Object> deleteBody= new HashMap<>();
        deleteBody.put("isbn",isbnNumbers.get(1));
        deleteBody.put("userId",userID);

//        System.out.println("Globals.getName() = " + Globals.getName());

        response= RestAssured
                .given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .body(deleteBody).log().all()
                .when()
                .delete(delete_endpoint);
    }

    public void validateBookIsRemoved(){
        // validate status code is 204
        Assert.assertEquals(response.statusCode(),204);

    }
}
