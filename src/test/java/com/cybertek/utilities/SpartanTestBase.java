package com.cybertek.utilities;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.baseURI;

public abstract class SpartanTestBase {

    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = "http://52.207.61.129:8000";

        //get ip address from configuraitons
    }

}
