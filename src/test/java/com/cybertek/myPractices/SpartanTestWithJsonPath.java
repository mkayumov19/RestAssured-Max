package com.cybertek.myPractices;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

public class SpartanTestWithJsonPath {

    @BeforeClass
    public void setUpClass(){
        String myIP = "3.89.102.26";
        baseURI = "http://" + myIP + ":8000";
    }

    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON).pathParam("id", 11)
                .when().get("/api/spartans/{id}");
        assertEquals(response.statusCode(), 200);
        int id = response.path("id");
        System.out.println(id);

        //How to read value with JsonPath
        JsonPath jsonData = response.jsonPath();

        int id1 = jsonData.getInt("id");
        String name = jsonData.getString("name");
        String gender = jsonData.getString("gender");
        long phone = jsonData.getLong("phone");

        System.out.println(id1);
        System.out.println(name);
        System.out.println(gender);
        System.out.println(phone);

        //verify json payload/body with JsonPath
        assertEquals(id1, 11);
        assertEquals(name, "Nona");
        assertEquals(gender, "Female");
        assertEquals(phone, 7959094216l);

    }

}
