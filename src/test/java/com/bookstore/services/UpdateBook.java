package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.cucumber.java.it.Ma;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UpdateBook extends Globals {
   // String update_book_endpoint="/BookStore/v1/Books/"+isbnNumbers.get(0);

    public void updateAnExistingBook(){
        Map<String,Object> map= new HashMap<>();
        map.put("userId",userID);
        map.put("isbn",isbnNumbers.get(1));

        response= given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .body(map).log().all()
                .when()
                .put("/BookStore/v1/Books/"+isbnNumbers.get(0))
                .prettyPeek();
    }

    public void validateThatBookIsUpdated(){
        //verify status code
        Assert.assertEquals(response.statusCode(),200);

        //validate userId
        Assert.assertEquals(userID,response.path("userId"));

        //validate username
        Assert.assertEquals(username,response.path("username"));

        //validate isbn number
        Assert.assertEquals(isbnNumbers.get(1),response.path("books.isbn[0]"));
    }
}
