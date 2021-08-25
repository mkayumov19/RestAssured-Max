package com.cybertek.myPractices;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

public class SpartanTestWithPath {

    @BeforeClass
    public void setUpClass(){
        String myUrl = "3.89.102.26";
        baseURI = "http://"+myUrl+":8000";
    }

    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON).and().pathParam("id", 10)
                .when().get("/api/spartans/{id}");
        assertEquals(response.statusCode(), 200);
        assertEquals(response.contentType(), "application/json");

        System.out.println(response.body().path("id").toString());
        System.out.println(response.body().path("name").toString());
        System.out.println(response.path("gender").toString());
        System.out.println(response.path("phone").toString());

        int id = response.path("id");
        String name = response.path("name");
        String gender = response.path("gender");
        long phone = response.path("phone");

        System.out.println(id);
        System.out.println(name);
        System.out.println(gender);
        System.out.println(phone);

        assertEquals(id, 10);
        assertEquals(name, "Lorenza");
        assertEquals(gender, "Female");
        assertEquals(phone, 3312820936l);

    }

    @Test
    public void test2(){
        Response response = get("/api/spartans");
        int firstID = response.path("id[0]");
        System.out.println("firstID = " + firstID);

        String firs1sttName = response.path("name[0]");
        System.out.println("firs1sttName = " + firs1sttName);
        
        String last1stName = response.path("name[-1]");
        System.out.println("last1stName = " + last1stName);

        List<String> names = response.path("name");
        System.out.println("Names = " + names);
        System.out.println("Names size= " + names.size());

        List<Object> phoneNums = response.path("phone");
        for (Object phoneNumber : phoneNums) {
            System.out.println(phoneNumber);
        }


    }

}
