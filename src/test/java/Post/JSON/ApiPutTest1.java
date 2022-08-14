package Post.JSON;

import Get.JSON.HooksApi;
import Get.JSON.Specification;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiPutTest1 extends HooksApi {
    @Test
    public void test() {
        Specification.Instalspecification(Specification.requestSpec(), Specification.unigresponse(200));
        Map<String, String> users = new HashMap<>();
        users.put("name", "morpheus");
        users.put("job", "zion resident");

        Response response = given()
                .body(users)
                .when()
                .put("/api/users/2")
                .then().log().all()
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        String job = jsonPath.getString("job");

        Assertions.assertEquals("zion resident", job);


    }
}
