package com.cybertek.day11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static io.restassured.RestAssured.given;

public class ParametrizedTestInJunit5 {

    @ParameterizedTest
    @ValueSource(ints = {1,3,5,7,9,10,5})
    public void testMultipleNumbers(int number){

        System.out.println("Number = " + number);
         Assertions.assertTrue(number>5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"John", "Abbas", "Ali", "TJ"})
    public void testMultipleNames(String name){
        System.out.println("Name = " + name);

    }

    // SEND GET REQUEST TO https://api.zippopotam.us/us/{zipcode}
    // with these zipcodes 22030,22031, 22032, 22033 , 22034, 22035, 22036
    // check status code 200
    @ParameterizedTest
    @ValueSource(ints = {22030,22031, 22032, 22033 , 22034, 22035, 22036})
    public void testMultipleNames(int zipCode){

//        given().accept(ContentType.JSON)
//                .and()
//                .pathParam("zipcode", zipCode)
//                .get("https://api.zippopotam.us/us/{zipcode}")
//                .then()
//                .statusCode(200);

        given()
                .baseUri("https://api.zippopotam.us")
                .pathParam("zipcode",zipCode) //we got zipcode from valueSource
                .log().all() //request log
                .when()
                .get("/us/{zipcode}")
                .then().log().all() //response log
                .statusCode(200);
    }

}
