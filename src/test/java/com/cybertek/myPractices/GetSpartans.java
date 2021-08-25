package com.cybertek.myPractices;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class GetSpartans {

    String myUrl = "3.89.102.26";
    String spartanUrl = "http://"+myUrl+":8000";

    @Test
    public void test1 () {

        Response response = RestAssured.get(spartanUrl + "/api/spartans"); //Getting spartans
        System.out.println(response.statusCode());          //printing statusCode from response
        System.out.println(response.body().asString());     //printing body from response in one line
        System.out.println(response.body().prettyPrint());     //printing body from response in structural way
    }

    @Test
    public void test2(){

        Response response = RestAssured.get(spartanUrl + "/api/spartans");
        Assert.assertEquals(response.statusCode(), 200);    //verify status code is 200
        Assert.assertTrue(response.body().asString().contains("Allen"));    //body contains Allen?
    }

    @Test
    public void test3(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(spartanUrl + "/api/spartans");
       Assert.assertEquals(response.statusCode(), 200);
       Assert.assertEquals(response.contentType(), "application/json");
    }

}







