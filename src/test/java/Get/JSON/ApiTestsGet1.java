package Get.JSON;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

// проверка окончания почты на reqres.in и наличия ссылок в avatar
public class ApiTestsGet1 extends HooksApi {
    @Test
    public void Test1() {
        Specification.Instalspecification(Specification.requestSpec(), Specification.unigresponse(200));

        Response response = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .body("page", equalTo(2))
                .body("data.avatar", notNullValue())
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        List<String> emails = jsonPath.get("data.email");

        for (int i = 0; i < emails.size(); i++){
            System.out.println(emails.get(i));
            Assert.assertTrue(emails.get(i).endsWith("reqres.in"));
        }
    }

}


