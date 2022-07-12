package Get.JSON;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;


//счёт количество пользователей в data
public class ApiTestsGet3 extends HooksApi {
        @Test
        public void test(){
            Specification.Instalspecification(Specification.requestSpec(), Specification.unigresponse(200));
            Response response = given()
                    .when()
                    .get("api/users?page=2")
                    .then().log().all()
                    .body("data", notNullValue())
                    .extract().response();
                    JsonPath jsonPath = response.jsonPath();
            List<Integer> id = jsonPath.get("data.id");
            int count = 0;
            for (int i = 0; i < id.size();i++ ){
                System.out.println("id:" + id.get(i));
                count++;
            }

            System.out.println("Сейчас " + count + " пользователей");
    }
}
