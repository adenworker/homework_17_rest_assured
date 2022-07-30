import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class TestBase{
    @BeforeAll
    public static void beforeAll(){
        RestAssured.baseURI="https://reqres.in";
    }
}
