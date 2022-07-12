package Get.XML;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public class HooksAPI {
    @BeforeEach
    public void beforeRestAssured(){
        RestAssured.baseURI = "https://api.2ip.ua/";
    }
}
