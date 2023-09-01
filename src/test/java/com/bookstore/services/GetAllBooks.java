package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

public class GetAllBooks extends Globals {
    String getAllBooksEndpoint="/BookStore/v1/Books";

    public void getAllBooks(){
      response = RestAssured
              .given().log().all()
              .when()
              .get(getAllBooksEndpoint)
              .prettyPeek();
    }


    public void validateThatAllBooksAreListed(){
//        assert status code
        Assert.assertEquals(response.statusCode(),200);

        response.then()
                .assertThat()
                .statusCode(200);

        
//        get the data by jsonpath object
        JsonPath jsonPath=response.jsonPath();
        isbnNumbers =  jsonPath.getList("books.isbn");
        
        //validate that all isbn numbers has value
        isbnNumbers.forEach(n -> Assert.assertNotNull(n));
        
    }


}
