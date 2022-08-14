package Post.JSON;

import Get.JSON.HooksApi;
import Get.JSON.Specification;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiPostTest2 extends HooksApi {
    @Test
    public void test(){
        Specification.Instalspecification(Specification.requestSpec(), Specification.unigresponse(400));
        Map<String, String> users = new HashMap<>();
        users.put("email", "sydney@fife");
        Response response = given()
                .body(users)
                .when()
                .post("/api/register")
                .then().log().all()
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        String massage = jsonPath.getString("error");

        System.out.println(massage);

    }
}
