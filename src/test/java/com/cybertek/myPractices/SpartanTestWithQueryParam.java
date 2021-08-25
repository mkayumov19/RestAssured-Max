package com.cybertek.myPractices;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.testng.Assert.*;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SpartanTestWithQueryParam {

    @BeforeClass
    public void setUpClass(){

        String myUrl = "3.89.102.26";
        baseURI = "http://"+myUrl+":8000";
    }

    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON).and().queryParam("gender", "Female")
                .and().queryParam("nameContains", "J")
                .when().get("api/spartans/search");

        assertEquals(response.statusCode(), 200);
        assertEquals(response.contentType(), "application/json");
        assertTrue(response.body().asString().contains("Female"));
        assertFalse(response.body().asString().contains("Male"));
        assertTrue(response.body().asString().contains("Janette"));
        response.prettyPrint();

    }

    @Test
    public void test2(){
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("gender", "Female");
        paramsMap.put("nameContains", "J");

        Response response = given().accept(ContentType.JSON).and().queryParams(paramsMap).when().get("api/spartans/search");
        assertEquals(response.statusCode(), 200);
        assertEquals(response.contentType(), "application/json");
        assertTrue(response.body().asString().contains("Female"));
        assertFalse(response.body().asString().contains("Male"));
        assertTrue(response.body().asString().contains("Janette"));
        response.prettyPrint();
    }

}
