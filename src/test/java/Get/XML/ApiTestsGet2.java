package Get.XML;

import com.codeborne.selenide.Selenide;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class ApiTestsGet2 extends HooksAPI {
    @Test
    public void test(){
        Get.XML.Specification.Instalspecification(Get.XML.Specification.requestSpec(), Get.XML.Specification.unigresponse(200));
        Response response = given()
                .when()
                .get("hosting.xml?site=google.com")
                .then().log().all()
                .body("hosting_api", notNullValue())
                .extract().response();

        XmlPath xmlPath = response.xmlPath();
        String URL = xmlPath.get("hosting_api.site");
        String URL1 = "https://www.google.com/";
        Assertions.assertEquals(URL, URL1);

        Selenide.open(URL);

    }
}
