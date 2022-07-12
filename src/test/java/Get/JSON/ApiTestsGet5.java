package Get.JSON;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class ApiTestsGet5 extends HooksApi {
//получение года и сравнение
    @Test
    public void test(){
        Specification.Instalspecification(Specification.requestSpec(), Specification.unigresponse(200));

        Response response = given()
                .when()
                .get("api/unknown/2")
                .then().log().all()
                .body("data.name", notNullValue())
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        Integer year = 2001;
        Integer Usyear = jsonPath.getInt("data.year");

        Assert.assertEquals(year, Usyear);


    }
}
