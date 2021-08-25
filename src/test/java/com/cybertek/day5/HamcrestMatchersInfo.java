package com.cybertek.day5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersInfo {

    @Test
    public void simpleTest1(){

        assertThat(5+5, is(10));
        assertThat(5+5, equalTo(10));
        assertThat(5+5, is(equalTo(2+8)));

        assertThat(5+5, not(9));
        assertThat(5+5, is(not(9)));
        assertThat(5+5, is(not(equalTo(9))));

    }

    @DisplayName("Assertion with String")
    @Test
    public void stringHamcrest(){
        String text = "B22 is learning Hamcrest";

        //checking for euqality is same as numbers
        assertThat(text,is("B22 is learning Hamcrest"));
        assertThat(text,equalTo("B22 is learning Hamcrest"));
        assertThat(text,is(equalTo("B22 is learning Hamcrest")));

        //check if this text starts with B22
        assertThat(text,startsWith("B22"));
        //now do it in case insensitive manner
        assertThat(text,startsWithIgnoringCase("b22"));
        //endswith
        assertThat(text,endsWith("rest"));

        //check if text contains String learning
        assertThat(text,containsString("learning"));
        //with ignoring case
        assertThat(text,containsStringIgnoringCase("LEARNING"));

        String str ="  ";

        //check if above str is blank
        assertThat(str,blankString());
        //check if trimmed str is empty string
        assertThat(str.trim(),emptyString());
    }

        @DisplayName("Hamcrest for Collection")
        @Test
        public void testCollection(){

            List<Integer> listOfNumbers = Arrays.asList(1,4,5,6,32,54,66,77,45,23);

            //check size of the list
            assertThat(listOfNumbers,hasSize(10));
            //check if this list hasItem 77
            assertThat(listOfNumbers,hasItem(77));
            //check if this list hasItems 77,54,23
            assertThat(listOfNumbers,hasItems(77,54,23));

            //check if all numbers greater than 0
            assertThat(listOfNumbers,everyItem(greaterThan(0)));

        }
}




















