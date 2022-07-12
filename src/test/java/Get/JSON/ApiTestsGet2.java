package Get.JSON;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class ApiTestsGet2 extends HooksApi {
//проверка и вывод URL + проверка на совпадение текста в text
    @Test
    public void Test2() {
        Specification.Instalspecification(Specification.requestSpec(), Specification.unigresponse(200));

        Response response = given()
                .when()
                .get("api/users/2")
                .then().log().all()
                .body("support.url",notNullValue())
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String url = jsonPath.get("support.url");
        System.out.println(url);
        String text = "To keep ReqRes free, contributions towards server costs are appreciated!";
        Assert.assertEquals(text, jsonPath.get("support.text"));
    }
}
