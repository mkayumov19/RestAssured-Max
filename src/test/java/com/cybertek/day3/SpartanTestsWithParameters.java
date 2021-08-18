package com.cybertek.day3;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanTestsWithParameters {

    @BeforeAll
    public static void init() {
        baseURI = "http://52.207.61.129:8000";

    }
        /*
          Given accept type is Json
          And Id parameter value is 5
          When user sends GET request to /api/spartans/{id}
          Then response status code should be 200
          And response content-type: application/json
          And "Blythe" should be in response payload
       */

        @DisplayName("GET request to /api/spartans/{id} with ID 5")
        @Test
        public void test1(){

            Response responce = given().accept(ContentType.JSON)
                    .and().pathParam("id", 5)
                    .when().get("/api/spartans/{id}");
            assertEquals(200, responce.statusCode());
            assertEquals("application/json", responce.contentType());
            assertTrue(responce.body().asString().contains("Blythe"));

        }

         /*
       TASK
        Given accept type is Json
        And Id parameter value is 500
        When user sends GET request to /api/spartans/{id}
        Then response status code should be 404
        And response content-type: application/json
        And "Not Found" message should be in response payload
     */
    @DisplayName("GET request to /api/spartans/{id} ")
    @Test
    public void test2(){

        Response response = given().accept(ContentType.JSON).and()
                .pathParam("id", 500)
                .when().get("/api/spartans/{id}");
        assertEquals(404, response.statusCode());
        assertEquals("application/json", response.contentType());
        assertTrue(response.body().asString().contains("Not Found"));

    }

    @DisplayName("GET request to /api/spartans/search with Query Params")
    @Test
    public void test3(){
        Response response= given().log().all().
                accept(ContentType.JSON)
                .and().queryParam("nameContains","e")
                .and().queryParam("gender","Female")
                .when()
                .get("/api/spartans/search");

        //verify status code 200
        assertEquals(200,response.statusCode());
        //verify content type
        assertEquals("application/json",response.contentType());
        //verify NotFound in the json payload/body

        //"Female" should be in response payload
        assertTrue(response.body().asString().contains("Female"));
        //"Janette" should be in response payload
        assertTrue(response.body().asString().contains("Janette"));

    }

    @DisplayName("GET request to /api/spartans/search with Query Params (MAP)")
    @Test
    public void test4(){
        //create a map and add query parameters
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("nameContains","e");
        queryMap.put("gender","Female");

        Response response = given().
                log().all()
                .accept(ContentType.JSON)
                .and().queryParams(queryMap)
                .when()
                .get("/api/spartans/search");

        //verify status code 200
        assertEquals(200,response.statusCode());
        //verify content type
        assertEquals("application/json",response.contentType());
        //verify NotFound in the json payload/body

        //"Female" should be in response payload
        assertTrue(response.body().asString().contains("Female"));
        //"Janette" should be in response payload
        assertTrue(response.body().asString().contains("Janette"));

    }

}




















