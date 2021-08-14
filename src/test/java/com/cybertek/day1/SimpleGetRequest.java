package com.cybertek.day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

public class SimpleGetRequest {

    String url = "http://44.193.18.240:8000/api/spartans";

    @Test
    public void test1(){

        Response response = RestAssured.get(url);
        System.out.println(response.statusCode());

        response.prettyPrint();





    }

}
