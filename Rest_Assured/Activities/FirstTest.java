package Examples;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FirstTest {
    //Base URI

    String baseUri= "https://petstore.swagger.io/v2/pet";

    @Test
    public void getWithQueryParam(){
        //Send a request and save the response

        Response response =

                given().header("Content_Type", "application/json").queryParam("status", "sold").
                        when().get(baseUri + "/findByStatus");

        //for response body
        System.out.println(response.asString());
        //System.out.println(response.asPrettyString());

        //for response headers
        System.out.println(response.getHeaders().asList());

        //Extract properties from response
        String petStatus= response.then().extract().path("[1].status");
        System.out.println("Status of the pet is " +petStatus);

        //Assertions
        Assert.assertEquals(petStatus,"sold");

        //RestAssured Assertions
        response.then().statusCode(200).body("[1].status",equalTo("sold"));


    }
    @Test
    public void getWithPathParam(){
        given().header("Content-Type","application/json").pathParam("petId","1").log().all().
                when().get(baseUri +"/{petId}").then().statusCode(200).body("status",equalTo("available")).log().all();
    }
}
