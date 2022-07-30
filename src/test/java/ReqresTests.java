import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class ReqresTests extends TestBase {
    @Test
    void RegistrationTest() {
        given()
                .contentType(JSON)
                .body("{ \"name\": \"morpheus\", \"job\": \"leader\" }")
                .when()
                .post("/api/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("job", is("leader"));
    }
@Test
    void loginTest() {
        String body = "{ \"email\": \"eve.holt@reqres.in\", " +
                "\"password\": \"cityslicka\" }";

        given()
                .contentType(JSON)
                .body(body)
                .when()
                .post("/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    void singleUserTest() {
        given()
                .contentType(JSON)
                .when()
                .get("/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.first_name", is("Janet"));
    }

    @Test
    void deleteUser() {
        given()
                .contentType(JSON)
                .when()
                .delete("/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(204);
    }
    @Test
    void userNotFondTest() {
        given()
                .contentType(JSON)
                .when()
                .get("/api/users/23")
                .then()
                .log().status()
                .log().body()
                .statusCode(404);

    }

}
