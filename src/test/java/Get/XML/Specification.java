package Get.XML;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {
    public static RequestSpecification requestSpec (){
        return new RequestSpecBuilder()
                .setContentType(ContentType.XML)
                .build();
    }

    public static ResponseSpecification unigresponse (int status){
        return new ResponseSpecBuilder()
                .expectStatusCode(status)
                .build();
    }


    public static void Instalspecification (RequestSpecification requst, ResponseSpecification response){
        RestAssured.requestSpecification = requst;
        RestAssured.responseSpecification = response;
    }
}

