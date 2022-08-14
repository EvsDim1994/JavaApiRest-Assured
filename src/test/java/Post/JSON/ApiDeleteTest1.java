package Post.JSON;

import Get.JSON.HooksApi;
import Get.JSON.Specification;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiDeleteTest1 extends HooksApi {
    @Test
    public void test() {
        Specification.Instalspecification(Specification.requestSpec(), Specification.unigresponse(204));
        Response response = given()
                .when()
                .delete("/api/users/2")
                .then().log().all()
                .extract().response();
    }
}
