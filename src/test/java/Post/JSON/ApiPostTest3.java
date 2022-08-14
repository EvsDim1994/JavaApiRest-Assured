package Post.JSON;

import Get.JSON.HooksApi;
import Get.JSON.Specification;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiPostTest3 extends HooksApi {
    @Test
    public void test(){
        Specification.Instalspecification(Specification.requestSpec(), Specification.unigresponse(201));
        Map<String, String> users = new HashMap<>();
        users.put("name", "morpheus");
        users.put("job", "leader");

        Response response = given()
                .body(users)
                .when()
                .post("/api/users")
                .then().log().all()
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        String id = jsonPath.getString("id");
        String date = jsonPath.getString("createdAt");

        System.out.println("id:" + id + " " + date);

    }
}
