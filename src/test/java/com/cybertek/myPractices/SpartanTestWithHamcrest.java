package com.cybertek.myPractices;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SpartanTestWithHamcrest {

    @BeforeClass
    public void setUpClass(){
        String myIP = "3.89.102.26";
        baseURI = "http://" + myIP + ":8000";
    }

    @Test
    public void test1(){
                    //Request
                    given().accept(ContentType.JSON)
                    .pathParam("id", 15)
                    .when().get("/api/spartans/{id}")
                    //Response
                    .then().statusCode(200).and()
                    .assertThat().contentType("application/json");
    }

    @Test
    public void test2(){
        given().accept(ContentType.JSON)
                .pathParam("id", 16)
                .when().get("/api/spartans/{id}")
                //below we asserting with above data
                .then().assertThat().statusCode(200)
                .and().assertThat().contentType("application/json")
                .and().assertThat().body("id", equalTo(16),
                        "name", equalTo("Sinclair"),
                        "gender", equalTo("Male"), "phone", equalTo(9714460354L));
    }

}
