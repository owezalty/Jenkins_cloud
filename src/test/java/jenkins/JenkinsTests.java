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

        Assert.assertEquals("Mary",actualData.get("firstname"));
        Assert.assertEquals("Ericsson",actualData.get("lastname"));
        Assert.assertEquals(921,actualData.get("totalprice"));
        Assert.assertEquals(true,actualData.get("depositpaid"));
        Assert.assertEquals("2019-01-17",bookingDates.get("checkin"));
        Assert.assertEquals("2022-02-16",bookingDates.get("checkout"));





    }
}
