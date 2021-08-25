package com.cybertek.myPractices;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SpartanTestWithPathParams {

    @BeforeClass
    public void setUpClass(){

        String myUrl = "3.89.102.26";
        RestAssured.baseURI = "http://"+myUrl+":8000";
    }

    @Test
    public void pathTest1(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 18)
                .when().get("/api/spartans/{id}");
        assertEquals(response.statusCode(), 200);
        assertEquals(response.contentType(), "application/json");
        assertTrue(response.body().asString().contains("Allen"));
        response.body().prettyPrint();
    }

    @Test
    public void negativeParamTest(){

        Response response = RestAssured.given().accept(ContentType.JSON).and().pathParam("id", 200)
                .when().get("/api/spartans/{id}");
        assertEquals(response.statusCode(), 404);
        assertEquals(response.contentType(), "application/json");
        assertTrue(response.body().asString().contains("Not Found"));
    }

}
