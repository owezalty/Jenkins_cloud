package jenkins;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.Assert;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class JenkinsTests {

    @Test
    public void apiTest() {

        RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();

        //Set the base url
        spec.pathParams("first","booking","second",3);

        //Send the Get request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");

        response.prettyPrint();

        Map<String, Object> actualData = response.as(HashMap.class);

        System.out.println(actualData);

        Map<String, Object> bookingDates = (Map) actualData.get("bookingdates");

        Assert.assertEquals("Jim",actualData.get("firstname"));
        Assert.assertEquals("Jones",actualData.get("lastname"));
        Assert.assertEquals(749,actualData.get("totalprice"));
        Assert.assertEquals(false,actualData.get("depositpaid"));
        Assert.assertEquals("2015-04-25",bookingDates.get("checkin"));
        Assert.assertEquals("2017-09-24",bookingDates.get("checkout"));





    }
}
