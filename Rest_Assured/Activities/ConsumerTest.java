package liveProject;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import au.com.dius.pact.core.model.annotations.Pact;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@ExtendWith(PactConsumerTestExt.class)

public class ConsumerTest {
    Map<String, String> headers = new HashMap<>();

    @Pact(consumer = "UserConsumer", provider= "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder){

        headers.put("Content-Type","application/json");

        DslPart requestBody = new PactDslJsonBody().
                numberType("id",125).
                stringType("firstName","Ravina").
                stringType("lastName","Solanke").
                stringType("email","ravinasolanke@gmail.com");

        DslPart responseBody = new PactDslJsonBody().
                numberType("id",125).
                stringType("firstName","Ravina").
                stringType("lastName","Solanke").
                stringType("email","ravinasolanke@gmail.com");

        return builder.given("POST Request").
                uponReceiving("A request to create a user").
                method("POST").path("/api/users").headers(headers).body(requestBody).
                willRespondWith().status(201).body(responseBody).toPact();
    }


    @Test
    @PactTestFor(providerName="UserProvider", port="8181")
    public void consumerTest(){
        Map<String, Object> reqBody = new HashMap<>();

        reqBody.put("id",125);
        reqBody.put("firstName","Ravina");
        reqBody.put("lastName","Solanke");
        reqBody.put("email","ravinasolanke@gmail.com");

        given().headers(headers).body(reqBody).
                when().post("http://localhost:8181/api/users").
                then().statusCode(201);


    }
}
