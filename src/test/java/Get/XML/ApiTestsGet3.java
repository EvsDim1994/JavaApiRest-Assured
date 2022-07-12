package Get.XML;

import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.element.Node;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static io.restassured.RestAssured.given;

public class ApiTestsGet3 extends HooksAPI {
    @Test
    public void test(){
        Get.XML.Specification.Instalspecification(Get.XML.Specification.requestSpec(), Get.XML.Specification.unigresponse(200));
        Response response = given()
                .when()
                .get("mac.xml?mac=00:30:48:5a:58:65")
                .then().log().all()
                .extract().response();

        XmlPath xmlPath = response.xmlPath();
        String address = xmlPath.get("macVendor.address");
        System.out.println(address);
    }
}
