package com.cybertek.day10;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GovXmlTest {

    @Test
    public void test1(){

        //send a get request to
        //https://data.ct.gov/api/views/qm34-pq7e/rows.xml
        //get all the years
        //get all unknowns
        //get 2006 other
        //get 2007 _address

        Response response = given()
                .get("https://data.ct.gov/api/views/qm34-pq7e/rows.xml")
                .then().statusCode(200)
                .extract().response();

        XmlPath xmlPath = response.xmlPath();
        List<String> allYears = xmlPath.getList("response.row.row.year");
        System.out.println("allYears = " + allYears);

        List<String> allUnknowns = xmlPath.getList("response.row.row.unknown");
        System.out.println("allUnknowns = " + allUnknowns);

        String year2006 = xmlPath.getString("response.row.row[2].other");
        System.out.println("Year 2005 = " + year2006);

        String address2007 = xmlPath.getString("response.row.row[4].@_address");
        System.out.println("address = " + address2007);

    }

}
