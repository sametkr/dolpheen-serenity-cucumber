package api_spartan.stepdefinitions;

import api_spartan.POJO.Spartan;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;
public class SpartanAPITest {

    @Before
    public void setup() {
        RestAssured.baseURI = "http://54.243.27.10:8000";
    }

    @Test
    public void testCreateRetrieveUpdateDeleteSpartan() {
        // Create Spartan

        Spartan spartan = new Spartan("John Smith", "Male", 1234567890);
        Response response = SerenityRest.given().contentType("application/json").body(spartan)
                .when().post("/api/spartans")
                .then().log().body().extract().response();

        int spartanId = response.getBody().path("data.id");

        response.then().statusCode(201);

        // Retrieve Spartan
        SerenityRest.given().when().get("/api/spartans/" + spartanId)
                .then().statusCode(200)
                .body("gender", equalTo("Male"))
                .body("name", equalTo("John Smith"))
                .body("phone", equalTo(1234567890));

        // Update Spartan
        spartan.setName("Jane Doe");
        SerenityRest.given().contentType("application/json").body(spartan)
                .when().put("/api/spartans/" + spartanId)
                .then().statusCode(204);

        // Retrieve updated Spartan
        SerenityRest.given().when().get("/api/spartans/" + spartanId)
                .then().statusCode(200)
                .body("name", equalTo("Jane Doe"));

        // Delete Spartan
        SerenityRest.given().when().delete("/api/spartans/" + spartanId)
                .then().statusCode(204);

        // Validate Spartan deletion
        SerenityRest.given().when().get("/api/spartans/" + spartanId)
                .then().statusCode(404);
    }
}
