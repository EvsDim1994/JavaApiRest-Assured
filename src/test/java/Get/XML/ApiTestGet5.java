package Get.XML;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiTestGet5 extends HooksAPI {
    @Test
    public void test() {
        Get.XML.Specification.Instalspecification(Get.XML.Specification.requestSpec(), Specification.unigresponse(200));
        Response response = given()
                .when()
                .get("email.txt?email=admin@google.com")
                .then().log().all()
                .extract().response();

        String xmlPath = response.asString();

        Assertions.assertEquals("true", xmlPath);

    }
}
