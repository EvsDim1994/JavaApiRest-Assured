package Get.XML;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiTestsGet1 extends HooksAPI  {
    @Test
    public void test(){
        Get.XML.Specification.Instalspecification(Get.XML.Specification.requestSpec(), Specification.unigresponse(200));
        Response response = given()
                .when()
                .get("geo.xml?ip=8.8.8.8")
                .then().log().all()
                .extract().response();

        XmlPath xmlPath = response.xmlPath();
        String country = xmlPath.get("geo_api.country_code");
        String region = xmlPath.get("geo_api.region");
        String city = xmlPath.get("geo_api.city");

        if (country.equals("US")){
            System.out.println(region);
            System.out.println(city);
        }
        else {
            System.out.println("Другая страна");
        }



    }
}
