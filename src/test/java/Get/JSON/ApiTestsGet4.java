package Get.JSON;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


//получение статус кода 400
public class ApiTestsGet4 extends HooksApi{
    @Test
    public void test() {
        Specification.Instalspecification(Specification.requestSpec(), Specification.unigresponse(404));
        Response response = given()
                .when()
                .get("/api/unknown/23")
                .then().log().all()
                .extract().response();

        int stcode = response.statusCode();


        if(stcode == 404){
            System.out.println("Получили код 404");
        }
        else {
            System.out.println("получили что-то другое");
        }

    }
}

