package Post.XML;

import Get.XML.Specification;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ApiPutTest1 extends HooksApiXML {
        @Test
        public void test() {
            Get.XML.Specification.Instalspecification(Get.XML.Specification.requestSpec(), Specification.unigresponse(200));
            File file = new File("src/test/java/Post/XML/XMLReq2");
            Response response = given()
                    .body(file)
                    .when()
                    .put("/api/Traveler/90")
                    .then().log().all()
                    .extract().response();

            XmlPath xmlPath = response.xmlPath();

            String id = xmlPath.getString("Travelerinformation.id");
            String email = xmlPath.getString("Travelerinformation.email");
            System.out.println(" ");
            System.out.println("id: " + id + " " + email);
        }
    }

