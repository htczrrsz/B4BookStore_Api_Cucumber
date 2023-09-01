package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.http.ContentType;
import org.junit.Assert;

import static io.restassured.RestAssured.*;

public class AddNewBookToUser extends Globals {
    String add_new_book_endpoint="/BookStore/v1/Books";

    public void assignNewBook(){
        String requestBody= "{\n" +
                "  \"userId\": \""+userID+"\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \""+isbnNumbers.get(0)+"\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";


        response=given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .body(requestBody).log().all()
                .when()
                .post(add_new_book_endpoint)
                .prettyPeek();


    }


    public void validateThatBookIsAssigned(){
        //validate status code
        Assert.assertEquals(response.statusCode(),201);

        //validate that isbn number is as expected
        Assert.assertEquals(isbnNumbers.get(0),response.path("books.isbn[0]"));
    }
}
