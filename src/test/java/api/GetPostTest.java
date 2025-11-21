package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetPostTest {

    @Test
    public void verifyPostData() {

        Response response = RestAssured
                .given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1");

        // Status code validation
        Assert.assertEquals(response.getStatusCode(), 200);

        // Body validation
        Assert.assertEquals(response.jsonPath().getInt("userId"), 1);
        Assert.assertEquals(response.jsonPath().getInt("id"), 1);
    }
}
