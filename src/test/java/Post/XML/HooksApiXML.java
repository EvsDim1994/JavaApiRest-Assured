package Post.XML;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public class HooksApiXML {
    @BeforeEach
    public void beforeRestAssured(){
        RestAssured.baseURI = "http://restapi.adequateshop.com";
    }
}
