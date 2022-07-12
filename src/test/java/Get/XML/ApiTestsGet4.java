package Get.XML;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiTestsGet4 extends HooksAPI {
    @Test
    public void test(){
        Get.XML.Specification.Instalspecification(Get.XML.Specification.requestSpec(), Get.XML.Specification.unigresponse(200));
        Response response = given()
                .when()
                .get("geo.xml?ip=")
                .then().log().all()
                .extract().response();

        XmlPath xmlPath = response.xmlPath();

        String country_rus = xmlPath.get("geo_api.country_rus");
        String city_ua = xmlPath.get("geo_api.city_ua");
        Integer zip_code = xmlPath.getInt("geo_api.zip_code");

        System.out.println(country_rus + " " + city_ua + " " + zip_code);
    }
}
