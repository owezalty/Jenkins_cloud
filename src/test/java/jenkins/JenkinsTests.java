package jenkins;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

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

        Map<String, Object> bookingdates = (Map)actualData.get("bookingdates");

        Assert.assertEquals("Jim",actualData.get("firstname"));
        Assert.assertEquals("Jackson",actualData.get("lastname"));
        Assert.assertEquals(982,actualData.get("totalprice"));
        Assert.assertEquals(false,actualData.get("depositpaid"));

        Assert.assertEquals("2018-12-06",bookingdates.get("checkin"));
        Assert.assertEquals("2019-09-05",bookingdates.get("checkout"));




    }
}
