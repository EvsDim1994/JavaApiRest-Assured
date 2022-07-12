package Post.JSON;

import Get.JSON.HooksApi;
import Get.JSON.Specification;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiPostTests1 extends HooksApi {
    @Test
    public void test(){
        Specification.Instalspecification(Specification.requestSpec(), Specification.unigresponse(200));
        Map<String, String> users = new HashMap<>();
        users.put("email", "eve.holt@reqres.in");
        users.put("password", "cityslicka");
        Response response = given()
                .body(users)
                .when()
                .post("/api/login")
                .then().log().all()
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        String token = jsonPath.get("token");

        System.out.println(token);
    }
}
